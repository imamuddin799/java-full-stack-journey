import React from 'react'
import AboutDestination1 from '/src/assets/images/About/about-destination-11.jpg'
import AboutDestination2 from '/src/assets/images/About/about-destination-12.jpg'
import AboutDestination3 from '/src/assets/images/About/about-destination-13.jpg'
function Section5() {

  return (
    <>
    <div className='flex flex-col justify-center items-center gap-4 p-10'>
    <div className='flex justify-center align-middle text-center w-1/5 bg-red-200 rounded-4xl text-red-600'>TRENDING PACKAGES</div>
    <div className='font-bold text-[50px] w-[600px] text-center'>Destinations you Don't Wanna Miss</div>
    <div className='flex justify-center items-center gap-5'>
          <div className='relative h-140 rounded-[100px] w-100 bg-cover' style={{ backgroundImage: `url(${AboutDestination1})` }}>
            <div className='absolute text-white font-bold text-[21px]  mt-115 ml-15'>Bali</div>
            <div className='absolute  text-white font-bold text-[21px] mt-125 ml-15'>Indonessia</div>
             <div  className='absolute  text-white font-bold text-[21px] mt-125 ml-60'>3 Packages</div>
        </div>
             <div className='relative h-140 rounded-[100px] w-100 bg-cover' style={{ backgroundImage: `url(${AboutDestination2})` }}>
            <div className='absolute text-white font-bold text-[21px]  mt-115 ml-15'>Dubai City</div>
            <div className='absolute  text-white font-bold text-[21px] mt-125 ml-15'>UAE</div>
             <div  className='absolute  text-white font-bold text-[21px] mt-125 ml-60'>2 Packages</div>
        </div>
             <div className='relative h-140 rounded-[100px] w-100 bg-cover' style={{ backgroundImage: `url(${AboutDestination3})` }}>
            <div className='absolute text-white font-bold text-[21px]  mt-115 ml-15'>Shizuoka</div>
            <div className='absolute  text-white font-bold text-[21px] mt-125 ml-15'>Japan</div>
             <div  className='absolute  text-white font-bold text-[21px] mt-125 ml-60'>7 Packages</div>
        </div>
       
    </div>
    </div>
    </>
  )
}

export default Section5