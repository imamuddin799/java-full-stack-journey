import Section2 from "../components/About/Section2"
import Section3 from "../components/About/Section3"
import Section4 from "../components/About/Section4"
import Section5 from "../components/About/Section5"
import Section6 from "../components/About/Section6"
import Footer from "../components/Footer"
import AboutHero from '/src/assets/images/About/about-hero.jpg'

const About = () => {
    return <>
        <section className="relative  z-10 w-screen h-full">
            <div className="absolute  z-20 inset-0 bg-cover" style={{ backgroundImage: `url(${AboutHero})` }}></div>
            <div className="py-55 relative z-30 flex justify-center items-center bg-[#00000099]">
                <div className="w-1/2 flex flex-col justify-start items-center">
                    <p className="text-white text-lg w-fit bg-[#88888888] py-1 px-9 rounded-3xl">{'About us'.toUpperCase()}</p>
                    <h1 className="text-white w-[900px] text-7xl font-Playfair Display py-5 text-center">Established with a passion for exploration</h1>
                    <h6 className="text-white"></h6>
                    <div className="flex mt-15 gap-8">
                    </div>
                </div>
            </div>
        </section>
        <Section2 />
        <Section3 />
        <Section4 />
        <Section5 />
        <Section6 />
        <Footer />
    </>
}

export default About