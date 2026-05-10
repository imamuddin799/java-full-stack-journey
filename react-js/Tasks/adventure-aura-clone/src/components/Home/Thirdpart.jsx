import React from 'react'
import s from '../../assets/images/home/home-journey2.jpg'
import { FaCheckCircle } from "react-icons/fa";




function Thirdpart() {
  return (
    <div className='flex p-10 items-center justify-center  gap-15 bg-[#FFF7EC]'>
        <div><img className='w-[350px] '
            src="https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/image-6.png"
            class="img-fluid rounded-top"
            alt=""
        />
        </div>
        <div className='w-1/3 flex flex-col p-10 gap-2'>
            <div className='bg-amber-50  w-1/6 text-[13px] text-center text-red-600 rounded-[20px]'>ABOUT US</div>
            <div  className='text-[45px] font-bold' >Your Journey, Our Passion</div>
            <div className='text-[14px]'  >We believe that travel is more than just visiting new places; it's about creating memories, experiencing diverse cultures, and discovering the wonders of the world. With years of experience in the travel industry, our dedicated team is committed to providing exceptional travel experiences tailored to your unique desires and needs.</div>
          <div className='flex  mt-6'>  <div><div className=' w-[200px]'><img src={s} alt="" /></div>  <div className='flex mt-6'>
          <div className='relative h-13 w-13 rounded-4xl'><img  className=' h-13 w-13 rounded-4xl' src="https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/home-journey3.jpg" alt="" /></div>
          <div className='ml-10 absolute h-13 w-13 rounded-4xl'><img  className=' h-13 w-13 rounded-4xl' src="https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/home-journey4.jpg" alt="" /></div>
          <div className='ml-14 text-[12px] w-1/2'>4.7 Star Rating
Based on 3,571 Reviews</div>
          </div>
          </div>
          <div className='ml-0'> <div className='flex items-center gap-3'><FaCheckCircle className='text-amber-300'/>Budget-Friendly</div>
            <div className='flex items-center gap-3'><FaCheckCircle className='text-amber-300'/>Luxurious Getways</div>
            <div className='flex items-center gap-3'><FaCheckCircle className='text-amber-300'/>Trusted Local Guides</div>
           <button className='bg-amber-500 w-45 mt-5 rounded-2xl text-1xl p-3 text-white'>Learn More</button></div>
            </div>
          
        </div>
    </div>
  )
}

export default Thirdpart