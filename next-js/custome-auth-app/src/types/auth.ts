// types/auth.ts

import { RefreshToken as PrismaRefreshToken } from '@prisma/client'

export interface LoginRequest {
    email: string
    password: string
}

// ← userId must be a number (Int in Prisma schema)
export interface CreateRefreshTokenDto {
    userId: number
    token: string
    device: string
    ip: string
    userAgent: string
    expiresAt: Date
}

export type RefreshTokenRecord = PrismaRefreshToken
