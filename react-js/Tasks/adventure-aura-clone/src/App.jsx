import { Outlet } from "react-router-dom"
import NavBar from "./components/NavBar"

const App = () => {
    return <>
        <section className="w-screen">
            <NavBar />
            <Outlet />
       </section>
   </>
}

export default App