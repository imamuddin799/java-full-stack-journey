import service1 from '../assets/images/offerings/services-01.jpg'
import service2 from '../assets/images/offerings/services-02.jpg'
import service3 from '../assets/images/offerings/services-03.jpg'
import serviceBackground from '../assets/images/offerings/services-bg.jpg'
import qoute from '../assets/images/offerings/download (1).svg'
import Footer from '../components/Footer'

const Offerings = () => {
    return (
        <>
            <div className="relative top-0 h-full w-screen">
                <div className="absolute inset-0 h-full w-full bg-no-repeat bg-cover bg-center filter  brightness-25" style={{backgroundImage: `url(${serviceBackground})`}}></div>
                <div className="relative z-10 h-full w-full flex flex-col items-center justify-center text-white text-center py-45 font-sans">
                    <div className='flex flex-col gap-10 w-1/2'>
                        <p className='text-lg'>OFFERINGS</p>
                        <h1 className='text-6xl'>Headline for the Offering Page Will Be Here</h1>
                    </div>
                </div>
            </div>
            <div className='w-[80%] mx-auto -mt-20 relative flex flex-col gap-4'>
                <div className='w-full h-full flex justify-between items-center bg-white'>
                    <div className='w-[51%] h-full flex flex-col justify-center items-start px-20'>
                        <p className='text-xl text-gray-500'>01</p>
                        <h1 className='text-4xl font-medium py-5'>Offering 1</h1>
                        <p className='text-[17px] text-gray-500'>
                            For this part, we will write an additional introduction of yourself or your business. This can be about your company history, success stories, or the product or services you offer. It can also tell about how you helped clients achieve their desired results.
                        </p>
                    </div>
                    <div className='w-[49%]'>
                        <img src={service1} alt="" className='w-full h-full object-cover' />
                    </div>
                </div>
                <div className='w-full h-full flex justify-between items-center bg-white'>
                    <div className='w-[49%]'>
                        <img src={service2} alt="" className='w-full h-full object-cover' />
                    </div>
                    <div className='w-[51%] h-full flex flex-col justify-center items-start px-20'>
                        <p className='text-xl text-gray-500'>02</p>
                        <h1 className='text-4xl font-medium py-5'>Offering 2</h1>
                        <p className='text-[17px] text-gray-500'>
                            For this part, we will write an additional introduction of yourself or your business. This can be about your company history, success stories, or the product or services you offer. It can also tell about how you helped clients achieve their desired results.
                        </p>
                    </div>
                </div>
                <div className='w-full h-full flex justify-between items-center bg-white'>
                    <div className='w-[51%] h-full flex flex-col justify-center items-start px-20'>
                        <p className='text-xl text-gray-500'>03</p>
                        <h1 className='text-4xl font-medium py-5'>Offering 3</h1>
                        <p className='text-[17px] text-gray-500'>
                            For this part, we will write an additional introduction of yourself or your business. This can be about your company history, success stories, or the product or services you offer. It can also tell about how you helped clients achieve their desired results.
                        </p>
                    </div>
                    <div className='w-[49%]'>
                        <img src={service3} alt="" className='w-full h-full object-cover' />
                    </div>
                </div>
            </div>
            <div className='w-full flex flex-col justify-center items-center mt-30 pb-20'>
                <div className='w-1/2'>
                    <img src={qoute} alt="" className='w-[30px] mx-auto opacity-40' />
                    <p className='text-xl font-medium text-center py-10'>"We will write a hypothetical testimonial from a satisfied customer. You can replace this with actual testimonials from your clients. Testimonials are a great way to inspire potential customers to trust you."</p>
                    <h1 className='text-center text-lg font-light text-[#2A9D8F]'>– TESTIMONIAL AUTHOR NAME</h1>
                </div>
            </div>
            <Footer />
        </>
    );
};

export default Offerings;
