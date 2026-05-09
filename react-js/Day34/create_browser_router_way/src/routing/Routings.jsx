import { createBrowserRouter } from 'react-router-dom'
import App from '../App'
import Home from '../components/Home'
import About from '../components/About'
import Contact from '../components/Contact'
import Login from '../components/Login'
import Register from '../components/Register'

export const routes = createBrowserRouter([
    {
        path: '/',
        element: <App />,
        children: [
            {
                index: true,
                element: <Home />
            },
            {
                path: '/about',
                element: <About />
            },
            {
                path: '/contact',
                element: <Contact />
            },
            {
                path: '/login',
                element: <Login />
            },
            {
                path: '/register',
                element: <Register />
            }
        ]
    }
])