import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

const Login = () => {

    const navigate = useNavigate()

    const [formData, setFormData] = useState({
        username: "",
        email: "",
        password: ""
    })

    const { username, email, password } = formData;

    const handleChange = (e) => {
        const { name, value } = e.target
        setFormData({ ...formData, [name]: value })
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(formData);
        const semail = localStorage.getItem("email")
        const spass = localStorage.getItem("password")

        if (semail === email && spass === password) {
            toast.success("Login Successfully Completed")
            navigate("/")
            setFormData({
                username: "",
                email: "",
                password: ""
            })
        } else {
            toast.error('Invalid Email or Password');
        }
    };

    return (
        <>
            <div className="max-w-md mx-auto mt-10 p-6 bg-white rounded shadow-md">
                <h2 className="text-2xl font-bold mb-6 text-center">Login Form</h2>
                <form onSubmit={handleSubmit} className="space-y-4">
                    <div>
                        <label htmlFor="email" className="block text-sm font-medium text-gray-700 mb-1">Email:</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            value={email}
                            onChange={handleChange}
                            required
                            className="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
                        />
                    </div>
                    <div>
                        <label htmlFor="password" className="block text-sm font-medium text-gray-700 mb-1">Password:</label>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            value={password}
                            onChange={handleChange}
                            required
                            className="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
                        />
                    </div>
                    <button
                        type="submit"
                        className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700 transition-colors"
                    >
                        Login
                    </button>
                    <Link to="/register" className='w-fit px-5 py-2 bg-blue-500 text-white rounded'>Register</Link>
                </form>
            </div>
        </>
    );
};

export default Login;