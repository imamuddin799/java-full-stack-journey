'use client';

import { useRouter } from 'next/navigation';
import React, { useState } from 'react';
import { addEmployee } from '../../lib/api';

export default function AddPage() {
  const router = useRouter();
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    await addEmployee({ name, email });
    router.push('/');
  };

  return (
    <div className="p-6 max-w-xl mx-auto">
      <h2 className="text-2xl font-bold mb-4">Add Employee</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        <input placeholder="Name" className="w-full border p-2" value={name} onChange={e => setName(e.target.value)} required />
        <input placeholder="Email" className="w-full border p-2" value={email} onChange={e => setEmail(e.target.value)} required />
        <button className="bg-green-600 text-white px-4 py-2 rounded">Add</button>
      </form>
    </div>
  );
}
