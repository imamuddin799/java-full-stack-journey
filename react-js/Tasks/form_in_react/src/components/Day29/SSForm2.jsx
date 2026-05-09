import { useState } from "react"


let SSForm2 = () => {

    let [formData, setFormData] = useState({
        firstname: "",
        lastname: "",
        email: "",
        phone: "",
        password: "",
        terms: false
    })

    let { firstname, lastname, email, phone, password, terms } = formData

    let handleChange = (e) => {
        let { name, value } = e.target
        name === 'terms' && (value = !!value)
        setFormData({ ...formData, [name]: value })
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
            terms: false
        })
    }

    return <>
        <section className="w-screen h-screen flex justify-center items-center">
            <div className="w-[70%] bg-blue-700 flex justify-start items-center rounded-xl shadow-[4px_4px_20px_#00000055]">
                <div className="w-full h-full flex justify-center items-center">
                    <div className="w-[64%] flex flex-col gap-5">
                        <h1 className="text-3xl font-medium text-white ">We make digital products that drive you to stand out</h1>
                        <p className="text-white">We write words, take photos, make videos and interact with artificial intelligence</p>
                    </div>
                </div>

                <div className="w-full h-full bg-white p-8 rounded-r-xl">
                    <div className="w-full py-8">
                        <h1 className="text-2xl font-medium">Registration</h1>
                        <p className="text-sm font-medium text-gray-500">Enter your details to register</p>
                    </div>
                    <form action="" onSubmit={handleSubmit} className="w-full flex flex-col gap-2 border-b border-gray-300 pb-6">
                        <div className="w-full flex flex-col gap-1">
                            <label className="font-medium" htmlFor="fname">First Name</label>
                            <input type="text" name="firstname" id="fname" value={firstname} onChange={handleChange} placeholder="First Name" className="outline-0 border rounded p-1 w-full border-gray-300" />
                        </div>
                        <div className="w-full flex flex-col gap-1">
                            <label className="font-medium" htmlFor="lname">Last Name</label>
                            <input type="text" name="lastname" id="lname" value={lastname} onChange={handleChange} placeholder="Last Name" className="outline-0 border rounded p-1 w-full border-gray-300" />
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
                        <div className="flex justify-start items-center py-2">
                            <input type="checkbox" name="terms" id="terms" onChange={handleChange} className="outline-0 border rounded p-1 border-gray-300 w-5 h-5 mr-2" />
                            <label htmlFor="terms">I agree to the <span className="text-blue-700">terms and conditions</span></label>
                        </div>
                        <div>
                            <button className="w-full bg-blue-700 rounded-lg p-2 text-white font-medium cursor-pointer">Sign Up</button>
                        </div>
                    </form>
                    <div className="text-center py-4">
                        <a href="#" className="text-blue-700">Already Have an Account?</a>
                    </div>
                </div>
            </div>
        </section>
    </>
}

export default SSForm2