
import { Fragment, useState } from "react";
import jsondata from "./MOCK_DATA.json";
import { useEffect } from "react";

const EmployeeDetails = () => {

    const [employees, setEmployees] = useState(jsondata);
    const [selectedEmployee, setSelectedEmployee] = useState(null);
    const [employeeToDelete, setEmployeeToDelete] = useState(null);
    const [editFormData, setEditFormData] = useState({});

    const handleFormChange = (e) => {
        console.log(e);
        const { name, value } = e.target;
        // console.log(name, value);
        setEditFormData((prev) => ({ ...prev, [name]: value }));
    };

    const handleSaveEdit = () => {
        setEmployees((prev) =>
            prev.map((emp) =>
                emp.employee_id === editFormData.employee_id ? editFormData : emp
            )
        );
        closeEditModal();
    };

    useEffect(() => {
        if (selectedEmployee) {
            setEditFormData(selectedEmployee);
        }
    }, [selectedEmployee]);

    const handleEditClick = (employee) => {
        setSelectedEmployee(employee);
    };

    const closeEditModal = () => {
        setSelectedEmployee(null);
    };

    const handleDeleteClick = (employee) => {
        setEmployeeToDelete(employee);
    };

    const closeDeleteModal = () => {
        setEmployeeToDelete(null);
    };

    const handleConfirmDelete = () => {
        setEmployees((prevEmployees) =>
            prevEmployees.filter(
                (emp) => emp.employee_id !== employeeToDelete.employee_id
            )
        );
        closeDeleteModal();
    };

    return (
        <>
            <table border={"2px solid"} rules="all" style={{ width: "100%" }}>
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>Full Name</th>
                        <th>Job Title</th>
                        <th>Department</th>
                        <th>Hire Date</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    {employees.map((element, index) => {
                        let { employee_id, full_name, job_title, department, hire_date } = element;
                        return (
                            <Fragment key={index}>
                                <tr bgcolor={index % 2 == 0 ? "lightgreen" : "white"}>
                                    <td>{employee_id}</td>
                                    <td>{full_name}</td>
                                    <td>{job_title}</td>
                                    <td bgcolor={department == "IT" ? "Red" : department == "Finance" ? "Green" : ""}>{department}</td>
                                    <td>{hire_date}</td>
                                    <td>
                                        <button
                                            type="button"
                                            className="btn btn-primary"
                                            onClick={() => handleEditClick(element)}
                                        >
                                            Edit
                                        </button>
                                    </td>
                                    <td>
                                        <button
                                            type="button"
                                            className="btn btn-danger"
                                            onClick={() => handleDeleteClick(element)}
                                        >
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            </Fragment>
                        );
                    })}
                </tbody>
            </table>

            {/* Edit Modal */}
            {/* conditional rendering */}
            {selectedEmployee && (
                <div
                    className="modal fade show"
                    style={{ display: "block", backgroundColor: "rgba(0,0,0,0.5)" }}
                    tabIndex="-1"
                    role="dialog"
                >
                    <div className="modal-dialog modal-dialog-centered">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title">Edit Employee</h5>
                                <button
                                    type="button"
                                    className="btn-close"
                                    onClick={closeEditModal}
                                ></button>
                            </div>
                            <div className="modal-body">
                                <form>
                                    <div className="mb-3">
                                        <label className="form-label">Employee ID</label>
                                        <input
                                            type="text"
                                            className="form-control"
                                            name="employee_id"
                                            value={editFormData.employee_id || ""}
                                            disabled
                                        />
                                    </div>
                                    <div className="mb-3">
                                        <label className="form-label">Full Name</label>
                                        <input
                                            type="text"
                                            className="form-control"
                                            name="full_name"
                                            value={editFormData.full_name || ""}
                                            onChange={handleFormChange}
                                        />
                                    </div>
                                    <div className="mb-3">
                                        <label className="form-label">Job Title</label>
                                        <input
                                            type="text"
                                            className="form-control"
                                            name="job_title"
                                            value={editFormData.job_title || ""}
                                            onChange={handleFormChange}
                                        />
                                    </div>
                                    <div className="mb-3">
                                        <label className="form-label">Department</label>
                                        <input
                                            type="text"
                                            className="form-control"
                                            name="department"
                                            value={editFormData.department || ""}
                                            onChange={handleFormChange}
                                        />
                                    </div>
                                    <div className="mb-3">
                                        <label className="form-label">Hire Date</label>
                                        <input
                                            type="date"
                                            className="form-control"
                                            name="hire_date"
                                            value={editFormData.hire_date || ""}
                                            onChange={handleFormChange}
                                        />
                                    </div>
                                </form>
                            </div>
                            <div className="modal-footer">
                                <button
                                    type="button"
                                    className="btn btn-secondary"
                                    onClick={closeEditModal}
                                >
                                    Close
                                </button>
                                <button
                                    type="button"
                                    className="btn btn-primary"
                                    onClick={handleSaveEdit}
                                >
                                    Save Changes
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            )}

            {/* Delete Modal */}
            {employeeToDelete && (
                <div
                    className="modal fade show"
                    style={{ display: "block", backgroundColor: "rgba(0,0,0,0.5)" }}
                    id="deleteModal"
                    tabIndex="-1"
                    aria-labelledby="deleteModalLabel"
                    aria-modal="true"
                    role="dialog"
                >
                    <div className="modal-dialog modal-dialog-centered">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="deleteModalLabel">
                                    Confirm Delete
                                </h5>
                                <button
                                    type="button"
                                    className="btn-close"
                                    onClick={closeDeleteModal}
                                ></button>
                            </div>
                            <div className="modal-body">
                                <p>
                                    Are you sure you want to delete the following employee?
                                </p>
                                <p>
                                    <strong>Employee ID:</strong>{" "}
                                    {employeeToDelete.employee_id}
                                </p>
                                <p>
                                    <strong>Full Name:</strong> {employeeToDelete.full_name}
                                </p>
                            </div>
                            <div className="modal-footer">
                                <button
                                    type="button"
                                    className="btn btn-secondary"
                                    onClick={closeDeleteModal}
                                >
                                    Cancel
                                </button>
                                <button
                                    type="button"
                                    className="btn btn-danger"
                                    onClick={handleConfirmDelete}
                                >
                                    Delete
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            )}
        </>
    );
};

export default EmployeeDetails;





// console.log(jsondata);
// console.log("[");
// jsondata.map((ele) => {
//     let { employee_id, full_name, job_title, department, hire_date } = ele
//     console.log('{ "employee_id" : ' + employee_id + ', "full_name" : "' + full_name + '", "job_title" : "' + job_title + '", "department" : "' + department + '", "hire_date" : ' + formatDate(hire_date) + '},');
// })
// console.log("]");

// function formatDate(inputDate) {
//     // Split the original date string into parts (assuming it's "M-D-YYYY")
//     const parts = inputDate.split("-");
//     if (parts.length !== 3) return inputDate; // Fallback if not as expected

//     // Pad the month and day parts with a leading zero if needed
//     const month = parts[0].padStart(2, "0");
//     const day = parts[1].padStart(2, "0");
//     const year = parts[2];

//     // Return in the format "yyyy-MM-dd"
//     return `${year}-${month}-${day}`;
// }