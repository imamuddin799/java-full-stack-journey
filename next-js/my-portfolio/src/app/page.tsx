// "use client";

// import { useEffect, useRef, useState } from "react";

// export default function Portfolio() {
//   const [activeSection, setActiveSection] = useState("home");
//   const [menuOpen, setMenuOpen] = useState(false);
//   const [typed, setTyped] = useState("");
//   const fullText = "Full Stack Developer";

//   useEffect(() => {
//     let i = 0;
//     const interval = setInterval(() => {
//       setTyped(fullText.slice(0, i + 1));
//       i++;
//       if (i === fullText.length) clearInterval(interval);
//     }, 80);
//     return () => clearInterval(interval);
//   }, []);

//   useEffect(() => {
//     const sections = document.querySelectorAll("section[id]");
//     const observer = new IntersectionObserver(
//       (entries) => {
//         entries.forEach((entry) => {
//           if (entry.isIntersecting) setActiveSection(entry.target.id);
//         });
//       },
//       { threshold: 0.4 }
//     );
//     sections.forEach((s) => observer.observe(s));
//     return () => observer.disconnect();
//   }, []);

//   const navLinks = ["about", "skills", "projects", "education", "contact"];

//   const skills = [
//     { name: "Next.js", category: "Frontend" },
//     { name: "React.js", category: "Frontend" },
//     { name: "TypeScript", category: "Frontend" },
//     { name: "JavaScript", category: "Frontend" },
//     { name: "HTML", category: "Frontend" },
//     { name: "CSS", category: "Frontend" },
//     { name: "Tailwind CSS", category: "Frontend" },
//     { name: "Bootstrap", category: "Frontend" },
//     { name: "Java", category: "Backend" },
//     { name: "SQL", category: "Backend" },
//     { name: "Spring Tool Suite", category: "Backend" },
//     { name: "Git & GitHub", category: "Tools" },
//     { name: "VS Code", category: "Tools" },
//     { name: "Cursor IDE", category: "Tools" },
//     { name: "Eclipse", category: "Tools" },
//     { name: "Postman", category: "Tools" },
//   ];

//   const categories = ["All", "Frontend", "Backend", "Tools"];
//   const [activeCategory, setActiveCategory] = useState("All");
//   const filteredSkills =
//     activeCategory === "All"
//       ? skills
//       : skills.filter((s) => s.category === activeCategory);

//   return (
//     <>
//       <style>{`
//         @import url('https://fonts.googleapis.com/css2?family=Syne:wght@400;600;700;800&family=DM+Sans:ital,opsz,wght@0,9..40,300;0,9..40,400;0,9..40,500;1,9..40,300&display=swap');

//         *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

//         :root {
//           --bg: #0a0a0f;
//           --surface: #12121a;
//           --border: #1e1e2e;
//           --accent: #6ee7b7;
//           --accent2: #818cf8;
//           --text: #e2e8f0;
//           --muted: #64748b;
//           --heading: 'Syne', sans-serif;
//           --body: 'DM Sans', sans-serif;
//         }

//         html { scroll-behavior: smooth; }

//         body {
//           background: var(--bg);
//           color: var(--text);
//           font-family: var(--body);
//           line-height: 1.7;
//           overflow-x: hidden;
//         }

//         /* NAV */
//         nav {
//           position: fixed;
//           top: 0; left: 0; right: 0;
//           z-index: 100;
//           display: flex;
//           align-items: center;
//           justify-content: space-between;
//           padding: 1.25rem 2.5rem;
//           background: rgba(10,10,15,0.85);
//           backdrop-filter: blur(16px);
//           border-bottom: 1px solid var(--border);
//         }

//         .nav-logo {
//           font-family: var(--heading);
//           font-weight: 800;
//           font-size: 1.3rem;
//           letter-spacing: -0.02em;
//           color: var(--accent);
//           text-decoration: none;
//         }

//         .nav-links {
//           display: flex;
//           gap: 2rem;
//           list-style: none;
//         }

//         .nav-links a {
//           font-family: var(--heading);
//           font-size: 0.85rem;
//           font-weight: 600;
//           letter-spacing: 0.08em;
//           text-transform: uppercase;
//           color: var(--muted);
//           text-decoration: none;
//           position: relative;
//           transition: color 0.2s;
//         }

//         .nav-links a::after {
//           content: '';
//           position: absolute;
//           bottom: -4px; left: 0; right: 0;
//           height: 2px;
//           background: var(--accent);
//           transform: scaleX(0);
//           transition: transform 0.2s;
//         }

//         .nav-links a.active, .nav-links a:hover { color: var(--text); }
//         .nav-links a.active::after, .nav-links a:hover::after { transform: scaleX(1); }

//         .hamburger {
//           display: none;
//           flex-direction: column;
//           gap: 5px;
//           cursor: pointer;
//           background: none;
//           border: none;
//           padding: 4px;
//         }

