// components/StudentCard.jsx
const StudentCard = ({ students, setSelectedStudent, setSelectedToDelete, searchQuery }) => {
    const highlightText = (text, query) => {
        if (!query) return text;
        const regex = new RegExp(`(${query})`, "gi");
        const parts = text.split(regex);
        return parts.map((part, index) =>
            regex.test(part) ? (
                <span key={index} style={{ backgroundColor: "yellow" }}>
                    {part}
                </span>
            ) : (
                part
            )
        );
    };

    return (
        <div className="card-container">
            {students.map((student, index) => (
                <div key={index} className="student-card">
                    <h3>{highlightText(student.name, searchQuery)}</h3>
                    <p>
                        <strong>Age:</strong> {highlightText(student.age, searchQuery)}
                    </p>
                    <p>
                        <strong>Mobile:</strong>{" "}
                        {highlightText(student.mobile, searchQuery)}
                    </p>
                    <p>
                        <strong>Email:</strong>{" "}
                        {highlightText(student.email, searchQuery)}
                    </p>
                    <div className="card-actions">
                        <button
                            onClick={() => setSelectedStudent(student)}
                            className="btnEdit"
                        >
                            Edit
                        </button>
                        <button
                            onClick={() => setSelectedToDelete(student)}
                            className="btnDelete"
                        >
                            Delete
                        </button>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default StudentCard;
