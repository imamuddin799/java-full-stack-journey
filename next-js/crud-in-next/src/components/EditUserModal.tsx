// src/components/EditUserModal.tsx
'use client'

interface User {
    id: number
    username: string
    email: string
    password: string
}

interface EditUserModalProps {
    visible: boolean
    user: User
    onSave: (formData: FormData) => Promise<void>
    onCancel: () => void
}

export default function EditUserModal({
    visible,
    user,
    onSave,
    onCancel,
}: EditUserModalProps) {

    if (!visible) return null;

    return (
        <div className="fixed inset-0 bg-black bg-opacity-40 flex items-center justify-center z-50">
            <form action={onSave}
                className="bg-white rounded-lg shadow-lg w-11/12 max-w-md p-6"
            >
                <h2 className="text-xl font-semibold mb-4 text-black">Edit Profile</h2>

                <label className="block mb-2 text-sm font-medium text-black">Username</label>
                <input
                    type="text"
                    name="username"
                    defaultValue={user.username}
                    className="w-full mb-4 px-3 py-2 border rounded text-black"
                    required
                />

                <label className="block mb-2 text-sm font-medium text-black">Email</label>
                <input
                    type="email"
                    name="email"
                    defaultValue={user.email}
                    className="w-full mb-4 px-3 py-2 border rounded text-black"
                    required
                />

                <label className="block mb-2 text-sm font-medium text-black">Password</label>
                <input
                    type="password"
                    name="password"
                    defaultValue={user.password}
                    placeholder="•••••• (leave blank to keep)"
                    className="w-full mb-6 px-3 py-2 border rounded text-black"
                />

                <div className="flex justify-end space-x-3">
                    <button
                        type="button"
                        onClick={onCancel}
                        className="px-4 py-2 bg-gray-600 rounded hover:bg-gray-700"
                    >
                        Cancel
                    </button>
                    <button
                        type="submit"
                        className="px-4 py-2 bg-blue-600 text-white rounded hover:bg-blue-700"
                    >
                        Update
                    </button>
                </div>
            </form>
        </div>
    )
}
