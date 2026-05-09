// src/app/profile/[id]/DeleteUserButton.tsx
'use client'

import React, { useState } from 'react'
import { useRouter } from 'next/navigation'
import DeleteModal from '@/components/DeleteModal'
import { handleDeleteUser } from './actions'

interface DeleteUserButtonProps {
    userId: number
}

export default function DeleteUserButton({ userId }: DeleteUserButtonProps) {
    const [showModal, setShowModal] = useState(false)
    const router = useRouter()

    async function handleConfirm() {
        
        const res = await handleDeleteUser(userId);

        console.log(res);

        if (res.success) {
            // navigate elsewhere after delete
            router.push('/')
        } else {
            const payload = await res.json()
            console.error('Delete failed:', payload.error)
            setShowModal(false)
        }
    }

    return (
        <>
            <button
                onClick={() => setShowModal(true)}
                className="mt-4 px-4 py-2 bg-red-500 text-white rounded hover:bg-red-600"
            >
                Delete Account
            </button>

            <DeleteModal
                visible={showModal}
                onConfirm={handleConfirm}
                onCancel={() => setShowModal(false)}
            />
        </>
    )
}
