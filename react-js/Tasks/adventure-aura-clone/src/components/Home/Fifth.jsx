import React from 'react'
import { FaPersonWalking } from "react-icons/fa6";
import { MdOutlineFlight } from "react-icons/md";
import { FaBath } from "react-icons/fa";
import HomeTour from '/src/assets/images/home/home-tour.jpg'

function Fifth() {
  return (
    <div className='bg-no-repeat relative flex justify-center items-center w-full' style={{ backgroundImage: `url(${HomeTour})` }}>
        <div className='flex absolute flex-col gap-4 w-[200px] mt-[-180px] ml-100'>
            <div  className='bg-white text-blue-200 w-1/2 rounded-[10px] text-center text-[15px]' >WHY US</div>
            <div className=' text-white text-[35px] font-bold' >Crafting Unforgettable Journeys</div>
        </div>
                <div className='rounded-[60px] flex flex-col gap-5 w-[400px] mr-[600px] bg-white mt-60 p-15'>
            <div><MdOutlineFlight /></div>
            <div>Customized Packages</div>
            <div>Tailor-made itineraries to suit your preferences and interests, ensuring a unique travel experience every time.</div>
            <div><FaPersonWalking /></div>
            <div>Adventure Tours</div>
            <div>Explore thrilling destinations and activities, from mountain trekking to scuba diving, for the adrenaline seekers.</div>
            <div><FaBath /></div>
            <div>Luxury Vacations</div>
            <div>Indulge Lorem ipsum dolor sit amet consectetur adipisicing elit. Provident dicta possimus deleniti?</div>

        </div>
    </div>
  )
}

export default Fifth;