//         .hamburger span {
//           display: block;
//           width: 22px;
//           height: 2px;
//           background: var(--text);
//           border-radius: 2px;
//           transition: all 0.3s;
//         }

//         /* HERO */
//         #home {
//           min-height: 100vh;
//           display: flex;
//           align-items: center;
//           padding: 0 2.5rem;
//           position: relative;
//           overflow: hidden;
//         }

//         .hero-bg {
//           position: absolute;
//           inset: 0;
//           background:
//             radial-gradient(ellipse 60% 50% at 70% 50%, rgba(110,231,183,0.07) 0%, transparent 70%),
//             radial-gradient(ellipse 40% 60% at 20% 80%, rgba(129,140,248,0.07) 0%, transparent 60%);
//           pointer-events: none;
//         }

//         .hero-grid {
//           position: absolute;
//           inset: 0;
//           background-image:
//             linear-gradient(rgba(255,255,255,0.02) 1px, transparent 1px),
//             linear-gradient(90deg, rgba(255,255,255,0.02) 1px, transparent 1px);
//           background-size: 60px 60px;
//           pointer-events: none;
//         }

//         .hero-content {
//           position: relative;
//           max-width: 900px;
//           margin: 0 auto;
//           padding-top: 6rem;
//         }

//         .hero-badge {
//           display: inline-flex;
//           align-items: center;
//           gap: 0.5rem;
//           font-size: 0.8rem;
//           font-weight: 500;
//           color: var(--accent);
//           border: 1px solid rgba(110,231,183,0.3);
//           border-radius: 100px;
//           padding: 0.3rem 1rem;
//           margin-bottom: 1.5rem;
//           letter-spacing: 0.05em;
//         }

//         .hero-badge::before {
//           content: '';
//           width: 6px; height: 6px;
//           border-radius: 50%;
//           background: var(--accent);
//           animation: pulse 2s infinite;
//         }

//         @keyframes pulse {
//           0%, 100% { opacity: 1; transform: scale(1); }
//           50% { opacity: 0.4; transform: scale(0.8); }
//         }

//         .hero-name {
//           font-family: var(--heading);
//           font-size: clamp(3rem, 8vw, 6rem);
//           font-weight: 800;
//           line-height: 1.0;
//           letter-spacing: -0.03em;
//           color: #fff;
//           margin-bottom: 0.5rem;
//         }

//         .hero-name span { color: var(--accent); }

//         .hero-role {
//           font-family: var(--heading);
//           font-size: clamp(1.2rem, 3vw, 2rem);
//           font-weight: 600;
//           color: var(--muted);
//           margin-bottom: 1.5rem;
//           min-height: 2.5rem;
//         }

//         .hero-role .cursor {
//           display: inline-block;
//           width: 3px;
//           height: 1em;
//           background: var(--accent);
//           margin-left: 2px;
//           vertical-align: middle;
//           animation: blink 1s step-end infinite;
//         }

//         @keyframes blink { 0%,100%{opacity:1} 50%{opacity:0} }

//         .hero-bio {
//           font-size: 1.05rem;
//           color: var(--muted);
//           max-width: 520px;
//           margin-bottom: 2.5rem;
//           line-height: 1.8;
//         }

//         .hero-ctas {
//           display: flex;
//           gap: 1rem;
//           flex-wrap: wrap;
//         }

//         .btn-primary {
//           display: inline-flex;
//           align-items: center;
//           gap: 0.5rem;
//           background: var(--accent);
//           color: #0a0a0f;
//           font-family: var(--heading);
//           font-weight: 700;
//           font-size: 0.9rem;
//           letter-spacing: 0.05em;
//           padding: 0.75rem 1.75rem;
//           border-radius: 8px;
//           text-decoration: none;
//           transition: transform 0.2s, box-shadow 0.2s;
//         }

//         .btn-primary:hover {
//           transform: translateY(-2px);
//           box-shadow: 0 8px 24px rgba(110,231,183,0.3);
//         }

//         .btn-secondary {
//           display: inline-flex;
//           align-items: center;
//           gap: 0.5rem;
//           background: transparent;
//           color: var(--text);
//           font-family: var(--heading);
//           font-weight: 600;
//           font-size: 0.9rem;
//           letter-spacing: 0.05em;
//           padding: 0.75rem 1.75rem;
//           border-radius: 8px;
//           border: 1px solid var(--border);
//           text-decoration: none;
//           transition: border-color 0.2s, background 0.2s;
//         }

//         .btn-secondary:hover {
//           border-color: var(--accent);
//           background: rgba(110,231,183,0.05);
//         }

//         /* SECTIONS */
//         section {
//           padding: 6rem 2.5rem;
//           max-width: 1100px;
//           margin: 0 auto;
//         }

