import milk from '../../assets/landingpage/images/desktop/image-gallery-milkbottles.jpg'
import orange from '../../assets/landingpage/images/desktop/image-gallery-orange.jpg'
import cone from '../../assets/landingpage/images/desktop/image-gallery-cone.jpg'
import sugercubes from '../../assets/landingpage/images/desktop/image-gallery-sugarcubes.jpg'
import logo from '../../assets/landingpage/images/logo.svg'
import facebook from '../../assets/landingpage/images/icon-facebook.svg'
import instagram from '../../assets/landingpage/images/icon-instagram.svg'
import pinterest from '../../assets/landingpage/images/icon-pinterest.svg'
import twitter from '../../assets/landingpage/images/icon-twitter.svg'

let Footer = () => {
    return <>
        <section className="w-full">
            <div className='flex w-full'>
                <div className='w-full'>
                    <img src={milk} alt="" className='w-[100%]' />
                </div>

                <div className='w-full'>
                    <img src={orange} alt="" className='w-[100%]' />
                </div>

                <div className='w-full'>
                    <img src={cone} alt="" className='w-[100%]' />
                </div>

                <div className='w-full'>
                    <img src={sugercubes} alt="" className='w-[100%]' />
                </div>

            </div>
            <div className="w-full bg-[#90d4c5] flex justify-center items-center">
                <div className='py-20'>
                    <div className='flex justify-center items-center'>
                        <img src={logo} alt="" className='filter invert opacity-50 h-[35px]' />
                    </div>
                    <div className='flex gap-20 pt-10 pb-25'>
                        <a href="" className='text-xl font-medium text-gray-500'>About</a>
                        <a href="" className='text-xl font-medium text-gray-500'>Services</a>
                        <a href="" className='text-xl font-medium text-gray-500'>Projects</a>
                    </div>
                    <div className='flex justify-center items-center gap-7'>
                        <img src={facebook} alt="" />
                        <img src={instagram} alt="" />
                        <img src={twitter} alt="" />
                        <img src={pinterest} alt="" />
                    </div>
                </div>
            </div>
        </section>
    </>
}

export default Footer