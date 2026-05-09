import { useState } from "react"

const ControlledForm = () => {

    let [firstName, setFirstName] = useState("");
    let [lastName, setLastName] = useState("");
    let [email, setEmail] = useState("");
    let [password, setPassword] = useState("");
    let [address, setAddress] = useState("");
    let [course, setCourse] = useState("");

    let handleSubmit = (e) => {
        e.preventDefault();
        console.log(firstName, lastName, email, password, address, course);
        setFirstName("");
        setLastName("");
        setEmail("");
        setPassword("");
        setAddress("");
        setCourse("");
    }

    return <>
        <section className="w-full">
            <h1 className='bg-red-500 text-white text-[34px] text-center'>Form in React</h1>
            <div className="w-full mt-5">
                <div className="w-[40%] bg-[#535974] mx-auto p-5">
                    <form action="" onSubmit={handleSubmit} className="bg-white rounded-[10px] p-4">
                        <div className="flex flex-col">
                            <label htmlFor="firstName" className="text-[20px] font-medium">First Name:</label>
                            <input type="text" name="" id="firstName" value={firstName} onChange={(e) => setFirstName(e.target.value)} className="border p-2 rounded-sm" />
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="lastName" className="text-[20px] font-medium">Last Name:</label>
                            <input type="text" name="" id="lastName" value={lastName} onChange={(e) => setLastName(e.target.value)} className="border p-2 rounded-sm" />
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="email" className="text-[20px] font-medium">Email:</label>
                            <input type="email" name="" id="email" value={email} onChange={(e) => setEmail(e.target.value)} className="border p-2 rounded-sm" />
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="password" className="text-[20px] font-medium">Password:</label>
                            <input type="password" name="" id="password" value={password} onChange={(e) => setPassword(e.target.value)} className="border p-2 rounded-sm" />
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="address" className="text-[20px] font-medium">Address:</label>
                            <textarea name="" id="address" value={address} onChange={(e) => setAddress(e.target.value)} className="border p-2 rounded-sm" ></textarea>
                        </div>
                        <div className="flex flex-col">
                            <label htmlFor="course" className="text-[20px] font-medium">Select Course:</label>
                            <select name="" id="course" value={course} onChange={(e) => {setCourse(e.target.value)}} className="border p-2 rounded-sm">
                                <option value="" hidden>select course</option>
                                <option value="Java Fullstack">Java Fullstack</option>
                                <option value="Python Fullstack">Python Fullstack</option>
                                <option value="MEAN Fullstack">MEAN Fullstack</option>
                                <option value="MERN Fullstack">MERN Fullstack</option>
                            </select>
                        </div>
                        <div className="text-center bg-[#252743] rounded-lg mt-3">
                            <button className="w-full text-[20px] text-white p-1 cursor-pointer">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </>
}

export default ControlledForm