//         .section-label {
//           font-family: var(--heading);
//           font-size: 0.75rem;
//           font-weight: 700;
//           letter-spacing: 0.15em;
//           text-transform: uppercase;
//           color: var(--accent);
//           margin-bottom: 0.75rem;
//         }

//         .section-title {
//           font-family: var(--heading);
//           font-size: clamp(2rem, 4vw, 3rem);
//           font-weight: 800;
//           letter-spacing: -0.03em;
//           color: #fff;
//           margin-bottom: 3rem;
//           line-height: 1.1;
//         }

//         .section-divider {
//           width: 100%;
//           height: 1px;
//           background: linear-gradient(90deg, var(--border), transparent);
//           margin: 0 2.5rem;
//         }

//         /* ABOUT */
//         .about-grid {
//           display: grid;
//           grid-template-columns: 1fr 1fr;
//           gap: 4rem;
//           align-items: start;
//         }

//         .about-text p {
//           color: var(--muted);
//           font-size: 1rem;
//           margin-bottom: 1rem;
//           line-height: 1.9;
//         }

//         .about-stats {
//           display: grid;
//           grid-template-columns: 1fr 1fr;
//           gap: 1rem;
//         }

//         .stat-card {
//           background: var(--surface);
//           border: 1px solid var(--border);
//           border-radius: 12px;
//           padding: 1.5rem;
//           text-align: center;
//           transition: border-color 0.2s;
//         }

//         .stat-card:hover { border-color: var(--accent); }

//         .stat-number {
//           font-family: var(--heading);
//           font-size: 2rem;
//           font-weight: 800;
//           color: var(--accent);
//           display: block;
//         }

//         .stat-label {
//           font-size: 0.8rem;
//           color: var(--muted);
//           letter-spacing: 0.05em;
//         }

//         /* SKILLS */
//         .skill-filters {
//           display: flex;
//           gap: 0.5rem;
//           margin-bottom: 2rem;
//           flex-wrap: wrap;
//         }

//         .filter-btn {
//           font-family: var(--heading);
//           font-size: 0.8rem;
//           font-weight: 600;
//           letter-spacing: 0.05em;
//           padding: 0.4rem 1rem;
//           border-radius: 100px;
//           border: 1px solid var(--border);
//           background: transparent;
//           color: var(--muted);
//           cursor: pointer;
//           transition: all 0.2s;
//         }

//         .filter-btn.active, .filter-btn:hover {
//           background: var(--accent);
//           color: #0a0a0f;
//           border-color: var(--accent);
//         }

//         .skills-grid {
//           display: flex;
//           flex-wrap: wrap;
//           gap: 0.75rem;
//         }

//         .skill-chip {
//           display: flex;
//           align-items: center;
//           gap: 0.5rem;
//           padding: 0.55rem 1.1rem;
//           background: var(--surface);
//           border: 1px solid var(--border);
//           border-radius: 8px;
//           font-size: 0.9rem;
//           font-weight: 500;
//           color: var(--text);
//           transition: all 0.2s;
//           animation: fadeIn 0.3s ease;
//         }

//         @keyframes fadeIn {
//           from { opacity: 0; transform: translateY(6px); }
//           to { opacity: 1; transform: translateY(0); }
//         }

//         .skill-chip:hover {
//           border-color: var(--accent);
//           color: var(--accent);
//           background: rgba(110,231,183,0.06);
//         }

//         .skill-dot {
//           width: 6px; height: 6px;
//           border-radius: 50%;
//           flex-shrink: 0;
//         }

//         /* PROJECTS */
//         .projects-grid {
//           display: grid;
//           grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
//           gap: 1.5rem;
//         }

//         .project-card {
//           background: var(--surface);
//           border: 1px solid var(--border);
//           border-radius: 16px;
//           padding: 2rem;
//           position: relative;
//           overflow: hidden;
//           transition: border-color 0.3s, transform 0.3s;
//         }

//         .project-card::before {
//           content: '';
//           position: absolute;
//           top: 0; left: 0; right: 0;
//           height: 3px;
//           background: linear-gradient(90deg, var(--accent), var(--accent2));
//           transform: scaleX(0);
//           transition: transform 0.3s;
//           transform-origin: left;
//         }

//         .project-card:hover {
//           border-color: rgba(110,231,183,0.3);
//           transform: translateY(-4px);
//         }

//         .project-card:hover::before { transform: scaleX(1); }

//         .project-icon {
//           width: 44px; height: 44px;
//           border-radius: 10px;
//           background: linear-gradient(135deg, rgba(110,231,183,0.15), rgba(129,140,248,0.15));
//           border: 1px solid rgba(110,231,183,0.2);
//           display: flex;
//           align-items: center;
//           justify-content: center;
//           font-size: 1.3rem;
//           margin-bottom: 1.25rem;
//         }

