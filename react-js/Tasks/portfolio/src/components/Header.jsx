import React from 'react';
import { NavLink } from 'react-router-dom';

const Header = () => {
  const activeClass = "bg-gray-700 scale-105";

  return (
    <aside className="bg-gray-900 text-white fixed top-0 left-0 h-full w-64 flex flex-col shadow-lg z-50">
      <div className="p-6 text-3xl font-bold border-b border-gray-700">
        Imamuddin Ansari
      </div>
      <nav className="flex-grow mt-6">
        <ul className="flex flex-col space-y-4 px-6">
          <li>
            <NavLink
              to="/"
              className={({ isActive }) =>
                "block py-2 px-4 rounded transition-colors duration-300 ease-in-out transform focus:scale-105 " +
                (isActive ? activeClass : "hover:bg-gray-700 hover:scale-105")
              }
            >
              Home
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/about"
              className={({ isActive }) =>
                "block py-2 px-4 rounded transition-colors duration-300 ease-in-out transform focus:scale-105 " +
                (isActive ? activeClass : "hover:bg-gray-700 hover:scale-105")
              }
            >
              About
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/personal-portfolio"
              className={({ isActive }) =>
                "block py-2 px-4 rounded transition-colors duration-300 ease-in-out transform focus:scale-105 " +
                (isActive ? activeClass : "hover:bg-gray-700 hover:scale-105")
              }
            >
              Personal Portfolio
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/task-manager"
              className={({ isActive }) =>
                "block py-2 px-4 rounded transition-colors duration-300 ease-in-out transform focus:scale-105 " +
                (isActive ? activeClass : "hover:bg-gray-700 hover:scale-105")
              }
            >
              Task Manager
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/weather-app"
              className={({ isActive }) =>
                "block py-2 px-4 rounded transition-colors duration-300 ease-in-out transform focus:scale-105 " +
                (isActive ? activeClass : "hover:bg-gray-700 hover:scale-105")
              }
            >
              Weather App
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/skills"
              className={({ isActive }) =>
                "block py-2 px-4 rounded transition-colors duration-300 ease-in-out transform focus:scale-105 " +
                (isActive ? activeClass : "hover:bg-gray-700 hover:scale-105")
              }
            >
              Skills
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/contact"
              className={({ isActive }) =>
                "block py-2 px-4 rounded transition-colors duration-300 ease-in-out transform focus:scale-105 " +
                (isActive ? activeClass : "hover:bg-gray-700 hover:scale-105")
              }
            >
              Contact
            </NavLink>
          </li>
        </ul>
      </nav>
    </aside>
  );
};

export default Header;
