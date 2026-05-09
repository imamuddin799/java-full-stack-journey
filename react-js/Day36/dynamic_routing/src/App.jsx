import NavBar from "./components/NavBar"
import Layout from "./layouts/Layout"

const App = () => {
   return <>
       <div className="flex flex-col w-screen h-screen justify-start items-center ">
           <NavBar />
           <Layout />
       </div>
   </>
}

export default App