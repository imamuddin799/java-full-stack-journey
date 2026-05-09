// src/components/DeleteModal.tsx
'use client'

import React from 'react'

interface DeleteModalProps {
    visible: boolean
    onConfirm: () => void
    onCancel: () => void
}

export default function DeleteModal({
    visible,
    onConfirm,
    onCancel,
}: DeleteModalProps) {
    if (!visible) return null

    return (
        <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50">
            <div className="bg-white rounded-lg shadow-lg w-11/12 max-w-sm p-6">
                <h2 className="text-xl font-semibold mb-4 text-black">Confirm Deletion</h2>
                <p className="mb-6 text-black">Are you sure you want to delete your account?</p>
                <div className="flex justify-end space-x-3">
                    <button
                        onClick={onCancel}
                        className="px-4 py-2 rounded bg-gray-700 hover:bg-gray-900 text-white"
                    >
                        Cancel
                    </button>
                    <button
                        onClick={onConfirm}
                        className="px-4 py-2 rounded bg-red-500 text-white hover:bg-red-600"
                    >
                        Delete
                    </button>
                </div>
            </div>
        </div>
    )
}
