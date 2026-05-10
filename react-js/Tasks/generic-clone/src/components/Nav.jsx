import { Fragment } from "react"
import { Link } from "react-router-dom"

const Nav = () => {
  const links = [
    { to: '/', label: 'HOME'},
    { to: 'about', label: 'ABOUT'},
    { to: 'offerings', label: 'OFFERINGS'},
    { to: 'contact', label: 'CONTACT'},
  ]
  return <>
    <nav className="w-full absolute z-110 top-0 bg-transparent flex justify-around items-center mt-6">
      <aside className="w-full flex justify-center items-center">
        <h1 className="text-2xl font-medium text-white">Generic</h1>
      </aside>
      <aside className="w-full flex justify-center items-center">
        <ul className="w-full flex justify-evenly items-center">
          {
            links.map((link, index) => {
              return <Fragment key={index}>
                <li className="text-sm font-medium text-white hover:text-teal-500"><Link to={link.to}>{link.label}</Link></li>
              </Fragment>
            })
          }
        </ul>
      </aside>
      <aside className="w-full flex justify-center items-center">
        <button className="bg-[#2a9d8f] text-white py-3 px-7 font-medium cursor-pointer">CALL TO ACTION</button>
      </aside>
    </nav>
  </>
}

export default Nav