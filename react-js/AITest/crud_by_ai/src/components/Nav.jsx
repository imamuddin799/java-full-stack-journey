// components/Nav.jsx
const Nav = ({ view, setView }) => {
    const handleToggle = () => {
        setView(view === "list" ? "card" : "list");
    };

    return (
        <nav className="navbar">
            <h1>Student Management System</h1>
            <button onClick={handleToggle} className="toggle-btn">
                {view === "list" ? "Switch to Card View" : "Switch to List View"}
            </button>
        </nav>
    );
};

export default Nav;