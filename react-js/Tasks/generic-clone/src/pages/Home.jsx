import React from 'react'
import { FaQuoteLeft } from 'react-icons/fa';
import Footer from '../components/Footer';
import HomeBackground from '../assets/hero-bg.jpg'
import Cta from '../assets/cta.jpg'

const testimonials = [
  {
    quote: `"We will write a hypothetical testimonial from a satisfied customer. You can replace this with actual testimonials from your clients. Testimonials are a great way to inspire potential customers to trust you."`,
    author: 'Testimonial Author Name',
  },
  {
    quote: `"We will write a hypothetical testimonial from a satisfied customer. You can replace this with actual testimonials from your clients. Testimonials are a great way to inspire potential customers to trust you."`,
    author: 'Testimonial Author Name',
  },
  {
    quote: `"We will write a hypothetical testimonial from a satisfied customer. You can replace this with actual testimonials from your clients. Testimonials are a great way to inspire potential customers to trust you."`,
    author: 'Testimonial Author Name',
  },
];

function Home() {
  return (
    <>
      <div className="relative p-40 w-full overflow-hidden font-sans">
        {/* Blurred Background */}
        <div className="absolute inset-0 h-full w-full bg-no-repeat bg-cover bg-center filter  brightness-19" style={{backgroundImage: `url(${HomeBackground})`}}></div>

        {/* Foreground Text */}
        <div className="relative z-10 h-full w-full flex flex-col items-center justify-center text-white text-center px-4 font-sans">
          <h1 className="text-[15px] uppercase tracking-widest"> Prefix describing what your business does will be here</h1>
          <h2 className="text-[50px] sm:text-[56px] font-semibold mt-4">We Will Write a Headline</h2>
          <h2 className="text-[50px] sm:text-[56px] font-semibold"> Highlighting Your Business</h2>
          <h2 className="text-[50px] sm:text-[56px] font-semibold">Offerings Here</h2>
          <button className='bg-[#2A9D8F] w-[180px] h-[40px] mt-10'>CALL TO ACTION</button>
        </div>
      </div>


      {/* 2nd section */}


      <div className='relative  flex w-full  justify-center gap-5  '>
        <div className='absolute  shadow w-[550px] p-15 pt-30 mr-146 mt-[-80px] bg-white'>
          <div className=''>ABOUT US</div>
          <div className='mt-5 text-[40px]'>Short Headline for Company About Section Will Be Here</div>
          <div className='mt-6'>This part will introduce you or your business to website visitors. We'll write about you, your organization, the products or services you offer, and why your company exists.</div>
          <button className='bg-[#2A9D8F] w-[180px] h-[40px] mt-10'>CALL TO ACTION</button>
        </div>
        <div className=" w-[550px] ml-146 mt-[-80px]"><img src="https://websitedemos.net/generic-02/wp-content/uploads/sites/1454/2024/03/about-us.jpg" alt="" /></div>
      </div>

      <div>
        <div className='mt-20 uppercase tracking-widest text-center'>Prefix describing what your business does will be here</div>
        <div className='w-[1000px] text-center ml-70 text-[45px]'>Headline Describing Your Company Core Values Will Come Here</div>
      </div>

      {/* next section */}

      <div className='w-full m-auto p-20'>
        <div className='flex w-full justify-center gap-20'>
          <div className='w-[320px] '><div>01</div>
            <div className='font-sans text-[20px] font-bold mt-3'>Core Value</div>
            <div className='mt-2 font-mulish leading-[27px]'>In this part, we will write about the core values and guiding principles that influence your business choices and operations.</div>
          </div>
          <div className='w-[320px] '><div>01</div>
            <div className='font-sans text-[20px] font-bold mt-3'>Core Value</div>
            <div className='mt-2 font-mulish leading-[27px]'>In this part, we will write about the core values and guiding principles that influence your business choices and operations.</div>
          </div>
          <div className='w-[320px] '><div>01</div>
            <div className='font-sans text-[20px] font-bold mt-3'>Core Value</div>
            <div className='mt-2 font-mulish leading-[27px]'>In this part, we will write about the core values and guiding principles that influence your business choices and operations.</div>
          </div>
        </div>
      </div>

      {/* next */}


      <div className="relative p-17 w-full overflow-hidden font-sans">
        {/* Blurred Background */}
        <div className="absolute inset-0 h-full bg-cover bg-center filter  brightness-19" style={{backgroundImage: `url(${Cta})`}}></div>

        {/* Foreground Text */}
        <div className="relative z-10 h-full w-full flex flex-col items-center justify-center text-white text-center px-4 font-sans">
          <h1 className="text-[15px] uppercase tracking-widest">Prefix for the Footer Call to action section will be here</h1>
          <h2 className="text-[50px] sm:text-[40px] font-semibold mt-4">Heading for the Middle Call to Action Will Be Written</h2>
          <h2 className="text-[50px] sm:text-[40px] font-semibold"> Here</h2>
          <button className='bg-[#2A9D8F] w-[180px] h-[40px] mt-10'>CALL TO ACTION</button>
        </div>
      </div>

      {/* next section */}


      <section className="bg-white py-20 px-6 md:px-20 font-sans">
        <div className="grid grid-cols-1 md:grid-cols-2 gap-10 items-start">
          {/* Left Content */}
          <div className='p-10'>
            <p className="text-[#2A9D8F] uppercase text-[16px] w-[450px] font-semibold text-[0px]tracking-wider mb-4">
              We will write a prefix describing what makes people choose your business here
            </p>
            <h2 className="text-4xl md:text-5xl font-bold leading-tight mb-6">
              Headline for Company About Section Will Be Here
            </h2>
            <p className="text-gray-600 text-lg leading-relaxed">
              In this part, we will write a sub-headline briefly describing your company&apos;s unique value proposition.
            </p>
          </div>

          {/* Right Content */}
          <div className="space-y-10">
            {/* Value Prop 1 */}
            <div>
              <h3 className="text-2xl font-semibold mb-2">Unique Value Proposition 1</h3>
              <p className="text-gray-600 leading-relaxed">
                In this part, we will write about what makes your business unique and the value people get from using your products or services over competitors.
              </p>
              <hr className="mt-6" />
            </div>

            {/* Value Prop 2 */}
            <div>
              <h3 className="text-2xl font-semibold mb-2">Unique Value Proposition 2</h3>
              <p className="text-gray-600 leading-relaxed">
                In this part, we will write about what makes your business unique and the value people get from using your products or services over competitors.
              </p>
              <hr className="mt-6" />
            </div>

            {/* Value Prop 3 */}
            <div>
              <h3 className="text-2xl font-semibold mb-2">Unique Value Proposition 3</h3>
              <p className="text-gray-600 leading-relaxed">
                In this part, we will write about what makes your business unique and the value people get from using your products or services over competitors.
              </p>
            </div>
          </div>
        </div>
      </section>

      {/* next section */}

      <section className="bg-[#eaf4f3] py-20 px-6 md:px-20 font-sans">
        <h2 className="text-3xl md:text-4xl font-semibold text-center mb-12">
          Short Heading for Testimonials Section
        </h2>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
          {testimonials.map((testimonial, index) => (
            <div key={index} className="bg-white p-8 shadow-sm rounded-md">
              <FaQuoteLeft className="text-[#2A9D8F] text-3xl mb-4" />
              <p className="text-gray-700 text-lg leading-relaxed mb-6">
                {testimonial.quote}
              </p>
              <p className="font-semibold text-black">– {testimonial.author}</p>
            </div>
          ))}
        </div>
      </section>
      <Footer />
    </>
  )
}

export default Home