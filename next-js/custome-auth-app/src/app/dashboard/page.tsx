// app/dashboard/page.tsx
import { cookies as getCookies } from "next/headers"
import { redirect } from "next/navigation"
import { verifyAccess } from "@/lib/jwt"
import prisma from "@/lib/prisma"
import DashboardClient from "./DashboardClient"

export default async function DashboardPage() {
    const cookies = await getCookies();
    const token = cookies.get("access")?.value
    if (!token) redirect("/login")

    const payload = await verifyAccess(token)
    if (!payload) redirect("/login")

    const rawUser = await prisma.user.findUnique({
        where: { id: Number(payload.sub) },
        select: { id: true, email: true, totpSecret: true, createdAt: true },
    })
    if (!rawUser) redirect("/login")

    // convert the Date → string so it matches DashboardClient’s User type
    const user = {
        id: rawUser.id,
        email: rawUser.email,
        totpSecret: rawUser.totpSecret,
        createdAt: rawUser.createdAt.toISOString(),
    }

    return <DashboardClient user={user} />
}
