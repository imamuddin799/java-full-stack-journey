'use client';

import { useEffect, useState } from 'react';
import Link from 'next/link';
import { getEmployees, deleteEmployee, updateEmployee, Employee } from '../lib/api';
import dynamic from 'next/dynamic';

const EmployeeCard = dynamic(() => import('../components/EmployeeCard'), { ssr: false });

export default function HomePage() {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [selected, setSelected] = useState<Employee | null>(null);
  const [showModal, setShowModal] = useState(false);
  const [formData, setFormData] = useState<Employee | null>(null);

  useEffect(() => {
    getEmployees().then(setEmployees);
  }, []);

  const handleDelete = async (emp: Employee) => {
    if (emp.id) await deleteEmployee(emp.id);
    setEmployees(await getEmployees());
    setSelected(null);
  };

  const handleEdit = (emp: Employee) => {
    setFormData(emp);      // Pre-fill the form with selected employee
    setShowModal(true);    // Show modal
  };

  const handleSave = async () => {
    if (formData?.id) {
      await updateEmployee(formData.id, formData);
      setEmployees(await getEmployees());
      setShowModal(false);
      setSelected(null);
    }
  };


  return (
    <div className="p-6 max-w-6xl mx-auto">
      <h1 className="text-3xl font-bold mb-6">Employee Management</h1>
      <Link href="/add" className="bg-blue-600 text-white px-4 py-2 rounded mb-4 inline-block">Add Employee</Link>
      <table className="w-full table-auto mt-4 border text-left">
        <thead>
          <tr className="bg-gray-100">
            <th className="p-2 border">Name</th>
            <th className="p-2 border">Email</th>
            <th className="p-2 border">Department</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((emp: Employee) => (
            <tr key={emp.id} onClick={() => setSelected(emp)} className="cursor-pointer hover:bg-gray-100">
              <td className="border p-2">{emp.name}</td>
              <td className="border p-2">{emp.email}</td>
              <td className="border p-2">{emp.job?.department}</td>
            </tr>
          ))}
        </tbody>
      </table>

      {selected && (
        <EmployeeCard
          emp={selected}
          onEdit={handleEdit}
          onDelete={handleDelete}
        />
      )}

      {showModal && (
        <div className="fixed inset-0 bg-black bg-opacity-30 flex items-center justify-center z-50">
          <div className="bg-white rounded-lg p-6 w-full max-w-md shadow-lg">
            <h3 className="text-xl font-semibold mb-4">Edit Employee</h3>

            <div className="space-y-3">
              <input className="w-full border p-2" placeholder="Name" value={formData?.name || ''} onChange={e => formData && setFormData({ ...formData, name: e.target.value })} />
              <input className="w-full border p-2" placeholder="Email" value={formData?.email || ''} onChange={e => formData && setFormData({ ...formData, email: e.target.value })} />
              <input className="w-full border p-2" placeholder="Address" value={formData?.address || ''} onChange={e => formData && setFormData({ ...formData, address: e.target.value })} />
              <input
                className="w-full border p-2"
                placeholder="Job Title"
                value={formData?.job?.title || ''}
                onChange={e => formData && setFormData({ ...formData, job: { title: e.target.value, department: formData.job?.department || '', salary: formData.job?.salary || 0 } })}
              />
              <input
                className="w-full border p-2"
                placeholder="Department"
                value={formData?.job?.department || ''}
                onChange={e => formData && setFormData({ ...formData, job: { title: formData.job?.title || '', department: e.target.value, salary: formData.job?.salary || 0 } })}
              />
              <input
                className="w-full border p-2"
                placeholder="Salary"
                type="number"
                value={formData?.job?.salary || ''}
                onChange={e => formData && setFormData({ ...formData, job: { title: formData.job?.title || '', department: formData.job?.department || '', salary: parseInt(e.target.value) || 0 } })}
              />
            </div>

            <div className="mt-4 flex justify-end gap-2">
              <button onClick={handleSave} className="bg-green-500 px-4 py-2 rounded text-white">Save</button>
              <button onClick={() => setShowModal(false)} className="bg-gray-300 px-4 py-2 rounded">Cancel</button>
            </div>
          </div>
        </div>
      )}

    </div>
  );
}
