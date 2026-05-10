import React from 'react'
import Footer from '../components/Footer'
import ImageAbout from '../assets/about-bg.jpg'
function About() {
  return (
    <>
      {/* Hero Section */}
      <div className="relative p-40 w-full overflow-hidden font-sans">
        {/* Blurred Background */}
        <div className="absolute inset-0 h-full bg-cover bg-center filter  brightness-15" style={{backgroundImage: `url(${ImageAbout})`}}></div>

        {/* Foreground Text */}
        <div className="relative z-10 h-full w-full flex flex-col items-center justify-center text-white text-center px-4 font-sans">
          <h1 className="text-[18px] uppercase tracking-widest">About Us</h1>
          <h2 className="text-[50px] sm:text-[60px] font-semibold mt-4">Headline for the About</h2>
          <h2 className="text-[50px] sm:text-[60px] font-semibold">Page Will Be Here</h2>
        </div>
      </div>

      {/* Next Section */}
      <div className="bg-[#ECF4F3] py-20 font-sans">
        <div className="max-w-6xl mx-auto grid grid-cols-1 md:grid-cols-2  px-10">
          <div className="text-teal-600 w-[450px] font-semibold uppercase text-lg">
            <h4> Prefix for the About Section will be written here</h4>
          </div>
          <div className="text-gray-800 ml-[-50px] w-[650px] text-lg leading-relaxed">
            This part will introduce you or your business to website visitors. We'll write about you, your organization, the products or services you offer, and why your company exists.
          </div>
          <div>  <h1 className='text-[44px] ml- w-[400px]'>Short Headline for Company About Section Will Be Here​</h1> </div>
          <div className='text-teal-600 mt-5  ml-[-50px] w-[700px]'>For this part, we will write an additional introduction of yourself or your business. This can be about your company history, success stories, or the product or services you offer. It can also tell about how you helped clients achieve their desired results.</div>
        </div>
      </div>


      {/* next section */}
      <div className='w-full p-30 font-sans'>
        <div className=''>
          <div className='font-semibold uppercase text-teal-600'>Prefix for the Footer Call to action section will be here</div>
          <div className='text-[44px] mt-3'>Headline Describing The Company Approach Will Be Here</div>

          <div className='flex mt-14 gap-35'>
            <div className='w-[500px] text-teal-600'><div className='text-[20px] mb-6 text-black font-[500]'>Approach 1</div>In this part, we will highlight details about the approach your company uses to serve clients and help them achieve their desired results</div>
            <div className='w-px h-20 bg-gray-400 '></div>
            <div className='w-[500px] text-teal-600'><div className='text-[20px] mb-6 text-black font-[500]'>Approach 1</div>In this part, we will highlight details about the approach your company uses to serve clients and help them achieve their desired results</div>
          </div>
        </div>
      </div>
      <Footer />
    </>
  )
}

export default About