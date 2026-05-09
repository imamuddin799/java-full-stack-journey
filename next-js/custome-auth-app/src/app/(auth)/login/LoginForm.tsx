// app/(auth)/login/LoginForm.tsx
'use client'

import { useRouter } from 'next/navigation'
import { FormEvent, useState, useEffect } from 'react'

interface Props {
    registered: boolean
}

export default function LoginForm({ registered }: Props) {
    console.log('New reg>>>',registered);
    const router = useRouter()
    const [loading, setLoading] = useState(false)
    const [error, setError] = useState<string | null>(null)
    const [showSuccess, setShowSuccess] = useState(registered)

    useEffect(() => {
        if (registered) {
            const timer = setTimeout(() => setShowSuccess(false), 5000)
            return () => clearTimeout(timer)
        }
    }, [registered])

    async function onSubmit(e: FormEvent<HTMLFormElement>) {
        e.preventDefault()
        setError(null)
        setLoading(true)

        const formData = new FormData(e.currentTarget)
        const email = String(formData.get('email'))
        const password = String(formData.get('password'))

        const res = await fetch('/api/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password }),
        })

        setLoading(false)
        if (res.ok) {
            router.push('/dashboard')
        } else {
            const body = await res.json().catch(() => ({}))
            setError(body.error || 'Login failed. Please try again.')
        }
    }

    return (
        <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-indigo-100 to-blue-200 p-6">
            <div className="w-full max-w-md bg-white rounded-xl shadow-lg p-8 space-y-6">
                <h1 className="text-3xl font-extrabold text-gray-900 text-center">
                    Sign in to Your Account
                </h1>

                {showSuccess && (
                    <div className="bg-green-100 border border-green-300 text-green-800 px-4 py-2 rounded">
                        Your account has been created successfully. Please sign in below.
                    </div>
                )}

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

                    <div className="flex items-center justify-between text-sm">
                        <a
                            href="/forgot-password"
                            className="text-indigo-600 hover:text-indigo-800"
                        >
                            Forgot password?
                        </a>
                    </div>

                    <button
                        type="submit"
                        disabled={loading}
                        className={`w-full flex justify-center py-2 px-4 
              text-white font-medium rounded-md shadow-sm 
              focus:outline-none focus:ring-2 focus:ring-offset-2 
              ${loading
                                ? 'bg-indigo-300 cursor-not-allowed'
                                : 'bg-indigo-600 hover:bg-indigo-700 focus:ring-indigo-500'
                            }`}
                    >
                        {loading ? 'Signing in…' : 'Sign In'}
                    </button>
                </form>

                <p className="text-center text-sm text-gray-600">
                    Don’t have an account?{' '}
                    <a
                        href="/register"
                        className="font-medium text-indigo-600 hover:text-indigo-800"
                    >
                        Register
                    </a>
                </p>
            </div>
        </div>
    )
}
