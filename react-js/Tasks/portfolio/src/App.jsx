
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import About from './components/About';
import Projects from './components/Projects';
import Skills from './components/Skills';
import Contact from './components/Contact';
import PersonalPortfolio from './components/PersonalPortfolio';
import TaskManager from './components/TaskManager';
import WeatherApp from './components/WeatherApp';
const App = () => {
  return (
    <Router>
      <div className="flex">
        <Header />
        <main className="flex-grow ml-64 p-8">
          <Routes>
            <Route path="/" element={
              <>
                <section id="home" className="min-h-screen flex flex-col items-center justify-center bg-gray-100 rounded-lg shadow-md p-8 mb-8 space-y-6 opacity-0 animate-fadeIn">
                  <h1 className="text-5xl font-extrabold">Welcome to My Portfolio</h1>
                  <p className="text-lg max-w-3xl text-center">
                    I am Imamuddin, a passionate software engineer specializing in building scalable web applications using React, Node.js, and modern JavaScript frameworks. Explore my projects, skills, and get in touch!
                  </p>
                  <div className="w-full max-w-4xl grid grid-cols-1 md:grid-cols-3 gap-6">
                    <div className="bg-white p-6 rounded-lg shadow-md animate-fadeIn">
                      <h2 className="text-xl font-semibold mb-2">Skills Highlight</h2>
                      <ul className="list-disc list-inside">
                        <li>React & Redux</li>
                        <li>Node.js & Express</li>
                        <li>Core Java</li>
                        <li>Advance Java</li>
                        <li>Oracle SQL</li>
                        <li>JavaScript & TypeScript</li>
                        <li>Tailwind CSS & Responsive Design</li>
                      </ul>
                    </div>
                    <div className="bg-white p-6 rounded-lg shadow-md animate-fadeIn">
                      <h2 className="text-xl font-semibold mb-2">Featured Project</h2>
                      <p>
                        Personal Portfolio Website showcasing my skills and projects with React and Tailwind CSS.
                      </p>
                    </div>
                    <div className="bg-white p-6 rounded-lg shadow-md animate-fadeIn">
                      <h2 className="text-xl font-semibold mb-2">Get in Touch</h2>
                      <p>
                        Feel free to explore the contact section to reach out for collaborations or inquiries.
                      </p>
                    </div>
                  </div>
                </section>
                <About />
                <Projects />
                <Skills />
                <Contact />
              </>
            } />
            <Route path="/about" element={<About />} />
            <Route path="/skills" element={<Skills />} />
            <Route path="/contact" element={<Contact />} />
            <Route path="/personal-portfolio" element={<PersonalPortfolio />} />
            <Route path="/task-manager" element={<TaskManager />} />
            <Route path="/weather-app" element={<WeatherApp />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
};

export default App;
