import React from 'react';
import useIntersectionObserver from '../hooks/useIntersectionObserver';

const PersonalPortfolio = () => {
  const [ref, isVisible] = useIntersectionObserver({
    threshold: 0.1,
    triggerOnce: true,
  });

  return (
    <section
      ref={ref}
      className={`min-h-screen p-8 bg-white transition-opacity duration-1000 ease-in-out ${
        isVisible ? 'opacity-100' : 'opacity-0'
      }`}
    >
      <h2 className="text-3xl font-bold mb-6">Personal Portfolio Website</h2>
      <p className="mb-4">
        This is a responsive portfolio website built with React and Tailwind CSS to showcase my projects and skills. It features a clean design, smooth navigation, and responsive layout.
      </p>
      <p>
        Technologies used: React, Tailwind CSS, React Router, JavaScript.
      </p>
    </section>
  );
};

export default PersonalPortfolio;
