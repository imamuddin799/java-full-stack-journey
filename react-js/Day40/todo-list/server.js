import express from 'express';
import fs from 'fs';
import path from 'path';
import cors from 'cors';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
const PORT = 5000;
const DATA_FILE = path.join(__dirname, 'src', 'data', 'todo.json');

app.use(cors());
app.use(express.json());

// Helper function to read todos from file
function readTodos() {
    try {
        const data = fs.readFileSync(DATA_FILE, 'utf8');
        return JSON.parse(data);
    } catch (err) {
        return [err];
    }
}

// Helper function to write todos to file
function writeTodos(todos) {
    fs.writeFileSync(DATA_FILE, JSON.stringify(todos, null, 2));
}

// Get all todos
app.get('/todos', (req, res) => {
    const todos = readTodos();
    res.json(todos);
});

// Add a new todo
app.post('/todos', (req, res) => {
    const todos = readTodos();
    const newTodo = req.body;
    if (!newTodo || !newTodo.text) {
        return res.status(400).json({ error: 'Invalid todo data' });
    }
    newTodo.id = Date.now();
    newTodo.completed = false;
    todos.push(newTodo);
    writeTodos(todos);
    res.status(201).json(newTodo);
});

// Update a todo
app.put('/todos/:id', (req, res) => {
    const todos = readTodos();
    const id = parseInt(req.params.id);
    const updatedTodo = req.body;
    let found = false;
    const newTodos = todos.map(todo => {
        if (todo.id === id) {
            found = true;
            return { ...todo, ...updatedTodo, id };
        }
        return todo;
    });
    if (!found) {
        return res.status(404).json({ error: 'Todo not found' });
    }
    writeTodos(newTodos);
    res.json(updatedTodo);
});

// Delete a todo
app.delete('/todos/:id', (req, res) => {
    const todos = readTodos();
    const id = parseInt(req.params.id);
    const newTodos = todos.filter(todo => todo.id !== id);
    if (newTodos.length === todos.length) {
        return res.status(404).json({ error: 'Todo not found' });
    }
    writeTodos(newTodos);
    res.status(204).send();
});

app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});
