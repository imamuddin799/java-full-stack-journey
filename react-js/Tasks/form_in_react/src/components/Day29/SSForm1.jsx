import { useState } from "react"


let SSForm1 = () => {

    let [formData, setFormData] = useState({
        firstname: "",
        lastname: "",
        email: "",
        phone: "",
        password: "",
    })

    let {firstname, lastname, email, phone, password} = formData

    let handleChange = (e) => {
        let { name, value } = e.target
        setFormData({...formData, [name]: value})
    }

    let handleSubmit = (e) => {
        e.preventDefault()
        console.log(formData);
        setFormData({
            firstname: "",
            lastname: "",
            email: "",
            phone: "",
            password: "",
        })
    }

    return <>
        <section className="w-screen h-screen flex justify-center items-center">
            <div className="w-1/3 flex flex-col justify-start items-center pb-4 rounded-xl shadow-[4px_4px_20px_#00000055]">
                <div className="w-full text-center mt-8 mb-4">
                    <h1 className="text-4xl font-light text-[#519E8A]">Create Account</h1>
                </div>
                <form action="" onSubmit={handleSubmit} className="w-full px-6 flex flex-col gap-2">
                    <div className="w-full flex gap-2">
                        <div className="w-full flex flex-col gap-1">
                            <label className="font-medium" htmlFor="fname">First Name</label>
                            <input type="text" name="firstname" id="fname" value={firstname} onChange={handleChange} placeholder="First Name" className="outline-0 border rounded p-1 w-full border-gray-300" />
                        </div>
                        <div className="w-full flex flex-col gap-1">
                            <label className="font-medium" htmlFor="lname">Last Name</label>
                            <input type="text" name="lastname" id="lname" value={lastname} onChange={handleChange} placeholder="Last Name" className="outline-0 border rounded p-1 w-full border-gray-300" />
                        </div>
                    </div>
                    <div className="flex flex-col gap-1">
                        <label className="font-medium" htmlFor="email">Email</label>
                        <input type="email" name="email" id="email" value={email} onChange={handleChange} placeholder="Email" className="outline-0 border rounded p-1 border-gray-300 w-full " />
                    </div>
                    <div className="flex flex-col gap-1">
                        <label className="font-medium" htmlFor="phone">Phone</label>
                        <input type="tel" name="phone" id="phone" value={phone} onChange={handleChange} placeholder="Phone" className="outline-0 border rounded p-1 border-gray-300 w-full " />
                    </div>
                    <div className="flex flex-col gap-1">
                        <label className="font-medium" htmlFor="password">Password</label>
                        <input type="password" name="password" id="password" value={password} onChange={handleChange} placeholder="Password" className="outline-0 border rounded p-1 border-gray-300 w-full " />
                    </div>
                    <div>
                        <button className="w-full bg-[#519E8A] p-2 text-white my-2 cursor-pointer">Create Account</button>
                    </div>
                </form>
                <div>
                    <a href="#" className="text-[#519E8A]">Already Have an Account?</a>
                </div>
            </div>
        </section>
    </>
}

export default SSForm1