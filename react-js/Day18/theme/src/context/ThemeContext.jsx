import { useState } from "react";
import { createContext } from "react";

export let myTheme = createContext();

let ThemeContext = (props) => {

    let [theme, setTheme] = useState("light");

    let toggleTheme = () => {
        setTheme(theme === "light" ? "dark" : "light");
    }

    return <myTheme.Provider value={{ theme, toggleTheme }}>
        {props.children}
    </myTheme.Provider>
}
export default ThemeContext;


// let ThemeContext = ({children}) => {

//     let [theme, setTheme] = useState("light");

//     let toggleTheme = () => {
//         setTheme(theme === "light" ? "dark" : "light");
//     }

//     return <myTheme.Provider value={{ theme, toggleTheme }}>
//         {children}
//     </myTheme.Provider>
// }
// export default ThemeContext;
