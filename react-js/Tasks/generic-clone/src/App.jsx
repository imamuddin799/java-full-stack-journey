
import About from './pages/About'
import Home from './pages/Home'
import Offerings from './pages/Offerings'
import Contact from './pages/Contact'
import Nav from './components/Nav'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

const App = () => {
  return <>
    <BrowserRouter>
      <div className='w-screen bg-[#dcdcdc]'>
        <Nav />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/about' element={<About />} />
          <Route path='/offerings' element={<Offerings />} />
          <Route path='/contact' element={<Contact />} />
          <Route path='*' element={<Home />} />
        </Routes>
      </div>
    </BrowserRouter>
  </>
}

export default App