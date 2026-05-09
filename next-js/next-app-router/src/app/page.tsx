
async function getData() {
  const res = await fetch('https://jsonplaceholder.typicode.com/posts/1', { cache: 'force-cache' });
  const data = await res.json();
  return data;
}

export default async function Home() {
  const res = await fetch('https://fakestoreapi.com/products/1', { cache: 'no-store'});
  const data = await res.json();
  const post = await getData();
  return (
    <main>
      <h1>Home (SSG)</h1>
      <p>{data.title}</p>
      <br />
      SSG
      <h1>{post.title}</h1>
      <p>{post.body}</p>
    </main>
  );
}