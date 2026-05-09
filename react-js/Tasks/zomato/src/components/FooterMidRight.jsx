import { FaFacebook } from "react-icons/fa";
import { FaTwitter } from "react-icons/fa";
import { FaInstagramSquare } from "react-icons/fa";
import appstore from '../assets/images/appstore.webp'
import playstore from '../assets/images/playstore.webp'

const FooterMidRight = () => {
    return <>
        <div className='w-[25%] flex flex-col justify-start items-start gap-3 mt-10'>
            <h1>SOCIAL LINKS</h1>
            <div className="flex gap-8">
                <FaFacebook className="text-[20px]" />
                <FaTwitter className="text-[20px]" />
                <FaInstagramSquare className="text-[20px]" />
            </div>
            <div className="flex flex-col gap-4 w-[50%]">
                <img src={appstore} alt="" />
                <img src={playstore} alt="" />
            </div>
        </div>
    </>
}

export default FooterMidRight