//         .project-title {
//           font-family: var(--heading);
//           font-size: 1.15rem;
//           font-weight: 700;
//           color: #fff;
//           margin-bottom: 0.75rem;
//         }

//         .project-desc {
//           font-size: 0.9rem;
//           color: var(--muted);
//           line-height: 1.7;
//           margin-bottom: 1.5rem;
//         }

//         .project-tags {
//           display: flex;
//           flex-wrap: wrap;
//           gap: 0.5rem;
//           margin-bottom: 1.5rem;
//         }

//         .project-tag {
//           font-size: 0.75rem;
//           font-weight: 600;
//           padding: 0.2rem 0.65rem;
//           border-radius: 100px;
//           background: rgba(129,140,248,0.1);
//           color: var(--accent2);
//           border: 1px solid rgba(129,140,248,0.2);
//         }

//         .project-links {
//           display: flex;
//           gap: 0.75rem;
//         }

//         .project-link {
//           font-size: 0.82rem;
//           font-family: var(--heading);
//           font-weight: 600;
//           color: var(--accent);
//           text-decoration: none;
//           letter-spacing: 0.03em;
//           display: flex;
//           align-items: center;
//           gap: 0.3rem;
//           transition: opacity 0.2s;
//         }

//         .project-link:hover { opacity: 0.7; }

//         /* EDUCATION */
//         .edu-card {
//           background: var(--surface);
//           border: 1px solid var(--border);
//           border-radius: 16px;
//           padding: 2rem 2.5rem;
//           display: flex;
//           gap: 2rem;
//           align-items: flex-start;
//           transition: border-color 0.2s;
//         }

//         .edu-card:hover { border-color: rgba(110,231,183,0.3); }

//         .edu-icon {
//           width: 52px; height: 52px;
//           border-radius: 12px;
//           background: linear-gradient(135deg, rgba(110,231,183,0.15), rgba(129,140,248,0.15));
//           border: 1px solid rgba(110,231,183,0.2);
//           display: flex;
//           align-items: center;
//           justify-content: center;
//           font-size: 1.5rem;
//           flex-shrink: 0;
//         }

//         .edu-degree {
//           font-family: var(--heading);
//           font-size: 1.2rem;
//           font-weight: 700;
//           color: #fff;
//           margin-bottom: 0.25rem;
//         }

//         .edu-college {
//           font-size: 1rem;
//           color: var(--muted);
//           margin-bottom: 0.75rem;
//         }

//         .edu-meta {
//           display: flex;
//           gap: 1rem;
//           flex-wrap: wrap;
//         }

//         .edu-badge {
//           font-size: 0.8rem;
//           font-weight: 600;
//           padding: 0.25rem 0.75rem;
//           border-radius: 100px;
//           background: rgba(110,231,183,0.1);
//           color: var(--accent);
//           border: 1px solid rgba(110,231,183,0.2);
//         }

//         /* CONTACT */
//         .contact-grid {
//           display: grid;
//           grid-template-columns: 1fr 1fr;
//           gap: 3rem;
//           align-items: start;
//         }

//         .contact-info h3 {
//           font-family: var(--heading);
//           font-size: 1.5rem;
//           font-weight: 700;
//           color: #fff;
//           margin-bottom: 1rem;
//         }

//         .contact-info p {
//           color: var(--muted);
//           font-size: 1rem;
//           margin-bottom: 2rem;
//           line-height: 1.8;
//         }

//         .contact-links {
//           display: flex;
//           flex-direction: column;
//           gap: 1rem;
//         }

//         .contact-link-item {
//           display: flex;
//           align-items: center;
//           gap: 0.75rem;
//           color: var(--text);
//           text-decoration: none;
//           font-size: 0.95rem;
//           transition: color 0.2s;
//         }

//         .contact-link-item:hover { color: var(--accent); }

//         .contact-link-icon {
//           width: 36px; height: 36px;
//           border-radius: 8px;
//           background: var(--surface);
//           border: 1px solid var(--border);
//           display: flex;
//           align-items: center;
//           justify-content: center;
//           font-size: 1rem;
//           flex-shrink: 0;
//         }

//         .contact-form {
//           display: flex;
//           flex-direction: column;
//           gap: 1rem;
//         }

//         .form-group {
//           display: flex;
//           flex-direction: column;
//           gap: 0.4rem;
//         }

//         .form-group label {
//           font-size: 0.8rem;
//           font-weight: 600;
//           color: var(--muted);
//           letter-spacing: 0.05em;
//           text-transform: uppercase;
//           font-family: var(--heading);
//         }

//         .form-group input, .form-group textarea {
//           background: var(--surface);
//           border: 1px solid var(--border);
//           border-radius: 8px;
//           padding: 0.75rem 1rem;
//           color: var(--text);
//           font-family: var(--body);
//           font-size: 0.95rem;
//           outline: none;
//           transition: border-color 0.2s;
//           resize: none;
//         }

