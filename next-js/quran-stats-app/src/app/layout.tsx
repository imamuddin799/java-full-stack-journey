import type { Metadata } from "next";
import { Inter } from "next/font/google";
import "./globals.css";
import Link from "next/link";

// const geistSans = Geist({
//   variable: "--font-geist-sans",
//   subsets: ["latin"],
// });

// const geistMono = Geist_Mono({
//   variable: "--font-geist-mono",
//   subsets: ["latin"],
// });
const inter = Inter({ subsets: ['latin'] });
export const metadata: Metadata = {
  title: 'Quran Statistics',
  description: 'Complete Quran basic statistics with search and filter',
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en" dir="ltr">
      <body className={inter.className}>
        <nav className="bg-blue-600 text-white p-4 shadow-lg">
          <div className="max-w-6xl mx-auto flex justify-between items-center">
            <Link href="/" className="text-2xl font-bold">📖 Quran Stats</Link>
            <Link href="/chapters" className="bg-white text-blue-600 px-4 py-2 rounded hover:bg-gray-100">Chapters</Link>
          </div>
        </nav>
        <main className="max-w-6xl mx-auto p-6 min-h-screen">
          {children}
        </main>
      </body>
    </html>
  );
}

