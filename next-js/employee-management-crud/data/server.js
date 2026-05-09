const express = require('express');
const fs = require('fs');
const cors = require('cors');
const app = express();
const PORT = 5000;
const FILE = './employees.json';

app.use(cors());
app.use(express.json());

// Read all employees
app.get('/employees', (req, res) => {
  const data = JSON.parse(fs.readFileSync(FILE));
  res.json(data);
});

// Add employee
app.post('/employees', (req, res) => {
  const employees = JSON.parse(fs.readFileSync(FILE));
  const newEmp = { id: Date.now(), ...req.body };
  employees.push(newEmp);
  fs.writeFileSync(FILE, JSON.stringify(employees, null, 2));
  res.json(newEmp);
});

// Get employee by ID
app.get('/employees/:id', (req, res) => {
  const employees = JSON.parse(fs.readFileSync(FILE));
  const emp = employees.find(e => e.id == req.params.id);
  res.json(emp);
});

// Update employee
app.put('/employees/:id', (req, res) => {
  let employees = JSON.parse(fs.readFileSync(FILE));
  const id = parseInt(req.params.id);
  employees = employees.map(e => (e.id === id ? { ...e, ...req.body } : e));
  fs.writeFileSync(FILE, JSON.stringify(employees, null, 2));
  res.json({ message: 'Updated' });
});

// Delete employee
app.delete('/employees/:id', (req, res) => {
  let employees = JSON.parse(fs.readFileSync(FILE));
  employees = employees.filter(e => e.id != req.params.id);
  fs.writeFileSync(FILE, JSON.stringify(employees, null, 2));
  res.json({ message: 'Deleted' });
});

app.listen(PORT, () => console.log(`Server running on http://localhost:${PORT}`));
