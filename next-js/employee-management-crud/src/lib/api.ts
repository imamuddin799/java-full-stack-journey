const API = 'http://localhost:5000/employees';

export interface Employee {
  id?: number;
  name: string;
  email: string;
  address?: string;
  job?: {
    title: string;
    department: string;
    salary: number;
  };
}

export async function getEmployees(): Promise<Employee[]> {
  const res = await fetch(API);
  return res.json();
}

export async function getEmployee(id: number): Promise<Employee> {
  const res = await fetch(`${API}/${id}`);
  return res.json();
}

export async function addEmployee(emp: Partial<Employee>): Promise<Employee> {
  const res = await fetch(API, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(emp),
  });
  return res.json();
}

export async function updateEmployee(id: number, emp: Employee): Promise<Employee> {
  const res = await fetch(`${API}/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(emp),
  });
  return res.json();
}
export async function deleteEmployee(id: number) {
  await fetch(`${API}/${id}`, { method: 'DELETE' });
}
