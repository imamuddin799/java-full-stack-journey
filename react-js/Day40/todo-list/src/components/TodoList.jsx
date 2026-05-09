import React, { useState, useEffect } from 'react';

const API_URL = 'http://localhost:5000/todos';

const TodoList = () => {
    const [todos, setTodos] = useState([]);
    const [newTodo, setNewTodo] = useState('');

    // Fetch todos from backend
    const fetchTodos = () => {
        fetch(API_URL)
            .then(res => res.json())
            .then(data => setTodos(data))
            .catch(err => console.error('Error fetching todos:', err));
    };

    useEffect(() => {
        fetchTodos();
    }, []);

    const addTodo = () => {
        if (newTodo.trim() === '') return;
        const todoToAdd = { text: newTodo.trim() };
        fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(todoToAdd),
        })
            .then(res => {
                if (!res.ok) throw new Error('Failed to add todo');
                return res.json();
            })
            .then(() => {
                setNewTodo('');
                fetchTodos();
            })
            .catch(err => console.error(err));
    };

    const toggleComplete = (id, completed) => {
        fetch(`${API_URL}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ completed: !completed }),
        })
            .then(res => {
                if (!res.ok) throw new Error('Failed to update todo');
                fetchTodos();
            })
            .catch(err => console.error(err));
    };

    const updateTodo = (id, newText) => {
        fetch(`${API_URL}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ text: newText }),
        })
            .then(res => {
                if (!res.ok) throw new Error('Failed to update todo');
                fetchTodos();
            })
            .catch(err => console.error(err));
    };

    const deleteTodo = (id) => {
        fetch(`${API_URL}/${id}`, {
            method: 'DELETE',
        })
            .then(res => {
                if (!res.ok) throw new Error('Failed to delete todo');
                fetchTodos();
            })
            .catch(err => console.error(err));
    };

    return (
        <div className="w-screen h-screen flex flex-col justify-center items-center p-4">
            <h1 className="text-2xl font-bold mb-4">Todo List</h1>
            <div className="flex mb-4">
                <input
                    type="text"
                    value={newTodo}
                    onChange={(e) => setNewTodo(e.target.value)}
                    placeholder="Add new todo"
                    className="border border-gray-400 rounded px-2 py-1 mr-2"
                />
                <button
                    onClick={addTodo}
                    className="bg-blue-500 text-white px-4 py-1 rounded"
                >
                    Add
                </button>
            </div>
            <ul className="w-full max-w-md">
                {todos.map(todo => (
                    <li
                        key={todo.id}
                        className="flex items-center justify-between border-b border-gray-300 py-2"
                    >
                        <input
                            type="checkbox"
                            checked={todo.completed}
                            onChange={() => toggleComplete(todo.id, todo.completed)}
                            className="mr-2"
                        />
                        <input
                            type="text"
                            value={todo.text}
                            onChange={(e) => updateTodo(todo.id, e.target.value)}
                            className={`flex-grow border-none bg-transparent focus:outline-none ${
                                todo.completed ? 'line-through text-gray-500' : ''
                            }`}
                        />
                        <button
                            onClick={() => deleteTodo(todo.id)}
                            className="text-red-500 ml-2"
                        >
                            Delete
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default TodoList;
