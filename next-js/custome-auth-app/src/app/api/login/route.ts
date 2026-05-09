// app/api/login/route.ts

import { compare } from 'bcryptjs'
import { randomUUID } from 'crypto'
import prisma from '@/lib/prisma'
import { signAccess, signRefresh } from '@/lib/jwt'
import { setCookie } from '@/lib/cookies'
import { NextResponse } from 'next/server'
import type { LoginRequest, CreateRefreshTokenDto } from '@/types/auth'

export async function POST(req: Request): Promise<NextResponse> {
    const { email, password } = (await req.json()) as LoginRequest

    const user = await prisma.user.findUnique({ where: { email } })
    if (!user || !(await compare(password, user.password))) {
        return NextResponse.json({ error: 'Invalid credentials' }, { status: 401 })
    }

    const ua = req.headers.get('user-agent') ?? 'unknown'
    const ip = req.headers.get('x-forwarded-for')?.split(',')[0] ?? '0.0.0.0'
    const tokenId = randomUUID()

    const tokenPayload: CreateRefreshTokenDto = {
        userId: user.id,
        token: tokenId,
        device: ua.slice(0, 200),
        ip,
        userAgent: ua.slice(0, 200),
        expiresAt: new Date(Date.now() + 7 * 24 * 3600e3),
    }

    // Persist the refresh token without assigning to a variable
    await prisma.refreshToken.create({ data: tokenPayload })

    // Await both JWT calls
    const accessToken = await signAccess(String(user.id))
    const refreshToken = await signRefresh(String(user.id), tokenId)

    const res = NextResponse.json({ ok: true })
    setCookie(res, 'access', accessToken, 15 * 60)
    setCookie(res, 'refresh', refreshToken, 7 * 24 * 3600)
    return res
}
