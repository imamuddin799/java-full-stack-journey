import face from '../assets/images/contact/download (3).svg'
import insta from '../assets/images/contact/download (5).svg'
import twitter from '../assets/images/contact/download (2).svg'
import linked from '../assets/images/contact/download (4).svg'
import youtube from '../assets/images/contact/download.svg'
import Footer from '../components/Footer'
import ContactBackGround from '../assets/images/contact/contact-bg.jpg'

const Contact = () => {
    return <>
        <div className="relative top-0 h-full w-screen">
            <div className="absolute inset-0 h-full w-full bg-no-repeat bg-cover bg-center filter  brightness-25" style={{backgroundImage: `url(${ContactBackGround})`}}></div>
            <div className="relative z-10 h-full w-full flex flex-col items-center justify-center text-white text-center py-45 font-sans">
                <div className='flex flex-col gap-10 w-1/2'>
                    <p className='text-lg'>CONTACT</p>
                    <h1 className='text-6xl'>Headline for the Contact Page Will Be Here</h1>
                </div>
            </div>
        </div>
        <div className="w-full h-full relative mb-30">
            <div className='w-[80%] mx-auto flex justify-center items-center'>
                <div className='w-[50%]'>
                    <h1 className='text-4xl font-medium'>Short heading for the Contact Us Section Will Be Here</h1>
                    <p className='text-gray-600 my-7'>We will write a sub-headline for the Contact Us Section here</p>
                    <div className='flex flex-col gap-1 text-gray-600'>
                        <p>A: 2360 Hood Avenue, San Diego, CA, 92123</p>
                        <p>P: 202-555-0188</p>
                        <p>E: contact@example.com</p>
                    </div>
                    <h1 className='text-2xl font-medium my-4'>Follow Us:</h1>
                    <div className='flex gap-7 mb-15'>
                        <img src={face} alt="" className='w-[20px]' />
                        <img src={insta} alt="" className='w-[20px]' />
                        <img src={twitter} alt="" className='w-[20px]' />
                        <img src={linked} alt="" className='w-[20px]' />
                        <img src={youtube} alt="" className='w-[20px]' />
                    </div>
                </div>
                <div className='w-[50%] flex flex-col p-15 bg-white -mt-25 pb-20'>
                    <p className='text-xl text-gray-500'>{'Prefix for the Contact Form section will be here'.toUpperCase()}</p>
                    <h1 className='text-2xl font-medium tracking-wide my-10'>Short heading for the Contact Form Section Will be Here</h1>
                    <form action="" className='flex flex-col'>
                        <input type="text" name="" id="" placeholder="Your Name" className='outline-0 border rounded border-gray-400  p-2 my-4' />
                        <input type="text" name="" id="" placeholder="Your Email" className='outline-0 border rounded border-gray-400  p-2 my-4' />
                        <textarea name="" id="" placeholder="Your Message" className='outline-0 border rounded border-gray-400  p-2 my-4' >
                        </textarea>
                        <div>
                            <button className='py-3 px-6 bg-[#2A9D8F] text-white rounded '>SUBMIT</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <Footer />
    </>
}

export default Contact