//         .form-group input:focus, .form-group textarea:focus {
//           border-color: var(--accent);
//         }

//         /* FOOTER */
//         footer {
//           border-top: 1px solid var(--border);
//           padding: 2rem 2.5rem;
//           text-align: center;
//           color: var(--muted);
//           font-size: 0.85rem;
//         }

//         footer span { color: var(--accent); }

//         /* MOBILE */
//         @media (max-width: 768px) {
//           nav { padding: 1rem 1.5rem; }
//           .nav-links { display: none; }
//           .hamburger { display: flex; }
//           .nav-links.open {
//             display: flex;
//             flex-direction: column;
//             position: absolute;
//             top: 100%; left: 0; right: 0;
//             background: var(--surface);
//             border-bottom: 1px solid var(--border);
//             padding: 1.5rem;
//             gap: 1.25rem;
//           }

//           #home { padding: 0 1.5rem; }
//           section { padding: 4rem 1.5rem; }

//           .about-grid, .contact-grid { grid-template-columns: 1fr; gap: 2rem; }
//           .edu-card { flex-direction: column; gap: 1rem; }
//         }
//       `}</style>

//       {/* NAV */}
//       <nav>
//         <a href="#home" className="nav-logo">IA.</a>
//         <ul className={`nav-links ${menuOpen ? "open" : ""}`}>
//           {navLinks.map((link) => (
//             <li key={link}>
//               <a
//                 href={`#${link}`}
//                 className={activeSection === link ? "active" : ""}
//                 onClick={() => setMenuOpen(false)}
//               >
//                 {link}
//               </a>
//             </li>
//           ))}
//         </ul>
//         <button className="hamburger" onClick={() => setMenuOpen(!menuOpen)} aria-label="Menu">
//           <span /><span /><span />
//         </button>
//       </nav>

//       {/* HERO */}
//       <section id="home" style={{ maxWidth: "100%", padding: 0 }}>
//         <div className="hero-bg" />
//         <div className="hero-grid" />
//         <div className="hero-content" style={{ padding: "0 2.5rem" }}>
//           <div className="hero-badge">Available for Opportunities</div>
//           <h1 className="hero-name">
//             Imam<span>uddin</span><br />Ansari
//           </h1>
//           <p className="hero-role">
//             {typed}<span className="cursor" />
//           </p>
//           <p className="hero-bio">
//             A passionate Computer Science graduate from Gopalganj, Bihar — building
//             modern, scalable web experiences from frontend to backend. I love turning
//             ideas into real, working products.
//           </p>
//           <div className="hero-ctas">
//             <a href="#projects" className="btn-primary">
//               View My Work →
//             </a>
//             <a href="#contact" className="btn-secondary">
//               Get In Touch
//             </a>
//           </div>
//         </div>
//       </section>

//       <div className="section-divider" />

//       {/* ABOUT */}
//       <section id="about">
//         <div className="section-label">Who I Am</div>
//         <h2 className="section-title">About Me</h2>
//         <div className="about-grid">
//           <div className="about-text">
//             <p>
//               Hi! I&apos;m <strong style={{ color: "#fff" }}>Imamuddin Ansari</strong>, a
//               fresher Full Stack Developer with a B.Tech in Computer Science &amp;
//               Engineering. I&apos;m based in Gopalganj, Bihar, and passionate about
//               crafting seamless digital experiences.
//             </p>
//             <p>
//               I enjoy working across the entire stack — designing intuitive UIs with
//               React and Next.js, and building robust backend systems with Java and SQL.
//               I&apos;m always eager to learn new technologies and solve real-world
//               problems through code.
//             </p>
//             <p>
//               When I&apos;m not coding, I&apos;m exploring machine learning concepts,
//               contributing to projects, and continuously sharpening my problem-solving
//               skills.
//             </p>
//           </div>
//           <div className="about-stats">
//             {[
//               { num: "6.07", label: "CGPA" },
//               { num: "2024", label: "Graduated" },
//               { num: "16+", label: "Technologies" },
//               { num: "1+", label: "Projects" },
//             ].map((s) => (
//               <div key={s.label} className="stat-card">
//                 <span className="stat-number">{s.num}</span>
//                 <span className="stat-label">{s.label}</span>
//               </div>
//             ))}
//           </div>
//         </div>
//       </section>

//       <div className="section-divider" />

//       {/* SKILLS */}
//       <section id="skills">
//         <div className="section-label">What I Know</div>
//         <h2 className="section-title">Skills & Tools</h2>
//         <div className="skill-filters">
//           {categories.map((c) => (
//             <button
//               key={c}
//               className={`filter-btn ${activeCategory === c ? "active" : ""}`}
//               onClick={() => setActiveCategory(c)}
//             >
//               {c}
//             </button>
//           ))}
//         </div>
//         <div className="skills-grid">
//           {filteredSkills.map((skill) => {
//             const dotColor =
//               skill.category === "Frontend"
//                 ? "#6ee7b7"
//                 : skill.category === "Backend"
//                   ? "#818cf8"
//                   : "#f59e0b";
//             return (
//               <div className="skill-chip" key={skill.name}>
//                 <span className="skill-dot" style={{ background: dotColor }} />
//                 {skill.name}
//               </div>
//             );
//           })}
//         </div>
//       </section>

