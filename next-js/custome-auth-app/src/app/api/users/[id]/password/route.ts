// app/api/users/[id]/password/route.ts

import { NextResponse } from "next/server"
import prisma from "@/lib/prisma"
import { hash, compare } from "bcryptjs"

export async function PATCH(
    req: Request,
    { params }: { params: Promise<{ id: string}> }
) {
    const { id } = await params
    const { currentPassword, newPassword } = await req.json()

    if (!currentPassword || !newPassword) {
        return NextResponse.json(
            { error: "currentPassword and newPassword are required" },
            { status: 400 }
        )
    }

    const user = await prisma.user.findUnique({ where: { id: Number(id) } })
    if (!user) {
        return NextResponse.json({ error: "User not found" }, { status: 404 })
    }

    const valid = await compare(currentPassword, user.password)
    if (!valid) {
        return NextResponse.json(
            { error: "Current password is incorrect" },
            { status: 401 }
        )
    }

    const hashed = await hash(newPassword, 10)
    await prisma.user.update({
        where: { id: Number(id) },
        data: { password: hashed },
    })

    return NextResponse.json({ ok: true })
}
