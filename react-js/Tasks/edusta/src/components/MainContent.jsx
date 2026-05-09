import { Fragment, useState } from "react"
import { IoMdArrowDropdown } from "react-icons/io";
import { IoSearch } from "react-icons/io5";
import { FaBell } from "react-icons/fa6";
import { BsCalendarWeekFill } from "react-icons/bs";
import { MdFlag } from "react-icons/md";
import { LuLaptopMinimal } from "react-icons/lu";

const MainContent = () => {

    const menu = [
        {
            menuName: 'UI Components',
            menuItems: [
                'Buttons',
                'Alerts',
                'Avatars',
                'Modals',
                'Icons',
                'Range Sliders',
                'Time & Date',
                'Tables',
                'Loaders',
                'Drag & Drop',
                'Pagination',
                'Forms',
                'Charts'
            ],
            other: 'Extras',
            Extras: [
                'Calendar',
                'Vector Maps',
            ]
        },
        {
            menuName: 'Layouts',
            menuItems: [
                'Default',
                'Fixed Navs',
                'Mini Sidebar + Navs',
            ]
        },
    ]

    const [openMenuIndex, setOpenMenuIndex] = useState(null);

    const toggleMenu = (index) => {
        if (openMenuIndex === index) {
            setOpenMenuIndex(null);
        } else {
            setOpenMenuIndex(index);
        }
    }

    return <>
        <div className="border-red-700 w-full h-full flex flex-col justify-start items-start overflow-y-auto">
            <header className="w-full flex justify-between items-center bg-[#1367C9] text-white">
                <aside className="w-full flex justify-start items-start pl-7 py-3">
                    {
                        menu.map((object, index) => {
                            return <Fragment key={index}>
                                <div className="w-auto flex flex-col justify-start items-start relative">
                                    <h1 onClick={() => toggleMenu(index)} className="flex justify-center items-center cursor-pointer select-none font-semibold text-lg">
                                        {object.menuName}
                                        <IoMdArrowDropdown />
                                    </h1>
                                    {openMenuIndex === index && (
                                        <ul className="w-40 max-h-[50vh] absolute top-10 overflow-y-auto">
                                            {
                                                object.menuItems.map((item, idx) => {
                                                    return <li key={idx} className="text-gray-700 hover:text-blue-500 cursor-pointer">
                                                        <a href="#">{item}</a>
                                                    </li>
                                                })
                                            }
                                            {object.other && <li className="font-semibold mt-1 text-black">{object.other}</li>}
                                            {object.Extras && object.Extras.map((extraItem, extraIdx) => (
                                                <li key={`extra-${extraIdx}`} className="text-gray-700 hover:text-blue-500 cursor-pointer">
                                                    <a href="#">{extraItem}</a>
                                                </li>
                                            ))}
                                        </ul>
                                    )}
                                </div>
                            </Fragment>
                        })
                    }
                </aside>
                <aside className="w-full flex justify-end items-center h-full">
                    <div className="bg-[#115AB1] w-fit rounded">
                        <input type="text" name="" id="" placeholder="Search" className=" px-4 py-2 outline-0" />
                        <button className="px-3"><IoSearch /></button>
                    </div>
                    <div className="w-fit flex justify-center items-center gap-3 px-2 pr-5">
                        <button className="cursor-pointer p-2 rounded-[50%]"><FaBell className="text-white text-xl" /></button>
                        <button className="cursor-pointer p-2 rounded-[50%]"><BsCalendarWeekFill className="text-white text-xl" /></button>
                        <button className="cursor-pointer p-2 rounded-[50%] bg-white"><MdFlag className="text-xl text-[#115AB1]" /></button>
                    </div>
                    <div className="border-l border-gray-400 h-full flex justify-center items-center px-5 py-5">
                        <button className="flex justify-center items-center cursor-pointer font-bold gap-2"><LuLaptopMinimal className="text-xl" /> <span>My Dashboard</span></button>
                    </div>
                </aside>
            </header>
        </div>
    </>
}

export default MainContent
