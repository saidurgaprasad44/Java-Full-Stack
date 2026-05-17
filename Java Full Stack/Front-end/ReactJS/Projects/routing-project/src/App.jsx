import { Routes, Route } from 'react-router-dom'
import Home from './components/Home'
import ContactUs from './components/Contact'
import AboutUs from './components/AboutUs'
import Navbar from './components/Navbar'

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<h1>This is the base location</h1>} />
        <Route path="/home" element={<Home />} />
        <Route path="/about" element={<AboutUs />} />
        <Route path="/contact" element={<ContactUs />} />
      </Routes>
    </>
  )
}

export default App
