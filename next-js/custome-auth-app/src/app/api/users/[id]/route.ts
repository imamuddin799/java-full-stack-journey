// app/api/users/[id]/route.ts

import { NextRequest, NextResponse } from "next/server"
import prisma from "@/lib/prisma"

export async function GET( req: NextRequest, { params }: { params: Promise<{ id: string }> } ) {
    const { id } = await params;
    const url = new URL(req.url)
    const email = url.searchParams.get("email")

    const user = await prisma.user.findUnique({
        where: email ? { email } : { id: Number(id) },
        select: {
            id: true,
            email: true,
            totpSecret: true,
            createdAt: true,
            // exclude password
        },
    })

    if (!user) {
        return NextResponse.json({ error: "User not found" }, { status: 404 })
    }
    return NextResponse.json(user)
}

export async function PATCH(
    req: NextRequest,
    { params }: { params: Promise<{ id: string }> }
) {
    const { id } = await params;
    const updates = await req.json();

    // disallow password changes here
    delete updates.password

    try {
        const updated = await prisma.user.update({
            where: { id: Number(id) },
            data: {
                // only allow email & totpSecret
                email: updates.email,
                totpSecret: updates.totpSecret,
            },
            select: {
                id: true,
                email: true,
                totpSecret: true,
                createdAt: true,
            },
        })
        return NextResponse.json(updated)
    } catch (error) {
        console.log(error);
        return NextResponse.json(
            { error: "Update failed" },
            { status: 400 }
        )
    }
}

export async function DELETE( req: NextRequest, { params }: { params: Promise< { id: string } >} ) {
    const { id } = await params;
    console.log('User id to delete account>>>', id);
    const userId = Number(id);

    console.log('Deleting user with id >>>', userId);

    // 1) Ensure user exists
    const user = await prisma.user.findUnique({ where: { id: userId } })
    if (!user) {
        return NextResponse.json(
            { error: "User not found" },
            { status: 404 }
        )
    }

    // 2) Remove all refresh tokens for that user
    await prisma.refreshToken.deleteMany({
        where: { userId },
    })

    // 3) Delete the user
    await prisma.user.delete({
        where: { id: userId },
    })

    // 4) Return success
    return NextResponse.json({ ok: true }, { status: 200 })
}