import { NextResponse } from "next/server";

export function setCookie(res: NextResponse, name: string, value: string, maxAge: number) {
    res.cookies.set({ name, value, httpOnly: true, path: "/", maxAge, sameSite: "lax", secure: process.env.NODE_ENV === "production" });
}

export function clearCookie(res: NextResponse, name: string) {
    res.cookies.set({ name, value: "", httpOnly: true, path: "/", maxAge: 0 });
}
