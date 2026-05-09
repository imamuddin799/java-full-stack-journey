import MainContent from "./MainContent"
import SideNavBar from "./SideNavBar"

const Layout = () => {
   return <>
       <div className="w-full flex h-full overflow-hidden">
           <SideNavBar />
           <MainContent />
       </div>
   </>
}

export default Layout