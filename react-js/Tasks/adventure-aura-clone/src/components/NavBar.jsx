import { Fragment } from 'react'
import logo from '../assets/images/contact/header-logo-1.svg'
import { Link } from 'react-router-dom'

const NavBar = () => {

    const links = [
        { label: 'Home', url: '/' },
        { label: 'About', url: '/about' },
        { label: 'Packages', url: '/packages' },
        { label: 'Contact', url: '/contact' },
    ]

    return <>
        <nav className="w-screen absolute top-0 z-[999999] text-white flex justify-between items-center mt-5">
            <aside className='w-full flex justify-center items-center'>
                <img src={logo} alt="" />
            </aside>
            <aside className='w-full'>
                <ul className='flex justify-center items-center gap-10'>
                    {
                        links.map((link, index) => {
                            return <Fragment key={index}>
                                <li><Link to={link.url}>{link.label}</Link></li>
                            </Fragment>
                        })
                    }
                </ul>
            </aside>
            <aside className='w-full flex justify-center items-center'>
                <button className='bg-[#FB5607] py-3 px-8 text-xl rounded-lg'>Plan Your Trip</button>
            </aside>
        </nav>
    </>
}

export default NavBar