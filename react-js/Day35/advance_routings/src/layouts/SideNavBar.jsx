import { Link } from "react-router-dom"

const SideNavBar = () => {
   return <>
       <div className="w-1/7 border-amber-700 border-r flex flex-col justify-between items-start p-3">
           <div className="flex flex-col gap-3 w-full">
                <Link to='/' className="w-full bg-teal-500 text-white py-2 pl-1">Products</Link>
                <Link to='/users' className="w-full bg-teal-500 text-white py-2 pl-1">Users</Link>
                <Link to='/carts' className="w-full bg-teal-500 text-white py-2 pl-1">Carts</Link>
           </div>
           <div className="hidden">
               link group 2
           </div>
       </div>
   </>
}

export default SideNavBar