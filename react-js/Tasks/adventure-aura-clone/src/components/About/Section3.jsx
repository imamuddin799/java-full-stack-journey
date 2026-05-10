import React from 'react'
import { FaCheckCircle } from "react-icons/fa";

function Section3() {
  return (
    <>
    <div className='flex mt-40 w-full p-30'>
      <div className='w-1/2'>
        <div className=' text-red-600 bg-red-100 text-center rounded-[20px] text-[15px] p-1   w-[230px] '>CUSTOMIZED ITINERARIES</div>
        <div className='text- font-bold mt-3 text-[50px]'>We Believe That Travel is a Personal Journey</div>
      <div>Our team of seasoned travel experts brings years of experience and an in-depth understanding of the world’s most captivating destinations. We believe that travel is a personal journey, and we strive to provide personalized service that reflects your unique tastes and interests.</div>
     <div className='flex relative mt-5'>
      <div className='h-13 w-13 rounded-4xl '><img className='h-13 w-13 rounded-4xl' src="https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/about-journey2.jpg" alt="" /></div>
      <div className='h-13 w-13 rounded-4xl absolute ml-6'><img className='h-13 w-13 rounded-4xl' src="https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/about-journey3.jpg" alt="" /></div>
      <div className='h-13 w-13 rounded-4xl absolute ml-10'><img className='h-13 w-13 rounded-4xl' src="https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/about-journey4.jpg" alt="" /></div>
     <div className='ml-20'>500K+ Happy Customer</div> 
     </div>
      </div>

      <div>
      <img className='rounded-4xl' src="https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/trek.jpg" alt="" />
      <div className='flex gap-3 mt-3'>
        <div className='flex items-center gap-6'><div className='text-amber-600'><FaCheckCircle /> </div><div>Adventurous Trek</div></div>
        <div className='flex items-center gap-5'><div className='text-amber-600'><FaCheckCircle /> </div> <div>Family-Friendly</div></div>
        <div className='flex items-center gap-5'><div className='text-amber-600'><FaCheckCircle /> </div><div>Expert Guides</div></div>
      </div>
      </div>
    </div>
    </>
  )
}

export default Section3