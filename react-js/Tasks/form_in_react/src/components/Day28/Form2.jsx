import { useState } from "react"

const Form2 = () => {

    let [firstName, setFirstName] = useState("");
    let [lastName, setLastName] = useState("");
    let [streetLine, setStreetLine] = useState("");
    let [streetLine2, setStreetLine2] = useState("");
    let [city, setCity] = useState("");
    let [state, setState] = useState("");

    let handleSubmitForm = (e) => {
        e.preventDefault();
        console.log(firstName);
        console.log(lastName);
        console.log(streetLine);
        console.log(streetLine2);
        console.log(city);
        console.log(state);

        setFirstName("");
        setLastName("");
        setStreetLine("");
        setStreetLine2("");
        setCity("");
        setState("");
    }

    return <>
        <section className="w-screen h-screen flex justify-center items-center ">
            <div className="w-1/3">
                <div className="w-full bg-[#acacac] rotate-[3deg] rounded-xl">
                    <form onSubmit={handleSubmitForm} className="w-full bg-[#dcdcdc] rotate-[-3deg] rounded-xl px-10 py-5">
                        <div>
                            <h1 className="text-2xl font-bold">Name</h1>
                            <div className="flex gap-3 my-3">
                                <div>
                                    <label htmlFor="fname" className="font-medium">First Name</label>
                                    <input type="text" name="" id="fname" value={firstName} onChange={(e) => setFirstName(e.target.value)} className="outline-0 w-full p-1 rounded bg-white mt-1" />
                                </div>
                                <div>
                                    <label htmlFor="lname" className="font-medium">Last Name</label>
                                    <input type="text" name="" id="lname" value={lastName} onChange={(e) => setLastName(e.target.value)} className="outline-0 w-full p-1 rounded bg-white mt-1" />
                                </div>
                            </div>
                        </div>
                        <div>
                            <h1 className="text-2xl font-bold mt-5">Address</h1>
                            <div className="my-3">
                                <label htmlFor="street_line" className="font-medium">Street Line</label>
                                <input type="text" name="" id="street_line" value={streetLine} onChange={(e) => setStreetLine(e.target.value)} className="outline-0 w-full p-1 rounded bg-white mt-1" />
                            </div>
                            <div>
                                <label htmlFor="street_line2" className="font-medium">Street Line 2</label>
                                <input type="text" name="" id="street_line2" value={streetLine2} onChange={(e) => setStreetLine2(e.target.value)} className="outline-0 w-full p-1 rounded bg-white mt-1" />
                            </div>
                            <div className="flex gap-3 my-3">
                                <div>
                                    <label htmlFor="city" className="font-medium">City</label>
                                    <input type="text" name="" id="city" value={city} onChange={(e) => setCity(e.target.value)} className="outline-0 w-full p-1 rounded bg-white mt-1" />
                                </div>
                                <div>
                                    <label htmlFor="state" className="font-medium">State / Province</label>
                                    <input type="text" name="" id="state" value={state} onChange={(e) => setState(e.target.value)} className="outline-0 w-full p-1 rounded bg-white mt-1" />
                                </div>
                            </div>
                        </div>
                        <div className="w-full text-center">
                            <button className="w-fit py-1 px-3 bg-blue-400 rounded text-white">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </>
}

export default Form2