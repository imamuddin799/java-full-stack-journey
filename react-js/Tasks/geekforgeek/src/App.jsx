import { useContext } from 'react'
import { myTheme } from './context/Theme'
import Home from './pages/Home';

function App() {

  return <>
    <main className="w-screen ">
      <Home />
    </main>
  </>
}

export default App
