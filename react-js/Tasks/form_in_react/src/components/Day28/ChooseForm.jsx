import { useEffect, useRef, useState } from "react";
import Form1 from "./Form1";
import Form2 from "./Form2";
import Form3 from "./Form3";
import Form4 from "./Form4";
import FormExample from "../FormExample";
import SSForm1 from "../Day29/SSForm1";
import SSForm2 from "../Day29/SSForm2";
import SSForm3 from "../Day29/SSForm3";
import SSForm4 from "../Day29/SSForm4";

const ChooseForm = () => {

    let [formNo, setFormNo] = useState(1);
    let formref = useRef();

    useEffect(() => {
        if (formref.current) {
            formref.current.scrollIntoView({ behavior: 'smooth' })
        }
    }, [formNo]);

    return <>
        <section className="w-screen h-screen flex flex-col justify-center items-center gap-5">
            <h1 className="w-[70%] text-center bg-blue-200 text-blue-700 font-bold text-4xl p-4">Multi State Forms</h1>
            <div className="w-[70%] flex justify-between gap-5">
                <button className="border-0 px-3 py-1 bg-blue-500 text-white font-bold text-3xl cursor-pointer hover:bg-blue-700" onClick={() => setFormNo(1)}>Form 1</button>
                <button className="border-0 px-3 py-1 bg-blue-500 text-white font-bold text-3xl cursor-pointer hover:bg-blue-700" onClick={() => setFormNo(2)}>Form 2</button>
                <button className="border-0 px-3 py-1 bg-blue-500 text-white font-bold text-3xl cursor-pointer hover:bg-blue-700" onClick={() => setFormNo(3)}>Form 3</button>
                <button className="border-0 px-3 py-1 bg-blue-500 text-white font-bold text-3xl cursor-pointer hover:bg-blue-700" onClick={() => setFormNo(4)}>Form 4</button>
                <button className="border-0 px-3 py-1 bg-blue-500 text-white font-bold text-3xl cursor-pointer hover:bg-blue-700" onClick={() => setFormNo(5)}>Form 5</button>
            </div>
            <h1 className="w-[70%] text-center bg-blue-200 text-blue-700 font-bold text-4xl p-4">Single State Forms</h1>
            <div className="w-[70%] flex justify-between gap-5">
                <button className="border-0 px-3 py-1 bg-blue-500 text-white font-bold text-3xl cursor-pointer hover:bg-blue-700" onClick={() => setFormNo(6)}>Form 6</button>
                <button className="border-0 px-3 py-1 bg-blue-500 text-white font-bold text-3xl cursor-pointer hover:bg-blue-700" onClick={() => setFormNo(7)}>Form 7</button>
                <button className="border-0 px-3 py-1 bg-blue-500 text-white font-bold text-3xl cursor-pointer hover:bg-blue-700" onClick={() => setFormNo(8)}>Form 8</button>
                <button className="border-0 px-3 py-1 bg-blue-500 text-white font-bold text-3xl cursor-pointer hover:bg-blue-700" onClick={() => setFormNo(9)}>Form 9</button>
            </div>
        </section>

        <div ref = {formref}>
            {formNo == 1 && <Form1 />}
            {formNo == 2 && <Form2 />}
            {formNo == 3 && <Form3 />}
            {formNo == 4 && <Form4 />}
            {formNo == 5 && <FormExample />}
            {formNo == 6 && <SSForm1 />}
            {formNo == 7 && <SSForm2 />}
            {formNo == 8 && <SSForm3 />}
            {formNo == 9 && <SSForm4 />}
        </div>
    </>
}

export default ChooseForm;