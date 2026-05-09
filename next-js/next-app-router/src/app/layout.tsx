export const metadata = {
  title: {
    default: 'Home',
    template: '%s | Next JS'
  }
}

import Link from "next/link";
export default function Layout({ children }: { children: React.ReactNode }) {
  return (
    <html>
      <body>
        <nav>
          <Link href="/">Home</Link> | <Link href="/about">About</Link> | <Link href="/contact">Contact</Link> | <Link href="/user">User</Link> | <Link href="/products">Products</Link>
        </nav>
        {children}
      </body>
    </html>
  );
}