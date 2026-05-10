import React from 'react' 
import AboutTeam1 from '/src/assets/images/About/image11.jpg'
import AboutTeam2 from '/src/assets/images/About/team12.jpg'
import AboutTeam3 from '/src/assets/images/About/team13.jpg'

function Section6() {
  return (
    <>
    <div className='flex flex-col justify-center items-center gap-4 p-20 bg-[#FFF7EC]'>
    <div className='flex justify-center align-middle text-center w-1/5 bg-red-200 rounded-4xl text-red-600'>OUR TEAM</div>
    <div className='font-bold text-[50px] w-[600px] text-center'>Meet The Brains</div>
    <div className='flex justify-center items-center gap-5'>
        <div className='relative h-140 rounded-[100px] w-100 bg-cover' style={{ backgroundImage: `url(${AboutTeam1})` }}>
        
            <div className='absolute text-black font-bold text-[21px]  mt-115 ml-15'>Mike Jones</div>
            <div className='absolute  text-black font-bold text-[21px] mt-125 ml-15'>Co-Founder</div>
             {/* <div  className='absolute  text-white font-bold text-[21px] mt-125 ml-60'>3 Packages</div> */}
        </div>
             <div className='relative h-140 rounded-[100px] w-100 bg-cover' style={{ backgroundImage: `url(${AboutTeam2})` }}>
        
            <div className='absolute text-black font-bold text-[21px]  mt-115 ml-15'>Emma Taylor</div>
            <div className='absolute  text-black font-bold text-[21px] mt-125 ml-15'>Co-Founder</div>
             {/* <div  className='absolute  text-white font-bold text-[21px] mt-125 ml-60'>2 Packages</div> */}
        </div>
             <div className='relative h-140 rounded-[100px] w-100 bg-cover' style={{ backgroundImage: `url(${AboutTeam3})` }}>
        
            <div className='absolute text-black font-bold text-[21px]  mt-115 ml-15'>Anna Hanna</div>
            <div className='absolute  text-black font-bold text-[21px] mt-125 ml-15'>Expert Guide</div>
             {/* <div  className='absolute  text-white font-bold text-[21px] mt-125 ml-60'>7 Packages</div> */}
        </div>
       
    </div>
    </div>
  </>
  )
}

export default Section6