import { IoMdPerson } from "react-icons/io";
import { AiOutlineMail } from "react-icons/ai";
import { FaPhoneSquareAlt } from "react-icons/fa";
import { FaAddressBook } from "react-icons/fa6";
import { RiLockPasswordFill } from "react-icons/ri";
import bg from '../assets/bg.jpg'
import { useRef } from "react";

const FormExample = () => {

    let fnameref = useRef();
    let lnameref = useRef();
    let emailref = useRef();
    let phoneref = useRef();
    let addressref = useRef();
    let passwordref = useRef();

    let handleSubmit = (e) => {
        e.preventDefault();
        console.log(fnameref.current.value);
        console.log(lnameref.current.value);
        console.log(emailref.current.value);
        console.log(phoneref.current.value);
        console.log(addressref.current.value);
        console.log(passwordref.current.value);

        fnameref.current.value = ""
        lnameref.current.value = ""
        emailref.current.value = ""
        phoneref.current.value = ""
        addressref.current.value = ""
        passwordref.current.value = ""
    }
    return <>
        <div className="w-screen h-screen flex justify-center items-center" style={{ backgroundImage: `url(${bg})` }}>
            <div className="w-1/3 border-2 border-white p-3 rounded-lg bg-[#00000088]">
                <div className="text-center font-medium text-3xl m-4 text-white">
                    <h1>Registration Form</h1>
                </div>
                <div>
                    <form action="" className="flex flex-col gap-4 text-white" onSubmit={handleSubmit}>
                        <div className="flex flex-col gap-1">
                            <div className="flex justify-between gap-4">
                                <div>
                                    <label htmlFor="fname" className="font-medium text-xl">First Name</label>
                                    <div className="flex justify-start items-center border rounded-lg">
                                        <input type="text" name="" id="fname" className="w-full p-2 outline-0" ref={fnameref} />
                                        <IoMdPerson className="text-4xl mr-2 text-white" />
                                    </div>
                                </div>
                                <div>
                                    <label htmlFor="lname" className="font-medium text-xl">Last Name</label>
                                    <div className="flex justify-start items-center border rounded-lg">
                                        <input type="text" name="" id="lname" className="w-full p-2 outline-0" ref={lnameref} />
                                        <IoMdPerson className="text-4xl mr-2 text-white" />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <label htmlFor="email" className="font-medium text-xl">Email</label>
                                <div className="flex justify-start items-center border rounded-lg">
                                    <input type="email" name="" id="email" className="w-full p-2 outline-0" ref={emailref} />
                                    <AiOutlineMail className="text-4xl mr-2 text-white" />
                                </div>
                            </div>
                            <div>
                                <label htmlFor="phone" className="font-medium text-xl">Phone</label>
                                <div className="flex justify-start items-center border rounded-lg">
                                    <input type="tel" name="" id="phone" className="w-full p-2 outline-0" ref={phoneref} />
                                    <FaPhoneSquareAlt className="text-4xl mr-2 text-white" />
                                </div>
                            </div>
                            <div>
                                <label htmlFor="address" className="font-medium text-xl">Address</label>
                                <div className="flex justify-start items-center border rounded-lg">
                                    <textarea type="text" name="" id="address" className="w-full p-2 outline-0" ref={addressref} ></textarea>
                                    <FaAddressBook className="text-4xl mr-2 text-white" />
                                </div>
                            </div>
                            <div>
                                <label htmlFor="password" className="font-medium text-xl">Password</label>
                                <div className="flex justify-start items-center border rounded-lg">
                                    <input type="password" name="" id="password" className="w-full p-2 outline-0" ref={passwordref} />
                                    <RiLockPasswordFill className="text-4xl mr-2 text-white" />
                                </div>
                            </div>
                        </div>
                        <div className="flex justify-center">
                            <button className="border rounded-lg w-full bg-white text-black font-medium text-2xl p-2 cursor-pointer hover:bg-[#00000077] hover:text-[#ccc]">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </>
}

export default FormExample