
import useIntersectionObserver from '../hooks/useIntersectionObserver';
import profile from '../assets/images/profile.webp'
const About = () => {
  const [ref, isVisible] = useIntersectionObserver({
    threshold: 0.1,
    triggerOnce: true,
  });

  return (
    <section
      id="about"
      ref={ref}
      className={`min-h-screen bg-white flex flex-col items-center justify-center p-8 opacity-0 animate-fadeIn ${
        isVisible ? 'opacity-100' : 'opacity-0'
      }`}
    >
      <h2 className="text-3xl font-bold mb-6">About Me</h2>
      <div className="max-w-4xl flex flex-col md:flex-row items-center md:items-start">
        <img
          src={profile}
          alt="Profile"
          className="rounded-full w-40 h-40 mb-6 md:mb-0 md:mr-8 object-cover"
        />
        <p className="text-lg max-w-xl">
          Hello! I am Imamuddin, a passionate software engineer with expertise in building scalable web applications using React, Node.js, and modern JavaScript frameworks. I enjoy solving complex problems and continuously learning new technologies to deliver high-quality software solutions.
        </p>
      </div>
    </section>
  );
};

export default About;
