import { NextResponse, NextRequest } from 'next/server';

export const config = {
    matcher: [
        '/api/:function*',
        '/:path*'
    ]
}

export function middleware(request: NextRequest) {
    // You can add your middleware logic here
    // For example, you can log the request or modify it
    console.log('Middleware is running for:', request.url);

    // If you want to continue processing the request, return a Response
    return NextResponse.next();
}