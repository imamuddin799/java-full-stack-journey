// app/(auth)/mfa/page.tsx
"use client"

import { useState } from "react"

// interface MFAProps {
//     userId: string
// }

export default function MFA() {
    const [token, setToken] = useState<string>("")

    async function verify(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault()


        const res = await fetch("/api/mfa/verify", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ token }),
        })

        if (res.ok) {
            window.location.href = "/dashboard"
        } else {
            // handle error (e.g. show a message)
        }
    }

    function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
        setToken(e.target.value)
    }

    return (
        <form onSubmit={verify}>
            <input
                name="token"
                type="text"
                value={token}
                onChange={handleChange}
                placeholder="123456"
                required
            />
            <button type="submit">Verify MFA</button>
        </form>
    )
}
