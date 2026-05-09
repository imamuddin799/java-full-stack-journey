import React from 'react';
import useIntersectionObserver from '../hooks/useIntersectionObserver';

const TaskManager = () => {
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
      <h2 className="text-3xl font-bold mb-6">Task Management App</h2>
      <p className="mb-4">
        A full-stack task management application using React, Node.js, and MongoDB for efficient task tracking. Features include task creation, editing, deletion, and status updates.
      </p>
      <p>
        Technologies used: React, Node.js, Express, MongoDB, Tailwind CSS.
      </p>
    </section>
  );
};

export default TaskManager;
