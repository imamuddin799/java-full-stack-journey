import { BsArrowRightCircle } from "react-icons/bs";
import { FaPhoneAlt } from "react-icons/fa";
import { IoMdMail } from "react-icons/io";

import image from '../assets/images/contact/image-12.png'
import image2 from '../assets/images/contact/Travel-50.svg'
import logo from '../assets/images/contact/header-logo-1.svg'
import { Link } from "react-router-dom";
import { Fragment } from "react";

let Footer = () => {

    // const links = [
    // <Link to='/'>Home</Link>,
    // <Link to='/about'>About</Link>,
    // <Link to='/packages'>Packages</Link>,
    // <Link to='/contact'>Contact</Link>,
    // ]

    const footerLinks = [
        {
            heading: "Quick Links",
            links: [
                <Link to='/'>Home</Link>,
                <Link to='/about'>About</Link>,
                <Link to='/packages'>Packages</Link>,
                <Link to='/contact'>Contact</Link>,
            ]
        },
        {
            heading: "Contact",
            links: [
                <p>455 West Orchard Street Kings Mountain, NC 280867</p>,
                <p className="flex justify-start items-center gap-3"><span className="text-[#FB5607] text-lg"><FaPhoneAlt /></span><span>+088 (246) 642-27-10</span></p>,
                <p className="flex justify-start items-center gap-3"><span className="text-[#FB5607] text-lg"><IoMdMail /></span><span>example@gmail.com</span></p>
            ]
        },
        {
            heading: "Follow Us",
            links: [
                <a href="#">Instagram</a>,
                <a href="#">Twitter</a>,
                <a href="#">LinkedIn</a>,
                <a href="#">Facebook</a>,
            ]
        },
    ]

    return <>
        <section className="bg-[#FB5607]  w-screen flex h-full justify-center items-center relative z-30">
            <div className="w-[78%] h-full flex justify-between items-end relative">
                <div className="absolute inset-0 flex justify-center items-center">
                    <img src={image2} alt="" />
                </div>
                <div className="w-full h-full py-28">
                    <h1 className="text-white text-5xl/15 font-medium">Ready to Start Your Adventure?</h1>
                    <p className="text-white pr-40 py-5">Let us help you create the perfect journey. Our travel experts are ready to craft your dream vacation.</p>
                    <button className="bg-white text-[#FB5607] flex justify-center items-center gap-3 py-3 px-8 text-lg font-medium rounded-lg mt-3"><span>Start Planning</span><span className="font-bold"><BsArrowRightCircle /></span></button>
                </div>
                <div className="w-full h-full relative z-0 flex justify-end items-end">
                    <img src={image} alt="" className="absolute bottom-0 z-[]" />
                </div>
            </div>
        </section>
        <section className="bg-black  w-screen flex flex-col h-full justify-center items-center relative z-30 pt-25">
            <div className="w-[80%] h-full flex justify-between items-start relative border-b pb-15 text-white">
                <div className="w-[35%] flex flex-col justify-between items-stretch">
                    <img src={logo} alt="" className="w-64" />
                    <p className="w-92 py-5">Your trusted partner for extraordinary travel experiences since 2015.</p>
                </div>
                <div className="w-[65%] grid grid-cols-3 justify-start items-start gap-15">
                    {/* <div>
                        <h1 className="text-xl font-medium mb-5">Quick Links</h1>
                        <ul className="flex flex-col gap-5">
                            <li>Home</li>
                            <li>About</li>
                            <li>Packages</li>
                            <li>Contact</li>
                        </ul>
                    </div> */}
                    {
                        footerLinks.map((element, index) => {
                            return <Fragment key={index}>
                                <div className="w-full">
                                    <h1 className="text-xl font-medium mb-9">{element.heading}</h1>
                                    <ul className="flex flex-col gap-5">
                                        {
                                            element.links.map((link, index) => {
                                                return <Fragment key={index}>
                                                    <li>{link}</li>
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
            <div>
                <h1 className="w-full text-center py-3 text-white">Copyright &copy; 2025 Travel Agency</h1>
            </div>
        </section>
    </>
}

export default Footer