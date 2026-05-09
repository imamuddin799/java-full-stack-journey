"use client"

import { useState, FormEvent } from "react"
import { useRouter } from "next/navigation"

interface User {
    id: number
    email: string
    totpSecret: string | null
    createdAt: string
}

export default function DashboardClient({ user }: { user: User }) {
    const router = useRouter()

    // modal states
    const [showEdit, setShowEdit] = useState(false)
    const [showPwd, setShowPwd] = useState(false)
    const [showDel, setShowDel] = useState(false)

    // edit form
    const [email, setEmail] = useState(user.email)
    const [editError, setEditError] = useState<string | null>(null)
    const emailRegex = /^\S+@\S+\.\S+$/

    // password form
    const [currentPwd, setCurrentPwd] = useState("")
    const [newPwd, setNewPwd] = useState("")
    const [confirmNewPwd, setConfirmNewPwd] = useState("")
    const [pwdError, setPwdError] = useState<string | null>(null)
    const minPwdLength = 8

    // delete form
    const [confirmText, setConfirmText] = useState("")
    const deleteEnabled = confirmText === "DELETE"

    // 1. Update profile (email)
    async function handleUpdate(e: FormEvent) {
        e.preventDefault()
        setEditError(null)

        if (!emailRegex.test(email)) {
            setEditError("Please enter a valid email address.")
            return
        }

        const res = await fetch(`/api/users/${user.id}`, {
            method: "PATCH",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email }),
        })

        if (res.ok) {
            setShowEdit(false)
            router.refresh()
        } else {
            const body = await res.json().catch(() => ({}))
            setEditError(body.error || "Failed to update email.")
        }
    }

    // 2. Change password
    async function handlePwd(e: FormEvent) {
        e.preventDefault()
        setPwdError(null)

        if (!currentPwd) {
            setPwdError("Current password is required.")
            return
        }
        if (newPwd.length < minPwdLength) {
            setPwdError(`New password must be at least ${minPwdLength} characters.`)
            return
        }
        if (newPwd !== confirmNewPwd) {
            setPwdError("New passwords do not match.")
            return
        }

        const res = await fetch(`/api/users/${user.id}/password`, {
            method: "PATCH",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ currentPassword: currentPwd, newPassword: newPwd }),
        })

        if (res.ok) {
            setShowPwd(false)
            setCurrentPwd("")
            setNewPwd("")
            setConfirmNewPwd("")
        } else {
            const body = await res.json().catch(() => ({}))
            setPwdError(body.error || "Failed to change password.")
        }
    }

    // 3. Delete account
    async function handleDelete() {
        if (!deleteEnabled) return
        const res = await fetch(`/api/users/${user.id}`, { method: "DELETE" })
        if (res.ok) {
            await fetch("/api/logout", { method: "POST" })
            router.push("/login")
        }
    }

    // 4. Logout
    async function handleLogout() {
        await fetch("/api/logout", { method: "POST" })
        router.push("/login")
    }

    return (
        <div className="min-h-screen bg-gray-100 flex flex-col items-center p-6">
            <div className="w-full max-w-2xl bg-white rounded shadow p-8">
                <h1 className="text-3xl font-bold mb-4">Welcome to Your Dashboard</h1>
                <p className="mb-2"><strong>Email:</strong> {user.email}</p>
                <p className="mb-2">
                    <strong>MFA Enabled:</strong> {user.totpSecret ? "Yes" : "No"}
                </p>
                <p className="mb-6">
                    <strong>Member since:</strong>{" "}
                    {new Date(user.createdAt).toLocaleDateString()}
                </p>

                <div className="flex space-x-3">
                    <button
                        onClick={() => setShowEdit(true)}
                        className="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
                    >
                        Edit Profile
                    </button>
                    <button
                        onClick={() => setShowPwd(true)}
                        className="px-4 py-2 bg-green-500 text-white rounded hover:bg-green-600"
                    >
                        Change Password
                    </button>
                    <button
                        onClick={() => setShowDel(true)}
                        className="px-4 py-2 bg-red-500 text-white rounded hover:bg-red-600"
                    >
                        Delete Account
                    </button>
                    <button
                        onClick={handleLogout}
                        className="px-4 py-2 bg-gray-700 text-white rounded hover:bg-gray-800"
                    >
                        Logout
                    </button>
                </div>
            </div>

            {/* Edit Profile Modal */}
            {showEdit && (
                <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
                    <form
                        onSubmit={handleUpdate}
                        className="bg-white p-6 rounded shadow-lg w-full max-w-md"
                    >
                        <h2 className="text-xl font-semibold mb-4">Edit Profile</h2>
                        <label className="block mb-2">
                            New Email
                            <input
                                type="email"
                                value={email}
                                onChange={e => setEmail(e.target.value)}
                                className="w-full mt-1 p-2 border rounded"
                                required
                            />
                        </label>
                        {editError && (
                            <p className="text-red-600 text-sm mb-2">{editError}</p>
                        )}
                        <div className="mt-4 flex justify-end space-x-2">
                            <button
                                type="button"
                                onClick={() => setShowEdit(false)}
                                className="px-4 py-2 bg-gray-300 rounded hover:bg-gray-400"
                            >
                                Cancel
                            </button>
                            <button
                                type="submit"
                                className="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
                            >
                                Save
                            </button>
                        </div>
                    </form>
                </div>
            )}

            {/* Change Password Modal */}
            {showPwd && (
                <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
                    <form
                        onSubmit={handlePwd}
                        className="bg-white p-6 rounded shadow-lg w-full max-w-md"
                    >
                        <h2 className="text-xl font-semibold mb-4">Change Password</h2>
                        <label className="block mb-2">
                            Current Password
                            <input
                                type="password"
                                value={currentPwd}
                                onChange={e => setCurrentPwd(e.target.value)}
                                className="w-full mt-1 p-2 border rounded"
                                required
                            />
                        </label>
                        <label className="block mb-2">
                            New Password
                            <input
                                type="password"
                                value={newPwd}
                                onChange={e => setNewPwd(e.target.value)}
                                className="w-full mt-1 p-2 border rounded"
                                required
                            />
                        </label>
                        <label className="block mb-2">
                            Confirm New Password
                            <input
                                type="password"
                                value={confirmNewPwd}
                                onChange={e => setConfirmNewPwd(e.target.value)}
                                className="w-full mt-1 p-2 border rounded"
                                required
                            />
                        </label>
                        {pwdError && (
                            <p className="text-red-600 text-sm mb-2">{pwdError}</p>
                        )}
                        <div className="mt-4 flex justify-end space-x-2">
                            <button
                                type="button"
                                onClick={() => setShowPwd(false)}
                                className="px-4 py-2 bg-gray-300 rounded hover:bg-gray-400"
                            >
                                Cancel
                            </button>
                            <button
                                type="submit"
                                className="px-4 py-2 bg-green-500 text-white rounded hover:bg-green-600"
                            >
                                Update
                            </button>
                        </div>
                    </form>
                </div>
            )}

            {/* Delete Account Modal */}
            {showDel && (
                <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
                    <div className="bg-white p-6 rounded shadow-lg w-full max-w-sm">
                        <h2 className="text-xl font-semibold mb-4 text-red-600">
                            Confirm Deletion
                        </h2>
                        <p className="mb-4">
                            Type <strong>DELETE</strong> below to confirm account deletion.
                        </p>
                        <input
                            type="text"
                            value={confirmText}
                            onChange={e => setConfirmText(e.target.value)}
                            placeholder="Type DELETE to confirm"
                            className="w-full mb-4 p-2 border rounded"
                        />
                        <div className="flex justify-end space-x-2">
                            <button
                                onClick={() => setShowDel(false)}
                                className="px-4 py-2 bg-gray-300 rounded hover:bg-gray-400"
                            >
                                Cancel
                            </button>
                            <button
                                onClick={handleDelete}
                                disabled={!deleteEnabled}
                                className={`px-4 py-2 rounded text-white ${deleteEnabled
                                        ? "bg-red-600 hover:bg-red-700"
                                        : "bg-red-300 cursor-not-allowed"
                                    }`}
                            >
                                Delete
                            </button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    )
}
