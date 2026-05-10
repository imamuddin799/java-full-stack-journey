import Fifth from "../components/Home/Fifth"
import Fourth from "../components/Home/Fourth"
import Secondpart from "../components/Home/Secondpart"
import Sixth from "../components/Home/Sixth"
import Thirdpart from "../components/Home/Thirdpart"
import { CgPlayButtonO } from "react-icons/cg";
import { FaArrowAltCircleRight } from "react-icons/fa";
import Footer from '../components/Footer'
import HomeHero from '/src/assets/images/home/home-hero.jpg'

const Home = () => {
    return <>
        <section className="relative z-10 w-screen h-full">
            <div className="absolute  z-20 inset-0 bg-cover" style={{ backgroundImage: `url(${HomeHero})` }}></div>
            <div className="py-55 relative z-30 flex justify-start items-center bg-[#00000099]">
                <div className="w-[600px] flex flex-col justify-start ml-40  ">
                    <p className="text-white text-lg w-fit bg-[#88888888] py-1 px-9 rounded-3xl">{'Experience Luxury Travel'.toUpperCase()}</p>
                    <h1 className="text-white w-fit text-7xl font-Playfair Display py-5">Explore the World Like Never Before</h1>
                    <h6 className="text-white">Curated journeys to the world's most extraordinary destinations. Let us transform your travel dreams into unforgettable memories.</h6>
                    <div className="flex mt-15 gap-8">
                        <button className="text-white p-3 flex items-center justify-center gap-2 w-[200px] rounded-[10px] bg-[#FF6E0E]">Start Planing  <FaArrowAltCircleRight /> </button>
                        <button className=" p-4 flex items-center justify-center gap-2 w-[200px] rounded-[10px] bg-[#e0d5d588]  text-[#f5f6f7e9] "><CgPlayButtonO />    Watch Video</button>
                    </div>
                </div>
            </div>
        </section>
        <Secondpart />
        <Thirdpart />
        <Fourth />
        <Fifth />
        <Sixth />
        <Footer />
    </>
}

export default Home