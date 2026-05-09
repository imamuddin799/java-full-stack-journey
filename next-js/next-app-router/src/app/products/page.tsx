export const metadata = {
  title: {
    default: 'Products'
  },
  description: 'Products page',
}
// app/products/page.tsx
export default async function Page() {
  const res = await fetch('https://fakestoreapi.com/products', { cache: "no-store" });
  const data = await res.json();
  // return <pre>{JSON.stringify(data, ['id', 'title'], 2)}</pre>;
  return <pre>{JSON.stringify(data, null, 4)}</pre>;
}