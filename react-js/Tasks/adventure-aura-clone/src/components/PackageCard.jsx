
import { IoMdTime } from "react-icons/io";
import { FaStar } from "react-icons/fa";
import { FaHotel } from "react-icons/fa";
import { FaCarAlt } from "react-icons/fa";
import { FaShip } from "react-icons/fa";
import { MdFlightTakeoff } from "react-icons/md";
import { FaRegArrowAltCircleRight } from "react-icons/fa";

const PackageCard = ({continent, country, image}) => {
    return <>
        <div className="w-[80%] h-full flex flex-col">
            <div className="w-full flex justify-between items-center">

                <div className="w-[37%] h-full">
                    <div className='w-full relative'>
                        <img src={image} alt="" className='w-full object-cover rounded-[50px]' />
                    </div>
                </div>

                <div className="w-[63%] h-full py-15 px-10 rounded-r-[50px] border border-gray-400 bg-white">
                    <h3 className="py-1 px-9 rounded-3xl text-[#FB5607] bg-[#FFECE1] w-fit">{continent.toUpperCase()}</h3>
                    <h1 className="text-3xl font-medium my-5">{country}</h1>
                    <div className='my-4'>
                        <div className='flex justify-between items-center'>
                            <span className='flex justify-start items-center gap-1'><IoMdTime className="text-[#FB5607]" /> 5 Days/ 6 Nights </span> <p className='flex'><FaStar className='text-[#FB5607]' /><FaStar className='text-[#FB5607]' /><FaStar className='text-[#FB5607]' /><FaStar className='text-[#FB5607]' /><FaStar className='text-[#FB5607]' /></p>
                        </div>
                    </div>
                    <div className='flex justify-start items-center w-full gap-6 mb-10'>
                        <div className='flex justify-start items-center gap-3'><FaHotel className='text-3xl text-[#FB5607]' /><span>Hotel</span></div>
                        <div className='flex justify-start items-center gap-3'><FaCarAlt className='text-3xl text-[#FB5607]' /><span>Car</span></div>
                        <div className='flex justify-start items-center gap-3'><FaShip className='text-3xl text-[#FB5607]' /><span>Cruises</span></div>
                        <div className='flex justify-start items-center gap-3'><MdFlightTakeoff className='text-3xl text-[#FB5607]' /><span>Flights</span></div>
                    </div>
                    <div className='flex justify-between items-center'>
                        <div className='flex flex-col justify-center items-start gap-1 '>
                            <h3 className='text-lg font-medium'>₹1,05,450 /Person</h3>
                            <p>This price is lower than the average price in April</p>
                        </div>
                        <button className='bg-[#FB5607] flex justify-center items-center text-white gap-3 text-xl py-3 px-8 rounded-xl'>
                            <span>Start Trip</span><FaRegArrowAltCircleRight />
                        </button>
                    </div>
                </div>

            </div>
        </div>
    </>
}

export default PackageCard