import { Fragment } from "react";
import { RiArrowDropDownLine } from "react-icons/ri";
import { IoIosSearch } from "react-icons/io";
import { BsSlashSquare } from "react-icons/bs";
import { FaGithub } from "react-icons/fa";

const GitNav = () => {

    let select = [
        'Product',
        'Solutions',
        'Resources',
        'Open Source',
        'Enterprise']
    return <>
        <div className="w-full flex justify-center bg-[#030542] text-white">
            <nav className="w-[97%] py-4 font-medium flex justify-between items-center">
                <aside className="flex justify-start items-center gap-4">
                    <div>
                        <a class="header-logo" href="https://github.com/" aria-label="Homepage" data-ga-click="(Logged out) Header, go to homepage, icon:logo-wordmark">
                            <FaGithub className="text-[30px]"/>
                        </a>
                    </div>
                    <div className="flex justify-center gap-3">
                        {
                            select.map((option, index) => {
                                return <Fragment key={index}>
                                    <div className="flex items-center  gap-0">
                                        <select name="" id="" className="appearance-none outline-0">
                                            <option value="">{option}</option>
                                        </select>
                                        <RiArrowDropDownLine className="mt-1 text-2xl font-light" />
                                    </div>
                                </Fragment>
                            })
                        }
                    </div>
                    <a href="">Pricing</a>
                </aside>
                <aside className="flex justify-center items-center gap-8">
                    <div className="border-1 flex justify-center items-center rounded px-3 py-1">
                        <IoIosSearch className="text-[20px] mr-2" />
                        <input type="text" name="" id="" placeholder="Search or jump to..." className="outline-0" />
                        <BsSlashSquare />
                    </div>
                    <div>
                        <a href="">Sign In</a>
                    </div>
                    <div>
                        <button className="border py-1 px-3 rounded">Sign Up</button>
                    </div>
                </aside>
            </nav>
        </div>
    </>
}

export default GitNav;