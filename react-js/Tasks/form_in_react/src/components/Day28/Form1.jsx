import { Fragment, useState } from "react"
import success from '../../assets/images/right.svg'
const Form1 = () => {

    let [fullname, setFullName] = useState("");
    let [role, setRole] = useState("");
    let [email, setEmail] = useState("");
    let [password, setPassword] = useState("");
    let [json, setJson] = useState([]);

    let [signup1, setSignup1] = useState();
    let [signup2, setSignup2] = useState();

    let [formStage, setFormStage] = useState(1);

    let handleSubmitForm1 = (e) => {
        e.preventDefault();
        console.log(fullname);
        console.log(role);
        console.log(email);
        console.log(password);
        setFormStage(2);
    }

    let handleSubmitForm2 = (e) => {
        e.preventDefault();

        let str = 'JSON Data From-Completed: {'
        let str2 = '    "FormStage": 3,'
        let str3 = '    "FormUserSignup": {'
        let str4 = `        "name": "${fullname}",`
        let str5 = `        "role": "${role}",`
        let str6 = `        "email": "${email}",`
        let str7 = `        "password": "${password}"`
        let str8 = `    }`
        let str9 = `    "FormUserPrivacy": {`
        let str10 = `        "signup1": ${signup1 ? true : false},`
        let str11 = `       "signup2": ${signup2 ? true : false}`
        let str12 = '   }'
        let str13 = '}'
        // let json = str + "\n" + str2 + "\n" + str3 + "\n" + str4 + "\n" + str5 + "\n" + str6 + "\n" + str7 + '\n' + str8 + '\n' + str9 + '\n' + str10 + '\n' + str11 + '\n' + str12 + '\n' + str13;
        let json = [str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13]
        console.log(json);
        setJson(json)
        setFormStage(3);
    }

    return <>
        {formStage === 1 && (<section className="w-screen min-h-screen flex justify-center items-center bg-linear-to-b from-[#CE3988] to-[#2549AC]">
            <form onSubmit={handleSubmitForm1} className="w-[40%] m-5 drop-shadow-2xl bg-white rounded-2xl px-10">
                <div className="text-center py-5">
                    <h1 className="font-bold text-4xl">Signup Form</h1>
                </div>
                <div>
                    <div className="flex justify-between">
                        <h1 className="font-bold">User</h1>
                        <h1 className="font-bold">Privacy</h1>
                        <h1 className="font-bold">Done</h1>
                    </div>
                    <div className="flex flex-col justify-between my-2 w-full relative">
                        <div className="border-2 absolute w-full top-[50%] z-10"></div>
                        <div className="w-full flex justify-between">
                            <div className="w-10 h-10 flex justify-center items-center rounded-[50%] z-20 bg-[#D03987] text-white font-medium">1</div>
                            <div className="border-3 w-10 h-10 flex justify-center items-center rounded-[50%] z-20 bg-white font-medium">2</div>
                            <div className="border-3 w-10 h-10 flex justify-center items-center rounded-[50%] z-20 bg-white font-medium">3</div>
                        </div>
                    </div>
                </div>
                <div>
                    <h1 className="font-bold text-2xl py-3 mb-3">User Form:</h1>
                </div>
                <div>
                    <div className="w-full flex flex-col">
                        <label htmlFor="name" className="font-bold my-1">Name *</label>
                        <input type="text" name="" id="name" value={fullname} onChange={(e) => setFullName(e.target.value)} placeholder="name" className="border-3 border-black p-2 font-bold text-black hover:bg-[#FFFF00]" />
                    </div>
                    <div className="w-full flex flex-col">
                        <label htmlFor="role" className="font-bold my-1">Role</label>
                        <input type="text" name="" id="role" value={role} onChange={(e) => setRole(e.target.value)} placeholder="eg. software developer" className="border-3 border-black p-2 font-bold text-black hover:bg-[#FFFF00]" />
                    </div>
                    <div className="w-full flex flex-col">
                        <label htmlFor="email" className="font-bold my-1">Email *</label>
                        <input type="email" name="" id="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder="email@example.com" className="border-3 border-black p-2 font-bold text-black hover:bg-[#FFFF00]" />
                    </div>
                    <div className="w-full flex flex-col">
                        <label htmlFor="password" className="font-bold my-1">Password *</label>
                        <input type="password" name="" id="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Password" className="border-3 border-black p-2 font-bold text-black hover:bg-[#FFFF00]" />
                    </div>
                </div>
                <p className="font-medium pt-4">* Required Fields</p>
                <div className="text-center">
                    <button className="w-fit py-1 px-8 my-4 rounded-sm bg-[#D03987] font-medium text-white text-xl hover:bg-[#FFFF00] hover:text-black">Next</button>
                </div>
            </form>
        </section>
        )}
        {formStage === 2 && (<section className="w-screen min-h-screen flex justify-center items-center bg-linear-to-b from-[#CE3988] to-[#2549AC]">
            <form onSubmit={handleSubmitForm2} className="w-[43%] m-5 drop-shadow-2xl bg-white rounded-2xl px-10">
                <div className="text-center py-5">
                    <h1 className="font-bold text-4xl">Signup Form</h1>
                </div>
                <div>
                    <div className="flex justify-between">
                        <h1 className="font-bold">User</h1>
                        <h1 className="font-bold">Privacy</h1>
                        <h1 className="font-bold">Done</h1>
                    </div>
                    <div className="flex flex-col justify-between my-2 w-full relative">
                        <div className="border-2 absolute w-full top-[50%] z-10"></div>
                        <div className="w-full flex justify-between">
                            <div className="border-3 w-10 h-10 flex justify-center items-center rounded-[50%] z-20 bg-white font-medium">1</div>
                            <div className="w-10 h-10 flex justify-center items-center rounded-[50%] z-20 bg-[#D03987] text-white font-medium">2</div>
                            <div className="border-3 w-10 h-10 flex justify-center items-center rounded-[50%] z-20 bg-white font-medium">3</div>
                        </div>
                    </div>
                </div>
                <div>
                    <h1 className="font-bold text-2xl py-3 mb-3">Privacy Form:</h1>
                </div>
                <div>
                    <div className="w-full my-4">
                        <input type="checkbox" name="" id="signup1" value={signup1} onChange={(e) => setSignup1(e.target.value)} placeholder="name" className="w-6 h-6 mr-3 mb-3" />
                        <label htmlFor="signup1" className="font-bold text-[17px] relative top-[-8px] ">Recieve updates about Tray.io products by email</label>
                    </div>
                    <div className="w-full my-4">
                        <input type="checkbox" name="" id="signup2" value={signup2} onChange={(e) => setSignup2(e.target.value)} placeholder="name" className="w-6 h-6 mr-3 mb-3" />
                        <label htmlFor="signup2" className="font-bold text-[17px] relative top-[-8px] ">Recieve communication by email for other products created by the Tray.io team</label>
                    </div>
                </div>
                <div className="flex justify-evenly">
                    <button onClick={() => setFormStage(1)} className="w-fit py-1 px-8 my-4 rounded-sm bg-[#D03987] font-medium text-white text-xl hover:bg-[#FFFF00] hover:text-black">Back</button>
                    <button className="w-fit py-1 px-8 my-4 rounded-sm bg-[#D03987] font-medium text-white text-xl hover:bg-[#FFFF00] hover:text-black">Next</button>
                </div>
            </form>
        </section>
        )}
        {formStage === 3 && (<section className="w-screen min-h-screen flex justify-center items-center bg-linear-to-b from-[#CE3988] to-[#2549AC]">
            <div className="w-[43%] m-5 drop-shadow-2xl bg-white rounded-2xl px-10">
                <div className="text-center py-5">
                    <h1 className="font-bold text-4xl">Signup Form</h1>
                </div>
                <div>
                    <div className="flex justify-between">
                        <h1 className="font-bold">User</h1>
                        <h1 className="font-bold">Privacy</h1>
                        <h1 className="font-bold">Done</h1>
                    </div>
                    <div className="flex flex-col justify-between my-2 w-full relative">
                        <div className="border-2 absolute w-full top-[50%] z-10"></div>
                        <div className="w-full flex justify-between">
                            <div className="border-3 w-10 h-10 flex justify-center items-center rounded-[50%] z-20 bg-white font-medium">1</div>
                            <div className="border-3 w-10 h-10 flex justify-center items-center rounded-[50%] z-20 bg-white font-medium">2</div>
                            <div className="w-10 h-10 flex justify-center items-center rounded-[50%] z-20 bg-[#D03987] text-white font-medium">3</div>
                        </div>
                    </div>
                </div>
                <div className="flex flex-col justify-center items-center">
                    <h1 className="font-bold text-2xl text-green-700 text-center py-3 mb-3">Success!</h1>
                    <img src={success} alt="" className="w-[100px]" />
                    <h1 className="text-center text-green-700 font-medium text-[17px] mt-7">Please verify your email adddress, you should have recieved an email from us already!</h1>
                </div>
                <div className="bg-[#cdcdcd] w-full rounded-xl my-4 py-3 px-2">
                    {
                        json.map((ele, index) => {
                            return <Fragment key={index}>
                                <pre className="text-[#D03987]">{ele}</pre>
                            </Fragment>
                        })
                    }
                </div>
            </div>
        </section>
        )}
    </>
}

export default Form1