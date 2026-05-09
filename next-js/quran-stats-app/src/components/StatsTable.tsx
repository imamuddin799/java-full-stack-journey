interface Stat {
  category: string;
  value: number | string;
}

interface StatsTableProps {
  data: Stat[];
}

import TanStackTable from './TanStackTable';
import { createColumnHelper } from '@tanstack/react-table';

const columnHelper = createColumnHelper<any>();

const columns = [
  columnHelper.accessor('category', {
    header: 'Category',
  }),
  columnHelper.accessor('value', {
    header: 'Value',
  }),
];

export default function StatsTable({ data }: StatsTableProps) {
  return <TanStackTable data={data} columns={columns} />;
}
