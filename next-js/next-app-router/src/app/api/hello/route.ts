// /app/api/hello/route.ts
import { NextResponse } from 'next/server';

export async function GET() {
    console.log('Get method called');
    return NextResponse.json({ message: 'Hello from Next.js App Router API!' });
}