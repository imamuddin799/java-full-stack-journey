import { Fragment } from "react"
import logo from '../assets/images/logo.svg'
import search from '../assets/images/24.svg'
import person from '../assets/images/24 (4).svg'
import star from '../assets/images/24 (5).svg'
import location from '../assets/images/24 (6).svg'
const NavBar = () => {

    const linksList = ['Models', 'Buy', 'Services', 'Brand']

    return <>
        <div className="w-full bg-black text-white flex justify-center items-center py-4">
            <nav className="w-[84%] bg-black text-white flex justify-between items-center">
                <aside className="w-full grow">
                    <ul className="flex justify-start items-center gap-10">
                        {
                            linksList.map((link, index) => {
                                return <Fragment key={index}>
                                    <li><a href="#">{link}</a></li>
                                </Fragment>
                            })
                        }
                    </ul>
                </aside>
                <aside className="w-30">
                    <img src={logo} alt="" />
                </aside>
                <aside className="w-full flex justify-end items-center grow gap-4">
                    <div className="flex gap-2 justify-center items-center">
                        <input type="text" name="" id="" placeholder="Provider/..." className="w-24 outline-0 placeholder:text-white" />
                        <div className="w-10 p-2">
                            <img src={search} alt="" className="filter invert brightness-200" />
                        </div>
                    </div>
                    <div className="w-10 p-2">
                        <img src={star} alt="" className="filter invert brightness-200" />
                    </div>
                    <div className="w-10 p-2">
                        <img src={location} alt="" className="filter invert brightness-200" />
                    </div>
                    <div className="p-2 flex justify-center items-center gap-2">
                        <div className="w-9 p-2 rounded-[50%] bg-gray-600">
                            <img src={person} alt="" className="filter invert brightness-200" />
                        </div>
                        <span>Login</span>
                    </div>
                </aside>
            </nav>
        </div>
    </>
}

export default NavBar