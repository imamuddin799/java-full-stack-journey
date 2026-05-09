// components/DeleteStudentDialog.jsx
const DeleteStudentDialog = ({ student, handleCancel, handleConfirm }) => {
    return (
        <dialog open className="dialog delete-dialog">
            <div className="dialog-content">
                <h2>Confirm Delete</h2>
                <p>Are you sure you want to delete the following student?</p>
                <p><strong>Student Name: </strong>{student.name}</p>
                <p><strong>Student Email: </strong>{student.email}</p>
                <hr />
                <div className="button-group">
                    <button className="btnCancel" onClick={handleCancel}>Cancel</button>
                    <button className="btnDelete" onClick={handleConfirm}>Delete</button>
                </div>
            </div>
        </dialog>
    );
};

export default DeleteStudentDialog;