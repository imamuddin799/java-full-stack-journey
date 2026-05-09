// src/app/profile/[id]/EditUserButton.tsx
'use client'

import React, { useState } from 'react'
import { useRouter } from 'next/navigation'
import EditUserModal from '@/components/EditUserModal'
import { updateUser } from './actions'

interface User {
    id: number
    username: string
    email: string
    password: string
}

interface EditUserButtonProps {
    user: User
}

export default function EditUserButton({ user }: EditUserButtonProps) {
    const [show, setShow] = useState(false)
    const router = useRouter()

    async function handleUpdate(formData: FormData) {
        console.log(formData.get('username'));
        const res = await updateUser(user.id.toString(), formData);

        if (!res.success) {
            console.error('Update failed:', res.error)
            return
        }

        // close modal and refresh page data
        setShow(false)
        router.refresh()
    }

    return (
        <>
            <button
                onClick={() => setShow(true)}
                className="mt-4 px-4 py-2 bg-green-500 text-white rounded hover:bg-green-600"
            >
                Edit Profile
            </button>

            <EditUserModal
                visible={show}
                user={user}
                onSave={handleUpdate}
                onCancel={() => setShow(false)}
            />
        </>
    )
}
