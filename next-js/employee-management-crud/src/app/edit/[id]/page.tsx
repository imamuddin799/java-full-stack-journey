'use client';

import { useRouter, useParams } from 'next/navigation';
import React, { useEffect, useState } from 'react';
import { getEmployee, updateEmployee } from '../../../lib/api';

export default function EditPage() {
  const router = useRouter();
  const params = useParams();
  const id = parseInt(params.id as string);

  const [name, setName] = useState('');
  const [email, setEmail] = useState('');

  useEffect(() => {
    getEmployee(id).then(emp => {
      setName(emp.name);
      setEmail(emp.email);
    });
  }, [id]);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    await updateEmployee(id, { name, email });
    router.push('/');
  };

  return (
    <div className="p-6 max-w-xl mx-auto">
      <h2 className="text-2xl font-bold mb-4">Edit Employee</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        <input className="w-full border p-2" value={name} onChange={e => setName(e.target.value)} />
        <input className="w-full border p-2" value={email} onChange={e => setEmail(e.target.value)} />
        <button className="bg-yellow-500 text-white px-4 py-2 rounded">Update</button>
      </form>
    </div>
  );
}
