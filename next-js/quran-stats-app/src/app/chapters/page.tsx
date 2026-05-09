'use client';

import { useState, useMemo, type ReactNode } from 'react';
import { chapters, Chapter } from '@/data/quran-stats';
import type { ColumnDef } from '@tanstack/react-table'
import { createColumnHelper } from '@tanstack/react-table'
import { DataTable } from '@/components/DataTable'

export default function ChaptersPage() {
  const [search, setSearch] = useState('');
  // const [currentPage, setCurrentPage] = 1;
  // const PAGE_SIZE = 20;

  const filteredChapters = useMemo(() => {
    return chapters.filter(chapter =>
      chapter.name.toLowerCase().includes(search.toLowerCase()) ||
      chapter.id.toString().includes(search) ||
      chapter.verses.toString().includes(search) ||
      chapter.words.toString().includes(search) ||
      chapter.chars.toString().includes(search)
    );
  }, [search]);

  const highlightText = (text: string, query: string): ReactNode => {
    if (!query.trim()) return text;

    const lowerText = text.toLowerCase();
    const lowerQuery = query.toLowerCase().trim();

    if (!lowerText.includes(lowerQuery)) return text;

    const parts: React.ReactNode[] = [];
    let lastIndex = 0;
    let index = lowerText.indexOf(lowerQuery, lastIndex);
    while (index !== -1) {
      parts.push(text.slice(lastIndex, index));
      parts.push(
        <mark key={index} className="bg-yellow-300 px-1 rounded font-semibold">
          {text.slice(index, index + lowerQuery.length)}
        </mark>
      );
      lastIndex = index + lowerQuery.length;
      index = lowerText.indexOf(lowerQuery, lastIndex);
    }
    parts.push(text.slice(lastIndex));
    return parts;
  };

  const columnHelper = createColumnHelper<Chapter>()

  const columns = [
    columnHelper.display({
      id: 'serial',
      header: 'Serial',
      cell: ({ row, table }) => {
        const sortedRows = table.getSortedRowModel().rows;
        const serialNo = sortedRows.findIndex(r => r.id === row.id) + 1;
        return <strong className="text-lg text-green-600">{serialNo}</strong>;
      },
      enableSorting: false,
      footer: '',
    }),
    columnHelper.accessor('id', {
      header: 'Surah #',
      cell: ({ row }) => highlightText(row.original.id.toString(), search),
      footer: 'Total',
    }),
    columnHelper.accessor('name', {
      header: 'Name',
      cell: ({ row }) => <span className="font-bold text-blue-600">{highlightText(row.original.name, search)}</span>,
      footer: '',
    }),
    columnHelper.accessor('verses', {
      header: 'Verses',
      cell: ({ row }) => highlightText(row.original.verses.toString(), search),
      footer: chapters.reduce((acc, chapter) => acc + chapter.verses, 0).toLocaleString('en-US'),
    }),
    columnHelper.accessor('words', {
      header: 'Words',
      cell: ({ row }) => highlightText(row.original.words.toString(), search),
      footer: chapters.reduce((acc, chapter) => acc + chapter.words, 0).toLocaleString('en-US'),
    }),
    columnHelper.accessor('chars', {
      header: 'Letters',
      cell: ({ row }) => highlightText(row.original.chars.toString(), search),
      footer: chapters.reduce((acc, chapter) => acc + chapter.chars, 0).toLocaleString('en-US'),
    }),
  ]

  return (
    <div>
      <h1 className="text-4xl font-bold text-center mb-12 text-gray-800">Surah Statistics</h1>
      
      <div className="mb-8">
        <input
          type="text"
          placeholder="Search by name, surah number, verses, words, letters..."
          className="w-full max-w-md p-4 border border-gray-300 rounded-lg shadow-sm focus:ring-2 focus:ring-blue-500 focus:border-blue-500 text-left"
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />
      </div>

      <DataTable columns={columns as ColumnDef<Chapter>[]} data={filteredChapters} />

      <div className="mt-4 text-center text-sm text-gray-500">
        Results: {filteredChapters.length}
      </div>
    </div>
  );
}
