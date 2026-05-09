import FirstSect from "../components/landingpage/FirstSect";
import TransformBrand from "../components/landingpage/TransformBrand";
import StandOut from "../components/landingpage/StandOut";
import Photography from "../components/landingpage/Photography";
import Testimonials from "../components/landingpage/Testimonials";
import Footer from "../components/landingpage/Footer";
import HeaderImage from '../assets/landingpage/images/desktop/image-header.jpg'

const SunnySide = () => {
    return <>
        <main className="w-screen h-screen" style={{ backgroundImage: `url(${HeaderImage})` }} >
            <FirstSect />
        </main>
        <TransformBrand />
        <StandOut />
        <Photography />
        <Testimonials />
        <Footer />
    </>
}

export default SunnySide;