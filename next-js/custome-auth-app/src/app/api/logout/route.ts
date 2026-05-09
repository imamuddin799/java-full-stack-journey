// app/api/logout/route.ts

import prisma from "@/lib/prisma"
import { verifyRefresh } from "@/lib/jwt"
import { clearCookie } from "@/lib/cookies"
import { NextResponse } from "next/server"

export async function POST(req: Request): Promise<NextResponse> {
  // 1. Extract the raw refresh token from the cookie header
  const cookieHeader = req.headers.get("cookie") || ""
  const match        = decodeURIComponent(cookieHeader).match(/refresh=([^;]+)/)

  // 2. Prepare response and clear both cookies
  const res = NextResponse.json({ ok: true })
  clearCookie(res, "access")
  clearCookie(res, "refresh")

  // 3. If there was no refresh cookie, we’re done
  if (!match) return res

  // 4. Verify the JWT and extract the jti claim
  const rawToken = match[1]
  const payload  = await verifyRefresh(rawToken)
  const jti      = payload?.jti

  // 5. Mark that token as revoked (updateMany won’t throw if nothing’s found)
  if (jti) {
    await prisma.refreshToken.updateMany({
      where: { token: jti },
      data:  { revoked: true },
    })
  }

  return res
}