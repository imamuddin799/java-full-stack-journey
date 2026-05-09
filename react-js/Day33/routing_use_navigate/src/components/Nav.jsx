import { Link } from "react-router-dom"

const Nav = () => {
   return <>
       <nav className="w-full bg-black">
           <ul className="flex gap-5 bg-green-500 p-2">
               <li><Link to="/" className="text-white font-medium text-xl">Home</Link></li>
               <li><Link to="/about" className="text-white font-medium text-xl">About</Link></li>
               <li><Link to="/contact" className="text-white font-medium text-xl">Contact</Link></li>
               <li><Link to="/login" className="text-white font-medium text-xl">Login</Link></li>
               <li><Link to="/register" className="text-white font-medium text-xl">Register</Link></li>
           </ul>
       </nav>
   </>
}

export default Nav