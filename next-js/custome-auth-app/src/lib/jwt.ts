// lib/jwt.ts
import { SignJWT, jwtVerify } from 'jose'

const encoder = new TextEncoder()

if (!process.env.ACCESS_TOKEN_SECRET) {
    throw new Error('Missing ACCESS_TOKEN_SECRET in env')
}
if (!process.env.REFRESH_TOKEN_SECRET) {
    throw new Error('Missing REFRESH_TOKEN_SECRET in env')
}

const ACCESS_SECRET = encoder.encode(process.env.ACCESS_TOKEN_SECRET)
const REFRESH_SECRET = encoder.encode(process.env.REFRESH_TOKEN_SECRET)

export async function signAccess(sub: string) {
    return new SignJWT({ sub })
        .setProtectedHeader({ alg: 'HS256' })
        .setIssuedAt()
        .setExpirationTime('15m')
        .sign(ACCESS_SECRET)
}

export async function verifyAccess(token: string) {
    try {
        const { payload } = await jwtVerify(token, ACCESS_SECRET)
        return payload as { sub: string; iat: number; exp: number }
    } catch (error: unknown) {
        const msg = error instanceof Error ? error.message : String(error)
        console.error('verifyAccess error:', msg)
        return null
    }
}

export async function signRefresh(sub: string, jti: string) {
    return new SignJWT({ sub })
        .setProtectedHeader({ alg: 'HS256' })
        .setIssuedAt()
        .setExpirationTime('7d')
        .setJti(jti)
        .sign(REFRESH_SECRET)
}

export async function verifyRefresh(token: string) {
    try {
        const { payload } = await jwtVerify(token, REFRESH_SECRET)
        return payload as {
            sub: string
            iat: number
            exp: number
            jti: string
        }
    } catch (error: unknown) {
        const msg = error instanceof Error ? error.message : String(error)
        console.error('verifyRefresh error:', msg)
        return null
    }
}
