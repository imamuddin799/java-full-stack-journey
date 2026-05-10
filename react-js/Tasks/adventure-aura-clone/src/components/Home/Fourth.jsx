import React from 'react'
import d1 from '../../assets/images/home/home-destination1.jpg'
import d2 from '../../assets/images/home/home-destination2-1.jpg'
import d3 from '../../assets/images/home/home-destination3.jpg'
import d4 from '../../assets/images/home/home-destination4.jpg'
import d5 from '../../assets/images/home/home-destination5-1.jpg'



function Fourth(){
  return (
        <div className='grid grid-cols-3 grid-rows-2 p-x-0 p-y-0 place-items-center px-80 py-10'>
        <div className='w-[300px]  flex flex-col gap-3'>
            <div className='bg-red-200 text-red-800 text-[11px] w-1/2 text-center p-2 rounded-[20px]' >CHOOSE YOUR PLACE</div>
            <div className='text-[40px]' >Popular Destinations</div>
            <div className='text-[13px]' >Join us as we explore the wonders of the globe, one incredible journey at a time.</div>
            <button className='bg-amber-600 text-white rounded-[10px] w-1/2 p-2'>Find Packages</button>
        </div>
        <div className='relative'> <img className='  relative rounded-[50px] w-[280px]' src={d1} alt="" />  <div className='absolute bottom-4 left-0 right-0 text-center text-white font-semibold text-[14px]' > Amazon Forest</div> </div>
        <div className='relative'> <img className='  relative rounded-[50px] w-[280px]' src={d2} alt="" />  <div className='absolute bottom-4 left-0 right-0 text-center text-white font-semibold text-[14px]' >New Zealand</div> </div>
        <div className='relative'> <img className=' relative  rounded-[50px] w-[280px]' src={d3} alt="" /> <div className='absolute bottom-4 left-0 right-0 text-center text-white font-semibold text-[14px]' > Londin</div>  </div>
        <div className='relative'> <img className='relative rounded-[50px] w-[280px]' src={d4} alt="" /> <div className='absolute bottom-4 left-0 right-0 text-center text-white font-semibold text-[14px]' >Europe</div> </div>
        <div className='relative'> <img className='  relative rounded-[50px] w-[280px]' src={d5} alt="" />  <div className='absolute bottom-4 left-0 right-0 text-center text-white font-semibold text-[14px]' >Africa</div> </div>
    </div>
  )
}

export default Fourth