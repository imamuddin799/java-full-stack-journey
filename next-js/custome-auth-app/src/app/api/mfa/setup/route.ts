import prisma from "@/lib/prisma";
import { authenticator } from "otplib";
import { NextResponse } from "next/server";
import qrcode from "qrcode";

export async function POST(req: Request) {
    const { userId } = await req.json(); // secure this in real flow
    const secret = authenticator.generateSecret();
    await prisma.user.update({ where: { id: userId }, data: { totpSecret: secret } });
    const otpauth = authenticator.keyuri("user@example.com", "NextApp", secret);
    const qr = await qrcode.toDataURL(otpauth);
    return NextResponse.json({ qr, secret });
}