//       <div className="section-divider" />

//       {/* PROJECTS */}
//       <section id="projects">
//         <div className="section-label">What I Built</div>
//         <h2 className="section-title">Projects</h2>
//         <div className="projects-grid">
//           <div className="project-card">
//             <div className="project-icon">🤖</div>
//             <div className="project-title">SMS Spam Detection</div>
//             <p className="project-desc">
//               A machine learning model using a Transformer architecture to classify SMS
//               messages as spam or legitimate. Trained on real-world datasets with high
//               accuracy for reliable spam filtering.
//             </p>
//             <div className="project-tags">
//               {["Python", "HTML", "CSS", "JavaScript", "Transformer Model"].map((t) => (
//                 <span key={t} className="project-tag">{t}</span>
//               ))}
//             </div>
//             <div className="project-links">
//               <a href="https://github.com/imamuddin" className="project-link" target="_blank" rel="noopener noreferrer">
//                 ↗ GitHub
//               </a>
//             </div>
//           </div>
//         </div>
//       </section>

//       <div className="section-divider" />

//       {/* EDUCATION */}
//       <section id="education">
//         <div className="section-label">My Background</div>
//         <h2 className="section-title">Education</h2>
//         <div className="edu-card">
//           <div className="edu-icon">🎓</div>
//           <div>
//             <div className="edu-degree">B.Tech — Computer Science & Engineering</div>
//             <div className="edu-college">Global Institute of Engineering and Technology</div>
//             <div className="edu-meta">
//               <span className="edu-badge">2024</span>
//               <span className="edu-badge">CGPA: 6.07</span>
//               <span className="edu-badge">Full Time</span>
//             </div>
//           </div>
//         </div>
//       </section>

//       <div className="section-divider" />

//       {/* CONTACT */}
//       <section id="contact">
//         <div className="section-label">Let's Talk</div>
//         <h2 className="section-title">Get In Touch</h2>
//         <div className="contact-grid">
//           <div className="contact-info">
//             <h3>Open to opportunities!</h3>
//             <p>
//               I&apos;m actively looking for full-time roles and internships. Whether you
//               have a project idea, a job opportunity, or just want to connect — feel free
//               to reach out!
//             </p>
//             <div className="contact-links">
//               <a href="mailto:imamuddin@gmail.com" className="contact-link-item">
//                 <span className="contact-link-icon">✉️</span>
//                 imamuddin@gmail.com
//               </a>
//               <a href="https://github.com/imamuddin" target="_blank" rel="noopener noreferrer" className="contact-link-item">
//                 <span className="contact-link-icon">🐙</span>
//                 github.com/imamuddin
//               </a>
//               <a href="https://linkedin.in/imamuddin" target="_blank" rel="noopener noreferrer" className="contact-link-item">
//                 <span className="contact-link-icon">💼</span>
//                 linkedin.in/imamuddin
//               </a>
//               <a href="#" className="contact-link-item">
//                 <span className="contact-link-icon">📄</span>
//                 Download Resume
//               </a>
//             </div>
//           </div>
//           <div className="contact-form">
//             <div className="form-group">
//               <label>Name</label>
//               <input type="text" placeholder="Your name" />
//             </div>
//             <div className="form-group">
//               <label>Email</label>
//               <input type="email" placeholder="your@email.com" />
//             </div>
//             <div className="form-group">
//               <label>Message</label>
//               <textarea rows={5} placeholder="What's on your mind?" />
//             </div>
//             <button className="btn-primary" style={{ alignSelf: "flex-start" }}>
//               Send Message →
//             </button>
//           </div>
//         </div>
//       </section>

//       {/* FOOTER */}
//       <footer>
//         <p>Designed & Built by <span>Imamuddin Ansari</span> · {new Date().getFullYear()}</p>
//       </footer>
//     </>
//   );
// }
"use client";

import { useEffect, useState } from "react";
import ThemeToggle from "./ThemeToggle";

/* ─────────────────────────────────────────
   DATA
───────────────────────────────────────── */
const NAV_LINKS = ["about", "skills", "projects", "education", "contact"];

