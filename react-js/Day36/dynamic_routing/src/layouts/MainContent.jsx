import { Outlet } from "react-router-dom"

const MainContent = () => {
   return <>
       <div className="p-3 bg-cyan-300 w-full overflow-y-hidden">
           <Outlet />
       </div>
   </>
}

export default MainContent