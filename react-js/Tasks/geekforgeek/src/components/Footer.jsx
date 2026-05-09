import { CiLocationOn } from "react-icons/ci";
import { FaFacebook } from "react-icons/fa";
import { FaInstagram } from "react-icons/fa6";
import { FaLinkedin } from "react-icons/fa";
import { FaSquareXTwitter } from "react-icons/fa6";
import { IoLogoYoutube } from "react-icons/io";
import links from '../data/footerLinks.json'
import { Fragment, useState } from "react";


let Footer = () => {

    let [footerLinks] = useState(links);
    console.log(footerLinks);
    return <>
        <section className="w-screen flex justify-center items-start pb-10">
            <div className="w-[95%] flex justify-between mt-12 gap-4">
                <div className="w-[23%]">
                    <div>
                        <img src="https://media.geeksforgeeks.org/auth-dashboard-uploads/gfgFooterLogo.png" alt="" />
                    </div>
                    <div className="w-full flex justify-start items-center gap-2 mt-2">
                        <CiLocationOn className="text-xl" />
                        <h1 className="font-medium">Corporate & Communications Address:</h1>
                    </div>
                    <div className="w-full pl-7 pr-4">
                        <p className="text-justify text-base/5 text-[14px] tracking-wide">A-143, 7th Floor, Sovereign Corporate Tower, Sector- 136, Noida, Uttar Pradesh (201305)</p>
                    </div>
                    <div className="w-full flex justify-start items-center gap-2 mt-2">
                        <CiLocationOn className="text-xl" />
                        <h1 className="font-medium">Registered Address:</h1>
                    </div>
                    <div className="w-full pl-7 pr-4">
                        <p className="text-justify text-base/5 text-[14px] tracking-wide">K 061, Tower K, Gulshan Vivante Apartment, Sector 137, Noida, Gautam Buddh Nagar, Uttar Pradesh, 201305</p>
                    </div>
                    <div className="flex gap-1 my-6">
                        <div className="p-1 bg-[#696969] rounded-2xl cursor-pointer"><FaFacebook className="text-3xl text-white" /></div>
                        <div className="p-1 bg-[#696969] rounded-2xl cursor-pointer"><FaInstagram className="text-3xl text-white" /></div>
                        <div className="p-1 bg-[#696969] rounded-2xl cursor-pointer"><FaLinkedin className="text-3xl text-white" /></div>
                        <div className="p-1 bg-[#696969] rounded-2xl cursor-pointer"><FaSquareXTwitter className="text-3xl text-white" /></div>
                        <div className="p-1 bg-[#696969] rounded-2xl cursor-pointer"><IoLogoYoutube className="text-3xl text-white" /></div>
                    </div>
                    <div className="flex gap-2 my-4">
                        <img src="https://media.geeksforgeeks.org/auth-dashboard-uploads/googleplay-%281%29.png" alt="" />
                        <img src="https://media.geeksforgeeks.org/auth-dashboard-uploads/appstore-%281%29.png" alt="" />
                    </div>
                    <div className="my-4">
                        <button className="bg-[#003A78] px-13 py-3 rounded-lg text-white font-medium text-sm cursor-pointer">Advertise with us</button>
                    </div>
                </div>


                <div className="w-[77%]  grid grid-cols-6 gap-4">
                    {
                        footerLinks.map((obj, index) => {
                            let { heading, links } = obj;
                            console.log(links);
                            return <Fragment key={index}>
                                <div className="w-full">
                                    <h1 className="text-lg text-[#308D46] font-medium">{ heading }</h1>
                                    <ul>
                                        {
                                            links.map((link, index) => {
                                                return <Fragment key={index}>
                                                    <li><a href="#" className="text-gray-600 hover:text-[#308D46] text-sm">{link}</a></li>
                                                </Fragment>
                                            })
                                        }
                                    </ul>
                                </div>
                            </Fragment>
                        })
                    }
                </div>
            </div>
        </section>
    </>
}

export default Footer