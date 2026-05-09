import React from 'react';
import useIntersectionObserver from '../hooks/useIntersectionObserver';

const skills = [
  'JavaScript (ES6+)',
  'React.js & Redux',
  'Tailwind CSS & CSS3',
  'HTML5 & Semantic Markup',
  'Node.js & Express',
  'MongoDB & Mongoose',
  'Git & GitHub',
  'RESTful API Development'
];

const Skills = () => {
  const [ref, isVisible] = useIntersectionObserver({
    threshold: 0.1,
    triggerOnce: true,
  });

  return (
    <section
      id="skills"
      ref={ref}
      className={`min-h-screen bg-white p-8 opacity-0 animate-fadeIn ${
        isVisible ? 'opacity-100' : 'opacity-0'
      }`}
    >
      <h2 className="text-3xl font-bold mb-6 text-center">Skills</h2>
      <div className="max-w-4xl mx-auto flex flex-wrap justify-center gap-4">
        {skills.map((skill, index) => (
          <span
            key={index}
            className="bg-gray-200 text-gray-800 px-4 py-2 rounded-full text-lg font-medium"
          >
            {skill}
          </span>
        ))}
      </div>
    </section>
  );
};

export default Skills;
