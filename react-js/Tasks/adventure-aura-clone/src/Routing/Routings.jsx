import { createBrowserRouter, Navigate } from 'react-router-dom'
import App from '../App'
import Home from '../pages/Home'
import About from '../pages/About'
import Contact from '../pages/Contact'
import Packages from '../pages/Packages'
import MyErrorPage from '../pages/MyErrorPage'

export const routes = createBrowserRouter([
    {
        path: '/',
        element: <App />,
        errorElement: <MyErrorPage />,
        children: [
            {
                index: true,
                element: <Home />
            },
            {
                path: 'about',
                element: <About />
            },
            {
                path: 'packages',
                element: <Packages />
            },
            {
                path: 'contact',
                element: <Contact />
            },
            {
                path: '*',
                element: <Navigate to="/" replace />
            }
        ]
    }
])