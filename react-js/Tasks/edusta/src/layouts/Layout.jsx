import MainContent from "../components/MainContent"
import SideBar from "../components/SideBar"

const Layout = () => {
    return <>
        <div className="border-4 border-red-700 w-screen h-screen flex justify-start items-start">
            <SideBar />
            <MainContent />
        </div>
    </>
}

export default Layout