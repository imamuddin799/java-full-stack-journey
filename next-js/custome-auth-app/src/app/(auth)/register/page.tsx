"use client"

import { useRouter } from "next/navigation"
import { FormEvent, useState } from "react"

export default function Register() {
    const router = useRouter()
    const [loading, setLoading] = useState(false)
    const [error, setError] = useState<string | null>(null)

    async function onSubmit(e: FormEvent<HTMLFormElement>) {
        e.preventDefault()
        setError(null)
        setLoading(true)

        const formData = new FormData(e.currentTarget)
        const email = String(formData.get("email"))
        const password = String(formData.get("password"))

        const res = await fetch("/api/register", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email, password }),
        })

        setLoading(false)
        if (res.ok) {
            router.push("/login?registered=true")
        } else {
            const body = await res.json().catch(() => ({}))
            setError(body.error || "Registration failed. Please try again.")
        }
    }

    return (
        <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-indigo-100 to-blue-200 p-6">
            <div className="w-full max-w-md bg-white rounded-xl shadow-lg p-8 space-y-6">
                <h1 className="text-3xl font-extrabold text-gray-900 text-center">
                    Create your account
                </h1>

                {error && (
                    <div className="bg-red-100 border border-red-300 text-red-700 px-4 py-2 rounded">
                        {error}
                    </div>
                )}

                <form onSubmit={onSubmit} className="space-y-4">
                    <div>
                        <label
                            htmlFor="email"
                            className="block text-sm font-medium text-gray-700"
                        >
                            Email address
                        </label>
                        <input
                            id="email"
                            name="email"
                            type="email"
                            required
                            className="mt-1 block w-full px-3 py-2 border border-gray-300 
                         rounded-md shadow-sm placeholder-gray-400 
                         focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
                        />
                    </div>

                    <div>
                        <label
                            htmlFor="password"
                            className="block text-sm font-medium text-gray-700"
                        >
                            Password
                        </label>
                        <input
                            id="password"
                            name="password"
                            type="password"
                            required
                            className="mt-1 block w-full px-3 py-2 border border-gray-300 
                         rounded-md shadow-sm placeholder-gray-400 
                         focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
                        />
                    </div>

                    <button
                        type="submit"
                        disabled={loading}
                        className={`w-full flex justify-center py-2 px-4 
              text-white font-medium rounded-md shadow-sm 
              focus:outline-none focus:ring-2 focus:ring-offset-2 
              ${loading
                                ? "bg-indigo-300 cursor-not-allowed"
                                : "bg-indigo-600 hover:bg-indigo-700 focus:ring-indigo-500"
                            }`}
                    >
                        {loading ? "Creating…" : "Register"}
                    </button>
                </form>

                <p className="text-center text-sm text-gray-600">
                    Already have an account?{" "}
                    <a
                        href="/login"
                        className="font-medium text-indigo-600 hover:text-indigo-800"
                    >
                        Sign in
                    </a>
                </p>
            </div>
        </div>
    )
}