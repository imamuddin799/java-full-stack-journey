import Footer from "./components/Footer";
import MainContent from "./components/MainContent";
import Navbar from "./components/Navbar";

// ! Create different components for each part of page.
let App = () => {
    return <>
        <Navbar></Navbar>
        <MainContent></MainContent>
        <h1>Hello from Functional Based Component</h1>
        <Footer></Footer>
    </>
}
export default App;