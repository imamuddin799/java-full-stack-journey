import footlogo from '../assets/images/footerlogo.webp'
import { MdOutlineKeyboardArrowDown } from "react-icons/md";
import { IoGlobeOutline } from "react-icons/io5";


const FooterTop = () => {
    return <>
        <div className='w-full flex justify-between items-center'>
            <aside>
                <img src={footlogo} alt="" />
            </aside>
            <aside className='text-black flex justify-center items-center gap-4'>
                <div className='border flex justify-center items-center py-1 px-4 rounded-lg'>
                    <select name="" id="" className='appearance-none outline-0'>
                        <option value="">India</option>
                    </select>
                    <MdOutlineKeyboardArrowDown className='text-[24px]'/>
                </div>
                <div className='border flex justify-center items-center gap-1 py-1 px-4 rounded-lg'>
                    <IoGlobeOutline className='text-[20px]' />
                    <select name="" id="" className='appearance-none outline-0'>
                        <option value="">English</option>
                    </select>
                    <MdOutlineKeyboardArrowDown className='text-[24px]' />
                </div>
            </aside>
        </div>
    </>
}

export default FooterTop