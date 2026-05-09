import prisma from "@/lib/prisma";
import { authenticator } from "otplib";
import { NextResponse } from "next/server";

export async function POST(req: Request) {
    const { userId, token } = await req.json();
    const user = await prisma.user.findUnique({ where: { id: userId } });
    if (!user?.totpSecret) return NextResponse.json({ error: "Not enrolled" }, { status: 400 });
    const valid = authenticator.verify({ token, secret: user.totpSecret });
    return valid
        ? NextResponse.json({ ok: true })
        : NextResponse.json({ error: "Invalid code" }, { status: 401 });
}
