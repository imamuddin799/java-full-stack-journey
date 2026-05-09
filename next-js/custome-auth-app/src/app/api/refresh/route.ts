// app/api/refresh/route.ts

import { randomUUID } from 'crypto'
import prisma from '@/lib/prisma'
import { verifyRefresh, signAccess, signRefresh } from '@/lib/jwt'
import { setCookie } from '@/lib/cookies'
import { NextRequest, NextResponse } from 'next/server'
import type { CreateRefreshTokenDto } from '@/types/auth'

export async function POST(req: NextRequest): Promise<NextResponse> {
    // 1. extract refresh cookie
    const cookieHeader = req.headers.get('cookie') || ''
    const match = decodeURIComponent(cookieHeader).match(/refresh=([^;]+)/)
    if (!match) {
        return NextResponse.json({ error: 'No token' }, { status: 401 })
    }
    const rawToken = match[1]

    // 2. verify JWT
    const payload = await verifyRefresh(rawToken)
    if (!payload) {
        return NextResponse.json({ error: 'Invalid token' }, { status: 401 })
    }

    // 3. fetch and validate old token
    const oldToken = await prisma.refreshToken.findUnique({
        where: { id: Number(payload.jti) },
    })
    if (!oldToken || oldToken.expiresAt < new Date() || oldToken.revoked) {
        return NextResponse.json({ error: 'Expired or revoked' }, { status: 401 })
    }

    // 4. revoke old token
    await prisma.refreshToken.update({
        where: { id: Number(payload.jti) },
        data: { revoked: true },
    })

    // 5. create new token record
    const newJti = randomUUID()
    const newPayload: CreateRefreshTokenDto = {
        userId: Number(payload.sub),
        token: newJti,
        device: oldToken.device,
        ip: oldToken.ip,
        userAgent: oldToken.userAgent,
        expiresAt: new Date(Date.now() + 7 * 24 * 3600e3),
    }
    await prisma.refreshToken.create({ data: newPayload })

    // 6. sign fresh tokens
    const newAccess = await signAccess(payload.sub)
    const newRefresh = await signRefresh(payload.sub, newJti)

    // 7. respond and set cookies
    const res = NextResponse.json({ ok: true })
    setCookie(res, 'access', newAccess, 15 * 60)
    setCookie(res, 'refresh', newRefresh, 7 * 24 * 3600)
    return res
}
