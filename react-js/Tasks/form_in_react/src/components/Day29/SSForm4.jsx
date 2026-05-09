import { useState } from "react";

let SSForm4 = () => {
    let [formData, setFormData] = useState({
        fullname: "",
        username: "",
        email: "",
        contact: "",
        dob: "",
        gender: "",
        jobtitle: "",
        companyname: "",
        password: "",
        terms: false
    });

    let { fullname, username, email, contact, dob, gender, password, jobtitle, companyname } = formData;

    let handleSubmit = (e) => {
        e.preventDefault();
        console.log(formData);
        setFormData({
            fullname: "",
            username: "",
            email: "",
            contact: "",
            dob: "",
            gender: "",
            jobtitle: "",
            companyname: "",
            password: "",
            terms: false
        })
    }

    let handleChange = (e) => {
        let { name, value } = e.target
        name === 'terms' && (value = !!value)
        setFormData({ ...formData, [name]: value })
    }

    return <>
        <section className="w-full h-screen flex justify-center items-center">
            <div className="w-full mt-5">
                <div className="w-1/2 bg-green-500 mx-auto p-5">
                    <h1 className="text-2xl text-white pb-4 font-medium">Registration</h1>
                    <form action="" onSubmit={handleSubmit} className="bg-white rounded-[10px] p-4">
                        <div className="w-full flex flex-col">
                            <label htmlFor="fullname" className="text-[20px] font-medium">Full Name:</label>
                            <input type="text" name="fullname" id="fullname" value={fullname} onChange={handleChange} className="border p-2 rounded-sm" />
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="username" className="text-[20px] font-medium">User Name:</label>
                            <input type="text" name="username" id="username" value={username} onChange={handleChange} className="border p-2 rounded-sm" />
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="email" className="text-[20px] font-medium">Email:</label>
                            <input type="email" name="email" id="email" value={email} onChange={handleChange} className="border p-2 rounded-sm" />
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="contact" className="text-[20px] font-medium">Contact:</label>
                            <input type="tel" name="contact" id="contact" value={contact} onChange={handleChange} className="border p-2 rounded-sm" />
                        </div>
                        <div className="w-full flex flex-col">
                            <label htmlFor="jobtitle" className="text-[20px] font-medium">Current Job Title:</label>
                            <input type="text" name="jobtitle" id="jobtitle" value={jobtitle} onChange={handleChange} className="border p-2 rounded-sm" />
                        </div>
                        <div className="w-full flex flex-col">
                            <label htmlFor="companyname" className="text-[20px] font-medium">Company Name:</label>
                            <input type="text" name="companyname" id="companyname" value={companyname} onChange={handleChange} className="border p-2 rounded-sm" />
                        </div>
                        <div className="flex w-full gap-2">
                            <div className="w-full flex flex-col">
                                <label htmlFor="dob" className="text-[20px] font-medium">Date of Birth:</label>
                                <input type="date" name="dob" id="dob" value={dob} onChange={handleChange} className="border p-2 rounded-sm" />
                            </div>
                            <div className="w-full flex flex-col">
                                <label htmlFor="gender" className="text-[20px] font-medium">Genter:</label>
                                <select name="gender" id="gender" value={gender} onChange={handleChange} className="border p-2 rounded-sm">
                                    <option value="" hidden>Gender</option>
                                    <option value="male">male</option>
                                    <option value="female">female</option>
                                </select>
                            </div>
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="password" className="text-[20px] font-medium">Password:</label>
                            <input type="password" name="password" id="password" value={password} onChange={handleChange} className="border p-2 rounded-sm" />
                        </div>
                        <div className="flex justify-start items-center py-2">
                            <input type="checkbox" name="terms" id="terms" onChange={handleChange} className="outline-0 border rounded p-1 border-gray-300 w-5 h-5 mr-2" />
                            <label htmlFor="terms">I agree to the <span className="text-blue-700">terms and conditions</span></label>
                        </div>
                        <div className="text-center bg-blue-700 rounded-lg mt-3">
                            <button className="w-full text-[20px] text-white p-1 cursor-pointer">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </>
}

export default SSForm4