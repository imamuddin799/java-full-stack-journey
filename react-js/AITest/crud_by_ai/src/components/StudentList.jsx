// components/StudentList.jsx
const StudentList = ({ students, setSelectedStudent, setSelectedToDelete, searchQuery }) => {
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
        <>
            {students.map((student, index) => (
                <tr key={index}>
                    <td>{highlightText(student.name, searchQuery)}</td>
                    <td>{highlightText(student.age, searchQuery)}</td>
                    <td>{highlightText(student.mobile, searchQuery)}</td>
                    <td>{highlightText(student.email, searchQuery)}</td>
                    <td>
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
                    </td>
                </tr>
            ))}
        </>
    );
};

export default StudentList;