const SKILLS = [
  { name: "Next.js", category: "Frontend" },
  { name: "React.js", category: "Frontend" },
  { name: "TypeScript", category: "Frontend" },
  { name: "JavaScript", category: "Frontend" },
  { name: "HTML", category: "Frontend" },
  { name: "CSS", category: "Frontend" },
  { name: "Tailwind CSS", category: "Frontend" },
  { name: "Bootstrap", category: "Frontend" },
  { name: "Java", category: "Backend" },
  { name: "SQL", category: "Backend" },
  { name: "Spring Tool Suite", category: "Backend" },
  { name: "Git & GitHub", category: "Tools" },
  { name: "VS Code", category: "Tools" },
  { name: "Cursor IDE", category: "Tools" },
  { name: "Eclipse", category: "Tools" },
  { name: "Postman", category: "Tools" },
];

const CATEGORIES = ["All", "Frontend", "Backend", "Tools"];

const DOT_COLORS: Record<string, string> = {
  Frontend: "#6ee7b7",
  Backend: "#818cf8",
  Tools: "#f59e0b",
};

const STATS = [
  { num: "6.07", label: "CGPA" },
  { num: "2024", label: "Graduated" },
  { num: "16+", label: "Technologies" },
  { num: "1+", label: "Projects" },
];

