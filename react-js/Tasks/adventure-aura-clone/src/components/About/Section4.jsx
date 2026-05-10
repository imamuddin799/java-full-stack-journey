import React from 'react'
import { FaArrowAltCircleRight } from "react-icons/fa";

function Section4() {
  return (
    <>
    <div className='flex w-full justify-center items-center gap- p-0 bg-[#FFF7EC]'>
        <div className='w-1/2 grid grid-cols-2 grid-rows-2 p-x-0 p-y-0 place-items-center p-20'>
            <div><img className='w-[280px] rounded-4xl' src="https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/about-us11.jpg" alt="" /></div>
            <div><img className='w-[280px] rounded-4xl' src="https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/about-us13.jpg" alt="" /></div>
            <div><img className='w-[280px] rounded-4xl' src="https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/about-us12.jpg" alt="" /></div>
            <div><img className='w-[280px] rounded-4xl' src="https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/about-us14.jpg" alt="" /></div>
        </div>

        <div className=' flex flex-col gap-5 w-1/2'>
            <div className='bg-white rounded-4xl w-1/6 text-center text-red-500'>ABOUT US</div>
            <div className='text-[50px] w-[500px] font-bold'>
                We Make Travel Accessible
                and Enoyable 
            </div>
            <div className='w-[580px]'>Our mission is to make travel accessible and enjoyable for all. That's why we pride
                 ourselves on being budget-friendly, without compromising on quality or experience. 
                 Our partnerships with trusted local guides and accommodations ensure that you receive 
                 the best value wherever you go.</div>
                     <div> <button className="text-white p-3 flex items-center justify-center gap-2 w-[200px] rounded-[10px] bg-[#FF6E0E]">Start Planing  <FaArrowAltCircleRight /> </button></div>

        </div>

    </div>
    </>
  )
}

export default Section4