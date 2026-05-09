// components/Table.jsx
import StudentList from "./StudentList";

const Table = ({ students, setSelectedStudent, setSelectedToDelete, searchQuery }) => {
    return (
        <table className="students-table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Mobile</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <StudentList
                    students={students}
                    setSelectedStudent={setSelectedStudent}
                    setSelectedToDelete={setSelectedToDelete}
                    searchQuery={searchQuery}
                />
            </tbody>
        </table>
    );
};

export default Table;
