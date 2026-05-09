# Serial Column Fix TODO

## Pending Steps\r\n- [x] Edit quran/quran-stats-app/src/app/chapters/page.tsx to update serial column cell for stable numbering\r\n- [ ] Test search and sorting to verify serial always starts from 1\r\n\r\n## Completed Steps\r\n- Edited page.tsx serial column to use `table.getSortedRowModel().rows.indexOf(row) + 1` for stable 1-based numbering across search/sort

## Completed Steps