/* ─────────────────────────────────────────
   COMPONENT
───────────────────────────────────────── */
export default function Portfolio() {
  const [activeSection, setActiveSection] = useState("home");
  const [menuOpen, setMenuOpen] = useState(false);
  const [typed, setTyped] = useState("");
  const [activeCategory, setActiveCategory] = useState("All");

  /* Typewriter */
  useEffect(() => {
    const fullText = "Full Stack Developer";
    let i = 0;
    const interval = setInterval(() => {
      setTyped(fullText.slice(0, i + 1));
      i++;
      if (i === fullText.length) clearInterval(interval);
    }, 80);
    return () => clearInterval(interval);
  }, []);

  /* Active nav on scroll */
  useEffect(() => {
    const sections = document.querySelectorAll("section[id]");
    const observer = new IntersectionObserver(
      (entries) => {
        entries.forEach((entry) => {
          if (entry.isIntersecting) setActiveSection(entry.target.id);
        });
      },
      { threshold: 0.4 }
    );
    sections.forEach((s) => observer.observe(s));
    return () => observer.disconnect();
  }, []);

  const filteredSkills =
    activeCategory === "All"
      ? SKILLS
      : SKILLS.filter((s) => s.category === activeCategory);

  return (
    <>
      {/* ── NAVBAR ─────────────────────────────────────────────── */}
      <nav>
        <a href="#home" className="nav-logo">IA.</a>

        <ul className={`nav-links ${menuOpen ? "open" : ""}`}>
          {NAV_LINKS.map((link) => (
            <li key={link}>
              <a
                href={`#${link}`}
                className={activeSection === link ? "active" : ""}
                onClick={() => setMenuOpen(false)}
              >
                {link}
              </a>
            </li>
          ))}
        </ul>

        <div className="nav-right">
          <ThemeToggle />
          <button
            className="hamburger"
            onClick={() => setMenuOpen(!menuOpen)}
            aria-label="Toggle menu"
          >
            <span /><span /><span />
          </button>
        </div>
      </nav>

      {/* ── HERO ───────────────────────────────────────────────── */}
      <section id="home" style={{ maxWidth: "100%", padding: 0 }}>
        <div className="hero-bg" />
        <div className="hero-grid" />
        <div className="hero-content" >
          <div className="hero-badge">Available for Opportunities</div>

          <h1 className="hero-name">
            Imam<span>uddin</span><br />Ansari
          </h1>

          <p className="hero-role">
            {typed}<span className="cursor" />
          </p>

          <p className="hero-bio">
            A passionate Computer Science graduate from Gopalganj, Bihar — building
            modern, scalable web experiences from frontend to backend. I love turning
            ideas into real, working products.
          </p>

          <div className="hero-ctas">
            <a href="#projects" className="btn-primary">View My Work →</a>
            <a href="#contact" className="btn-secondary">Get In Touch</a>
          </div>
        </div>
      </section>

      <div className="section-divider" />

      {/* ── ABOUT ──────────────────────────────────────────────── */}
      <section id="about">
        <div className="section-label">Who I Am</div>
        <h2 className="section-title">About Me</h2>

        <div className="about-grid">
          <div className="about-text">
            <p>
              Hi! I&apos;m <strong style={{ color: "#fff" }}>Imamuddin Ansari</strong>, a
              fresher Full Stack Developer with a B.Tech in Computer Science &amp;
              Engineering. I&apos;m based in Gopalganj, Bihar, and passionate about
              crafting seamless digital experiences.
            </p>
            <p>
              I enjoy working across the entire stack — designing intuitive UIs with
              React and Next.js, and building robust backend systems with Java and SQL.
              I&apos;m always eager to learn new technologies and solve real-world
              problems through code.
            </p>
            <p>
              When I&apos;m not coding, I&apos;m exploring machine learning concepts,
              contributing to projects, and continuously sharpening my problem-solving
              skills.
            </p>
          </div>

          <div className="about-stats">
            {STATS.map((s) => (
              <div key={s.label} className="stat-card">
                <span className="stat-number">{s.num}</span>
                <span className="stat-label">{s.label}</span>
              </div>
            ))}
          </div>
        </div>
      </section>

      <div className="section-divider" />

      {/* ── SKILLS ─────────────────────────────────────────────── */}
      <section id="skills">
        <div className="section-label">What I Know</div>
        <h2 className="section-title">Skills &amp; Tools</h2>

        <div className="skill-filters">
          {CATEGORIES.map((c) => (
            <button
              key={c}
              className={`filter-btn ${activeCategory === c ? "active" : ""}`}
              onClick={() => setActiveCategory(c)}
            >
              {c}
            </button>
          ))}
        </div>

        <div className="skills-grid">
          {filteredSkills.map((skill) => (
            <div key={skill.name} className="skill-chip">
              <span className="skill-dot" style={{ background: DOT_COLORS[skill.category] }} />
              {skill.name}
            </div>
          ))}
        </div>
      </section>

      <div className="section-divider" />

      {/* ── PROJECTS ───────────────────────────────────────────── */}
      <section id="projects">
        <div className="section-label">What I Built</div>
        <h2 className="section-title">Projects</h2>

        <div className="projects-grid">
          <div className="project-card">
            <div className="project-icon">🤖</div>
            <div className="project-title">SMS Spam Detection</div>
            <p className="project-desc">
              A machine learning model using a Transformer architecture to classify SMS
              messages as spam or legitimate. Trained on real-world datasets with high
              accuracy for reliable spam filtering.
            </p>
            <div className="project-tags">
              {["Python", "HTML", "CSS", "JavaScript", "Transformer Model"].map((t) => (
                <span key={t} className="project-tag">{t}</span>
              ))}
            </div>
            <div className="project-links">
              <a
                href="https://github.com/imamuddin"
                className="project-link"
                target="_blank"
                rel="noopener noreferrer"
              >
                ↗ GitHub
              </a>
            </div>
          </div>
        </div>
      </section>

      <div className="section-divider" />

      {/* ── EDUCATION ──────────────────────────────────────────── */}
      <section id="education">
        <div className="section-label">My Background</div>
        <h2 className="section-title">Education</h2>

        <div className="edu-card">
          <div className="edu-icon">🎓</div>
          <div>
            <div className="edu-degree">B.Tech — Computer Science &amp; Engineering</div>
            <div className="edu-college">Global Institute of Engineering and Technology</div>
            <div className="edu-meta">
              <span className="edu-badge">2024</span>
              <span className="edu-badge">CGPA: 6.07</span>
              <span className="edu-badge">Full Time</span>
            </div>
          </div>
        </div>
      </section>

      <div className="section-divider" />

      {/* ── CONTACT ────────────────────────────────────────────── */}
      <section id="contact">
        <div className="section-label">Let&apos;s Talk</div>
        <h2 className="section-title">Get In Touch</h2>

        <div className="contact-grid">
          <div className="contact-info">
            <h3>Open to opportunities!</h3>
            <p>
              I&apos;m actively looking for full-time roles and internships. Whether you
              have a project idea, a job opportunity, or just want to connect — feel free
              to reach out!
            </p>
            <div className="contact-links">
              <a href="mailto:imamuddin@gmail.com" className="contact-link-item">
                <span className="contact-link-icon">✉️</span>
                imamuddin@gmail.com
              </a>
              <a href="https://github.com/imamuddin" target="_blank" rel="noopener noreferrer" className="contact-link-item">
                <span className="contact-link-icon">🐙</span>
                github.com/imamuddin
              </a>
              <a href="https://linkedin.in/imamuddin" target="_blank" rel="noopener noreferrer" className="contact-link-item">
                <span className="contact-link-icon">💼</span>
                linkedin.in/imamuddin
              </a>
              <a href="#" className="contact-link-item">
                <span className="contact-link-icon">📄</span>
                Download Resume
              </a>
            </div>
          </div>

          <div className="contact-form">
            <div className="form-group">
              <label>Name</label>
              <input type="text" placeholder="Your name" />
            </div>
            <div className="form-group">
              <label>Email</label>
              <input type="email" placeholder="your@email.com" />
            </div>
            <div className="form-group">
              <label>Message</label>
              <textarea rows={5} placeholder="What's on your mind?" />
            </div>
            <button className="btn-primary" style={{ alignSelf: "flex-start" }}>
              Send Message →
            </button>
          </div>
        </div>
      </section>

      {/* ── FOOTER ─────────────────────────────────────────────── */}
      <footer>
        <p>Designed &amp; Built by <span>Imamuddin Ansari</span> · {new Date().getFullYear()}</p>
      </footer>
    </>
  );
}