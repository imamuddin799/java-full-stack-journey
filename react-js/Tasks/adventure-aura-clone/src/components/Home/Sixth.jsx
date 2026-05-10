import React from 'react'
import { FaQuoteLeft } from "react-icons/fa";

function Sixth() {
  return (
    <div className='flex flex-col justify-center items-center gap-6 p-6'>
        <div className='bg-red-100 text-red-600 rounded-[20px] w-[200px] text-center'>TESTIMONIALS</div>
        <div className='font-bold text-3xl'>Top Reviews</div>
        <div className=''><FaQuoteLeft className='text-amber-600 '/></div>
        <div className='w-[580px] text-[rgb(61,61,61)] text-center'>“An absolutely incredible experience! The attention to detail and personalized service made our Maldives
             trip unforgettable. Highly recommend!”</div>
        <div className='h-16 w-16 rounded-full  '> <img src="https://websitedemos.net/travel-agency-04/wp-content/uploads/sites/1521/2025/03/home-review.png" alt="" /></div>
        <div className='font-bold'>Frank james Anderson</div>
    </div>
  )
}

export default Sixth