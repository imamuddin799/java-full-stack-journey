'use client';

import React from 'react';
import { Employee } from '../lib/api';

export default function EmployeeCard({ emp, onEdit, onDelete }: {
    emp: Employee;
    onEdit: (emp: Employee) => void;
    onDelete: (emp: Employee) => void;
}) {
    return (
        <div className="border rounded-lg p-4 shadow-md bg-white max-w-xl mx-auto mt-6">
            <h2 className="text-xl font-bold">{emp.name}</h2>
            <p className="text-gray-600">{emp.email}</p>
            <p className="mt-2"><strong>Address:</strong> {emp.address}</p>
            <p><strong>Title:</strong> {emp.job?.title}</p>
            <p><strong>Department:</strong> {emp.job?.department}</p>
            <p><strong>Salary:</strong> ₹{emp.job?.salary}</p>
            <div className="mt-4 space-x-4">
                <button onClick={() => onEdit(emp)} className="px-4 py-2 bg-yellow-400 text-white rounded">Edit</button>
                <button onClick={() => onDelete(emp)} className="px-4 py-2 bg-red-500 text-white rounded">Delete</button>
            </div>
        </div>
    );
}
