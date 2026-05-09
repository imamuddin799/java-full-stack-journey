import { NextRequest, NextResponse } from 'next/server'
import { verifyAccess } from '@/lib/jwt'

export const config = {
    matcher: [
        '/((?!_next/static|_next/image|favicon.ico).*)',
    ],
}

export async function middleware(req: NextRequest) {

    console.log('Middleware is running>>>', req.nextUrl.pathname);
    const { pathname } = req.nextUrl
    const token = req.cookies.get('access')?.value
    const user = token && (await verifyAccess(token))

    // Always skip Next.js internals
    if (pathname.startsWith('/_next') || pathname === '/favicon.ico') {
        return NextResponse.next()
    }

    // Public API endpoints
    if (
        pathname.startsWith('/api/login') ||
        pathname.startsWith('/api/register')
    ) {
        return NextResponse.next()
    }

    // Pages that require no auth
    if (!user) {
        if (['/login', '/register'].includes(pathname)) {
            return NextResponse.next()
        }
        return NextResponse.redirect(new URL('/login', req.url))
    }

    // Authenticated API calls
    if (pathname.startsWith('/api/')) {
        const apiHeaders = new Headers(req.headers)
        apiHeaders.set('x-user-id', user.sub)
        return NextResponse.next({ request: { headers: apiHeaders } })
    }

    // Redirect logged-in users away from auth pages
    if (['/login', '/register'].includes(pathname)) {
        return NextResponse.redirect(new URL('/dashboard', req.url))
    }

    // Inject user header into dashboard pages
    if (pathname.startsWith('/dashboard')) {
        const headers = new Headers(req.headers)
        headers.set('x-user-id', user.sub)
        return NextResponse.next({ request: { headers } })
    }

    return NextResponse.next()
}