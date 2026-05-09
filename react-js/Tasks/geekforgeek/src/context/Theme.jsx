import React from 'react'
import { useState } from 'react';
import { createContext } from 'react';

export let myTheme = createContext();
const Theme = (props) => {

    let [theme, setTheme] = useState("light");

    let toggleTheme = () => {
        setTheme(theme === "light" ? "dark" : "light");
    }
    return <>
        <myTheme.Provider value={{ theme, toggleTheme }}>
            {props.children}
        </myTheme.Provider>
    </>
}

export default Theme;