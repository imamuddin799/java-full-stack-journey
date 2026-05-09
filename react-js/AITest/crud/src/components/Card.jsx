
let Card = (props) => {

    let obj = props.details;
    let { name, age, mobile, email } = obj;
    let [, , selectedStudent, setSelectedStudent, selectedToDelete, setSelectedToDelete] = props.data;

    let handleEditClick = (student) => {
        setSelectedStudent(student)
    }

    let handleDeleteClick = (student) => {
        setSelectedToDelete(student);
    }

    return <>
        <div className="card">
            <p><strong>Name:</strong>{name || "Imamuddin Ansari"}</p>
            <p><strong>Age:</strong>{age || "23"}</p>
            <p><strong>Mobile:</strong>{mobile || 9876543210}</p>
            <p><strong>Email:</strong>{email || "imamuddinansriansari@gmail.com"}</p>
            <div>
                <button className="btnEdit" onClick={() => handleEditClick(obj)}>Edit</button>
                <button className="btnDelete" onClick={() => handleDeleteClick(obj)}>Delete</button>
            </div>
        </div>
    </>
}
export default Card;