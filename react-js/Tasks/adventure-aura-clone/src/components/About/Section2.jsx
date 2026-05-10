import React from 'react'
import { FaUserFriends } from "react-icons/fa";
import { FaGlobeAmericas } from "react-icons/fa";
import { FaHeadphones } from "react-icons/fa";
import { FaPeopleGroup } from "react-icons/fa6";

function Section2() {
  return (
    <div className=''>
        <div className=' flex justify-center items-center gap-40 bg-white border-[01px] ml-47 rounded-[40px] p-18 mt-[-150px] absolute z-30'>
            <div className='flex flex-col items-center'>
                <div className='text-amber-600 bg-amber-100 rounded-[15px] h-16 w-17 text-[40px] flex justify-center items-center '><FaUserFriends /></div>
                <div className='font-bold text-[45px] text-center'>10+</div>
                <div className='text-center'>Years of Experience</div>
            </div>

            <div className='flex flex-col items-center'>
                <div className='text-amber-600 bg-amber-100 rounded-[15px] h-16 w-17 text-[40px] flex justify-center items-center '><FaGlobeAmericas /></div>
                <div className='font-bold text-center text-[45px]'>500+</div>
                <div className='text-center' >Destinations</div>
            </div>
            <div className='flex flex-col items-center'>
                <div className='text-amber-600 bg-amber-100 rounded-[15px] h-16 w-17 text-[40px] flex justify-center items-center '><FaHeadphones /></div>
                <div className='font-bold text-center text-[45px]'>24/7+</div>
                <div className='text-center' >Customer Support</div>
            </div>
            <div className='flex flex-col items-center'>
                <div className='text-amber-600 bg-amber-100 rounded-[15px] h-16 w-17 text-[40px] flex justify-center items-center '><FaPeopleGroup /></div>
                <div className='font-bold text-center text-[45px]'>98%</div>
                <div className='text-center' >Happy clients </div>
            </div>
        </div>
    </div>
  )
}

export default Section2