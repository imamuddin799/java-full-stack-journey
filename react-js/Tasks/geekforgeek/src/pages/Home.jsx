
import Courses from "../components/Courses";
import Discount from "../components/Discount";
import Footer from "../components/Footer";
import GeekNav from "../components/GeekNav"
import WebPageBody from "../components/WebPageBody";
const Home = () => {
    return <>
        <section className="w-full">
            <GeekNav />
            <Courses />
            <section className="w-full bg-gradient-to-b from-[#3E63AD] to-white">
                <Discount />
                <WebPageBody />
            </section>
            <Footer />
            <div className="w-full flex justify-center items-center border-t border-gray-300">
                <p className="w-[95%] pb-4 text-gray-600">@GeeksforGeeks, Sanchhaya Education Private Limited, All rights reserved</p>
            </div>
        </section>
    </>
}
export default Home;