import { useContext } from "react"
import { myTheme } from "./ThemeContext"
import { LuSun } from "react-icons/lu";
import { IoMoonOutline } from "react-icons/io5";
let Nav = () => {
    let { theme, toggleTheme } = useContext(myTheme);

    return <>
        <nav>
            <aside className="left-aside">Left aside</aside>
            <aside className="right-aside"> 
                {
                    theme === "light" ? (
                        <IoMoonOutline onClick={toggleTheme} />
                    ) : (
                        <LuSun onClick={toggleTheme} />
                    )
                }
            </aside>
        </nav>
    </>
}
export default Nav;