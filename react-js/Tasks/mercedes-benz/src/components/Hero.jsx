import ButtonBlue from "./smallcomponents/ButtonBlue"
import HeroImage from '../assets/images/imageye___-_1746156728632.jpg'
let Hero = () => {
    return <>
        <section className="w-screen z-10 relative h-full bg-cover bg-center bg-no-repeat flex justify-center items-center" style={{ backgroundImage: `url(${HeroImage})` }}>
            <div className="absolute z-0 inset-0 bg-gradient-to-r from-black via-[#00000011] to-[#00000000]"></div>
            <div className="absolute z-0 inset-0 bg-gradient-to-t from-black via-[#00000011] to-[#00000000]"></div>
            <div className="w-[84%] relative z-10 text-white py-55">
                <h1 className="text-6xl font-light">ADVANTAGE YOU.</h1>
                <p className="my-10 text-gray-300">Own your Mercedes-Benz the smart way with STAR Agility+</p>
                <div className="mt-20">
                    <button className="border px-8 py-3 border-gray-500 mr-2">Learn More</button>
                    <ButtonBlue>Find available cars</ButtonBlue>
                </div>
            </div>
        </section>
    </>
}

export default Hero