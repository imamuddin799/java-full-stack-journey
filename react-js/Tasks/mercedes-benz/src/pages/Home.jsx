import Hero from "../components/Hero"
import NavBar from "../components/NavBar"
import Section1 from "../components/Section1"
import Section2 from "../components/Section2"
import Section3 from "../components/Section3"
import Section4 from "../components/Section4"
import Section5 from "../components/Section5"
import StickyDiv from "../components/smallcomponents/StickyDiv"

const Home = () => {
   return <>
       <div className="w-full relative">
           <NavBar />
           <Hero />
       </div>
       <section className="w-full relative">
           <StickyDiv />
           <Section1 />
           <Section2 />
           <Section3 />
           <Section4 />
           <Section5 />
       </section>
   </>
}

export default Home