import { Fragment } from "react"
import { Link } from "react-router-dom"

const NavBar = () => {

    const links = [
        {
            path: '/',
            label: 'Home'
        },
        {
            path: '/about',
            label: 'About'
        },
        {
            path: '/contact',
            label: 'Contact'
        },
        {
            path: '/login',
            label: 'Login'
        },
        {
            path: '/register',
            label: 'Register'
        }
    ]

    return <>
        <nav className="w-full bg-black text-white p-4">
            <ul className="flex gap-x-10">
                {
                    links.map((link, index) => {
                        return <Fragment key={index}>
                            <li><Link to={link.path}>{link.label}</Link></li>
                        </Fragment>
                    })
                }
            </ul>
        </nav>
    </>
}

export default NavBar