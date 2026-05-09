import { useContext } from "react"
import { myTheme } from "./context/ThemeContext"
import Nav from "./context/Nav"

function App() {

  let { theme, toggleTheme } = useContext(myTheme)

  return <>
    <section className={`container ${theme}`}>
      <Nav />
      <button onClick={toggleTheme}>Change Theme</button>
    </section>
  </>
}

export default App
