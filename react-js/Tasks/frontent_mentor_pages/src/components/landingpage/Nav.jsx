import { Fragment } from 'react'
import logo from '../../assets/landingpage/images/logo.svg'

let Nav = () => {
    let links = ['About', 'Services', 'Projects']
    return <>
        <section className="w-full flex justify-center items-center">
            <nav className="my-10 w-[90%] flex justify-between items-center">
                <aside>
                    <img src={logo} alt="" />
                </aside>
                <aside className='flex justify-end items-center gap-15'>
                    <ul className='flex justify-center items-center gap-15'>
                        {
                            links.map((link, index) => {
                                return <Fragment key={index}>
                                    <li><a href="#" className='text-white font-medium outline-0'>{link}</a></li>
                                </Fragment>
                            })
                        }
                    </ul>
                    <button className='w-fit text-2xl font-medium px-8 py-3 bg-white rounded-4xl cursor-pointer'>Contact</button>
                </aside>
            </nav>
        </section>
    </>
}

export default Nav