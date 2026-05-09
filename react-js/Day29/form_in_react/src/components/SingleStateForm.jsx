import { useState } from "react"


let SingleStateForm = () => {

    let [formData, setFormData] = useState({
        firstname: "",
        email: "",
        contact: "",
        address: "",
        dob: "",
        age: "",
    })

    let { firstname, email, contact, address, dob, age } = formData;

    let handleChange = (e) => {
        let { name, value } = e.target;
        setFormData({...formData, [name]: value})
    }

    let handleSubmit = (e) => {
        e.preventDefault();
        console.log(formData);
        setFormData({
            firstname: "",
            email: "",
            contact: "",
            address: "",
            dob: "",
            age: "",
        })
    }

    return <>
        <section className="w-screen h-screen flex justify-center items-center border">
            <div className="w-1/3 bg-black text-white flex justify-center items-center p-3">
                <form onSubmit={handleSubmit} action="" className="bg-black text-white w-full h-full">
                    <div className="flex flex-col">
                        <label htmlFor="fname">First Name:</label>
                        <input type="text" name="firstname" id="fname" value={firstname} onChange={handleChange} className="border border-white outline-none rounded p-2 my-1" />
                    </div>
                    <div className="flex flex-col">
                        <label htmlFor="email">Email:</label>
                        <input type="email" name="email" id="email" value={email} onChange={handleChange} className="border border-white outline-none rounded p-2 my-1" />
                    </div>
                    <div className="flex flex-col">
                        <label htmlFor="contact">Contact:</label>
                        <input type="tel" name="contact" id="contact" value={contact} onChange={handleChange} className="border border-white outline-none rounded p-2 my-1" />
                    </div>
                    <div className="flex flex-col">
                        <label htmlFor="address">Address:</label>
                        <input type="text" name="address" id="address" value={address} onChange={handleChange} className="border border-white outline-none rounded p-2 my-1" />
                    </div>
                    <div className="flex flex-col">
                        <label htmlFor="dob">Date Of Birth:</label>
                        <input type="date" name="dob" id="dob" value={dob} onChange={handleChange} className="border border-white outline-none rounded p-2 my-1" />
                    </div>
                    <div className="flex flex-col">
                        <label htmlFor="age">Age:</label>
                        <input type="number" name="age" id="age" value={age} onChange={handleChange} className="border border-white outline-none rounded p-2 my-1" />
                    </div>
                    <input type="submit" name="" id="" className="border border-white outline-none rounded p-2 my-1 cursor-pointer" />
                </form>
            </div>
        </section>
    </>
}

export default SingleStateForm