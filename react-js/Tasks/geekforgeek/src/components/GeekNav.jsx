import { Fragment } from "react";
import { IoIosArrowDown } from "react-icons/io";
import { IoIosSearch } from "react-icons/io";
import { RxCross2 } from "react-icons/rx";
import { IoMoonOutline } from "react-icons/io5";
import { LuBell } from "react-icons/lu";
import { LiaLanguageSolid } from "react-icons/lia";

import logo from '../assets/images/logo.svg'
let GeekNav = () => {

    let lists = ["Courses", 'Placement', 'Data Science', 'GATE', 'Practice'];

    return <>
        <section className="w-full flex justify-center items-center">
            <nav className="w-[96%] flex">
                <aside className="w-full grow flex justify-start items-center">
                    <ol className="flex  gap-4">
                        {
                            lists.map((list, index) => {
                                return <Fragment key={index}>
                                    <li>
                                        <div className="flex justify-center items-center gap-2 font-medium"><span>{list}</span><IoIosArrowDown className="text-2xl" /></div>
                                    </li>
                                </Fragment>
                            })
                        }
                    </ol>
                </aside>
                <aside className="w-fit grow-0">
                    <img src={logo} alt="" className="h-[65px]" />
                </aside>
                <aside className="w-full grow flex justify-end gap-4">
                    <div className="flex justify-between items-center gap-3 border-3 border-[#B3D5BB] bg-[#E6E6E6] p-2 my-2 rounded-lg">
                        <IoIosSearch className="text-2xl text-gray-500" />
                        <input
                            type="text"
                            name="" id=""
                            placeholder="Search..."
                            className="text-[18px] outline-0"
                        />
                        <RxCross2 className="text-2xl text-gray-500" />
                    </div>
                    <div className="flex justify-center items-center gap-3">
                        <div className="p-1 rounded-[50%] bg-gray-200"><IoMoonOutline className="text-2xl" /></div>
                        <div className="p-1 rounded-[50%]"><LuBell className="text-2xl" /></div>
                        <div className="p-1 rounded-[50%]"><LiaLanguageSolid className="text-2xl" /></div>
                    </div>
                    <div className="flex justify-center items-center">
                        <button className="bg-[#273239] text-white text-lg py-1 px-7 rounded-sm">Sign In</button>
                    </div>
                </aside>
            </nav>
        </section>
    </>
}
export default GeekNav;