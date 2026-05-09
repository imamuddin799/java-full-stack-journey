import { IoCallSharp } from "react-icons/io5";
import { IoSearch } from "react-icons/io5";

let Discount = () => {
    return <>
        <section className="w-full flex justify-center items-start">
            <div className="w-[75%] flex my-10">
                <div className="w-[45%]">
                    <h1 className="text-3xl font-medium">Summer Discounts Active!</h1>
                    <p className="text-lg">Flat discount across categories!</p>
                    <p className="flex justify-start items-center gap-1 text-lg"><IoCallSharp /><span>Call us at 08069289001</span></p>
                </div>
                <div className="w-[55%] flex justify-center items-center">
                    <div className="w-full flex">
                        <input type="text" name="" id="" placeholder="what do you want to learn today?" className="w-full p-2 bg-white rounded-l-sm outline-0" />
                        <div className="w-fit px-5 py-2 rounded-r-sm bg-[#046435] cursor-pointer"><IoSearch className="text-xl text-white" /></div>
                    </div>
                </div>
            </div>
        </section>
    </>
}

export default Discount