import React from 'react';
import { Link } from 'react-router-dom';
import useIntersectionObserver from '../hooks/useIntersectionObserver';

const projects = [
  {
    title: 'Personal Portfolio Website',
    description: 'A responsive portfolio website built with React and Tailwind CSS to showcase my projects and skills.',
    link: '/personal-portfolio'
  },
  {
    title: 'Task Management App',
    description: 'A full-stack task management application using React, Node.js, and MongoDB for efficient task tracking.',
    link: '/task-manager'
  },
  {
    title: 'Weather Forecast App',
    description: 'A weather app that fetches real-time weather data from an API and displays it with a clean UI.',
    link: '/weather-app'
  }
];

const Projects = () => {
  const [ref, isVisible] = useIntersectionObserver({
    threshold: 0.1,
    triggerOnce: true,
  });

  return (
    <section
      id="projects"
      ref={ref}
      className={`min-h-screen bg-gray-100 p-8 opacity-0 animate-fadeIn ${
        isVisible ? 'opacity-100' : 'opacity-0'
      }`}
    >
      <h2 className="text-3xl font-bold mb-6 text-center">Projects</h2>
      <div className="max-w-6xl mx-auto grid grid-cols-1 md:grid-cols-3 gap-6">
        {projects.map((project, index) => (
          <div key={index} className="bg-white p-6 rounded-lg shadow-md hover:shadow-lg transition-shadow">
            <h3 className="text-xl font-semibold mb-2">{project.title}</h3>
            <p className="mb-4">{project.description}</p>
            <Link to={project.link} className="text-blue-600 hover:underline">
              View Project
            </Link>
          </div>
        ))}
      </div>
    </section>
  );
};

export default Projects;
