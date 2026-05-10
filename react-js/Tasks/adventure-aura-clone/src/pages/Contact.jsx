import explore from '../assets/images/contact/explore.jpg'
import ContactHero from '../assets/images/contact/contact-hero.jpg'
import { FaLocationDot } from "react-icons/fa6";
import { FaPhoneAlt } from "react-icons/fa";
import { MdEmail } from "react-icons/md";
import Footer from '../components/Footer';

let Contact = () => {
    return <>
        <section className="relative z-10 w-screen h-full">
            <div className="absolute z-20 inset-0 bg-cover" style={{ backgroundImage: `url(${ContactHero})` }}></div>
            <div className="py-55 relative z-30 flex justify-center items-center bg-[#00000099]">
                <div className="w-1/2 flex flex-col justify-start items-center">
                    <p className="text-white text-lg w-fit bg-[#88888888] py-1 px-9 rounded-3xl">{'Say Hello to New Destinations'.toUpperCase()}</p>
                    <h1 className="text-white w-fit text-7xl text-center py-5">Ready to Explore? Contact Us!</h1>
                    <ul className="flex justify-center items-center gap-4 text-white mt-15">
                        <li className="flex justify-center items-center gap-2">
                            <span className="inline-block w-[13px]">
                                <svg aria-hidden="true" className="fill-white text-white" class="e-font-icon-svg e-far-check-square" viewBox="0 0 448 512" xmlns="http://www.w3.org/2000/svg"><path d="M400 32H48C21.49 32 0 53.49 0 80v352c0 26.51 21.49 48 48 48h352c26.51 0 48-21.49 48-48V80c0-26.51-21.49-48-48-48zm0 400H48V80h352v352zm-35.864-241.724L191.547 361.48c-4.705 4.667-12.303 4.637-16.97-.068l-90.781-91.516c-4.667-4.705-4.637-12.303.069-16.971l22.719-22.536c4.705-4.667 12.303-4.637 16.97.069l59.792 60.277 141.352-140.216c4.705-4.667 12.303-4.637 16.97.068l22.536 22.718c4.667 4.706 4.637 12.304-.068 16.971z"></path></svg>
                            </span>
                            <span>Trusted Partner</span>
                        </li>
                        <li className="flex justify-center items-center gap-2">
                            <span className="inline-block w-[13px]">
                                <svg aria-hidden="true" className="fill-white text-white" class="e-font-icon-svg e-fas-headphones-alt" viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg"><path d="M160 288h-16c-35.35 0-64 28.7-64 64.12v63.76c0 35.41 28.65 64.12 64 64.12h16c17.67 0 32-14.36 32-32.06V320.06c0-17.71-14.33-32.06-32-32.06zm208 0h-16c-17.67 0-32 14.35-32 32.06v127.88c0 17.7 14.33 32.06 32 32.06h16c35.35 0 64-28.71 64-64.12v-63.76c0-35.41-28.65-64.12-64-64.12zM256 32C112.91 32 4.57 151.13 0 288v112c0 8.84 7.16 16 16 16h16c8.84 0 16-7.16 16-16V288c0-114.67 93.33-207.8 208-207.82 114.67.02 208 93.15 208 207.82v112c0 8.84 7.16 16 16 16h16c8.84 0 16-7.16 16-16V288C507.43 151.13 399.09 32 256 32z"></path></svg>
                            </span>
                            <span>24/7 Support</span>
                        </li>
                        <li className="flex justify-center items-center gap-2">
                            <span className="inline-block w-[13px]">
                                <svg aria-hidden="true" className="fill-white text-white" class="e-font-icon-svg e-fas-dot-circle" viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg"><path d="M256 8C119.033 8 8 119.033 8 256s111.033 248 248 248 248-111.033 248-248S392.967 8 256 8zm80 248c0 44.112-35.888 80-80 80s-80-35.888-80-80 35.888-80 80-80 80 35.888 80 80z"></path></svg>
                            </span>
                            <span>Best Price Guarantee</span>
                        </li>
                    </ul>
                </div>
            </div>
        </section>
        <section className="w-screen flex h-full justify-center items-center -mt-35 relative z-20">
            <div className="w-[80%] h-full flex flex-col py-15 rounded-t-[60px] bg-white">
                <div className="w-full flex justify-between items-start mb-30">
                    <div className="w-[60%] h-full px-10">
                        <form action="">
                            <div className="flex flex-col py-3 gap-2">
                                <label htmlFor="name">Name *</label>
                                <input type="text" name="" id="name" className="outline-0 border text-gray-300 p-3 rounded" />
                            </div>
                            <div className="flex flex-col py-3 gap-2">
                                <label htmlFor="email">Email *</label>
                                <input type="email" name="" id="email" className="outline-0 border text-gray-300 p-3 rounded" />
                            </div>
                            <div className="flex flex-col py-3 gap-2">
                                <label htmlFor="phone">Phone *</label>
                                <input type="tel" name="" id="phone" className="outline-0 border text-gray-300 p-3 rounded" />
                            </div>
                            <div className="flex flex-col py-3 gap-2">
                                <label htmlFor="message">Your Message *</label>
                                <textarea type="text" name="" id="message" className="outline-0 border text-gray-300 p-3 rounded"></textarea>
                            </div>
                            <button className='bg-[#FB5607] text-white py-3 px-7 rounded-lg mt-5'>Submit</button>
                        </form>
                    </div>
                    <div className="w-[40%] h-full">
                        <div className='w-[85%] relative'>
                            <img src={explore} alt="" className='w-full object-cover rounded-[80px]' />
                            <div className='absolute inset-0 text-center bg-[#00000077] rounded-[80px]'>
                                <h1 className='bottom-0 text-white text-6xl relative top-80 italic'>Explore</h1>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="w-full h-full flex justify-center items-stretch gap-5 mb-40">
                    <div className='w-full bg-[#FFF7EC] flex justify-center items-start p-10 gap-5 rounded-4xl'>
                        <div className='bg-[#FB5607] p-3 rounded-[50%]'>
                            <FaLocationDot className='text-white' />
                        </div>
                        <div>
                            <h1 className='text-2xl font-bold pb-3'>Address</h1>
                            <p className='tracking-wide'>455 West Orchard Street Kings Mountain, NC 280867</p>
                        </div>
                    </div>
                    <div className='w-full bg-[#FFF7EC] flex justify-start items-start p-10 gap-5 rounded-4xl'>
                        <div className='bg-[#FB5607] p-3 rounded-[50%]'>
                            <FaPhoneAlt className='text-white' />
                        </div>
                        <div>
                            <h1 className='text-2xl font-bold pb-3'>Phone</h1>
                            <p className='tracking-wide'>+088 (246) 642-27-10</p>
                        </div>
                    </div>
                    <div className='w-full bg-[#FFF7EC] flex justify-start items-start p-10 gap-5 rounded-4xl'>
                        <div className='bg-[#FB5607] p-3 rounded-[50%]'>
                            <MdEmail className='text-white' />
                        </div>
                        <div>
                            <h1 className='text-2xl font-bold pb-3'>Email</h1>
                            <p className='tracking-wide'>info@example.com</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <Footer />
    </>
}

export default Contact