
import logo from '../assets/images/logo.webp'
import { FaLocationDot } from "react-icons/fa6";
import { CiSearch } from "react-icons/ci";


const Header = () => {
    return <div className='mt-20 w-[60%] flex flex-col justify-center items-center'>
        <img src={logo} alt="" className='w-[70%]' />
        <h1 className='text-[35px] text-white p-10'>Discover the best food & drinks in Chennai</h1>
        <div className='flex justify-center items-center bg-white p-1 rounded-[12px]'>
            <FaLocationDot className='text-[#F57082] ml-4 text-[20px]' />
            <input type="text" name="" id="" className='w-46 p-2 text-[14px] outline-0 border-r-2 border-gray-400 focus:outline-none text-center' placeholder='Custom Colony, Besant Nagar
' />
            <CiSearch className='text-[25px] text-gray-700 mx-3'/>
            <input type="text" name="" id="" className='w-86 p-2 text-[14px] outline-0' placeholder='Search for a restaurant, suisine or a dish' />
        </div>
    </div>
}

export default Header