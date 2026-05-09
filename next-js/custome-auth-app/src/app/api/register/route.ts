import { NextRequest, NextResponse } from "next/server";
import { hash } from "bcryptjs";
import { Prisma } from "@prisma/client";
import prisma from "@/lib/prisma";

export async function POST(req: NextRequest) {
    const { email, password } = await req.json();
    const hashed = await hash(password, 10);

    try {
        await prisma.user.create({
            data: { email, password: hashed },
        });
        return NextResponse.json({ ok: true }, { status: 201 });
    } catch (error) {
        // 1) Base check on P2002
        if (
            error instanceof Prisma.PrismaClientKnownRequestError &&
            error.code === "P2002"
        ) {
            return NextResponse.json(
                { error: "Email is already registered" },
                { status: 409 }
            );
        }

        // 2) Log unexpected errors
        console.error(error);
        return NextResponse.json(
            { error: "Internal server error" },
            { status: 500 }
        );
    }
}
