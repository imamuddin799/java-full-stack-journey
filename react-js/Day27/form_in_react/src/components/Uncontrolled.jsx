import { useRef } from "react"

const Uncontrolled = () => {
    let fnameref = useRef();
    let lnameref = useRef();
    let emailref = useRef();

    let handleSubmit = (e) => {
        
        e.preventDefault();
        console.log(fnameref.current.value);
        console.log(lnameref.current.value);
        console.log(emailref.current.value);

        let fname = fnameref.current.value;
        let lname = lnameref.current.value;
        let email = emailref.current.value;

        console.log(fname);
        console.log(lname);
        console.log(email);

        fnameref.current.value = "";
        lnameref.current.value = "";
        emailref.current.value = "";
    }
    return <>
        <form className="w-[400px] mx-auto bg-[#efefef] p-4 mt-10 rounded-[10px]" action="">
            <div className="flex flex-col">
                <label htmlFor="fname">First Name:</label>
                <input type="text" name="" id="fname" ref={fnameref} className="border-1 outline-none" />
            </div>
            <div className="flex flex-col">
                <label htmlFor="lname">Last Name:</label>
                <input type="text" name="" id="lname" ref={lnameref} className="border-1 outline-none" />
            </div>
            <div className="flex flex-col">
                <label htmlFor="email">Email Name:</label>
                <input type="text" name="" id="email" ref={emailref} className="border-1 outline-none" />
            </div>
            <div className="flex justify-center mt-4">
                <button className="w-[80%] bg-orange-500 rounded-[4px] py-2 cursor-pointer text-white" onClick={handleSubmit}>Submit</button>
            </div>
        </form>
    </>
}

export default Uncontrolled