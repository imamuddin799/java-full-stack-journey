import { Fragment, useEffect, useState } from "react";

let StudentList = (props) => {

    let [jsonobj, setJsonobj] = props.data;
    let [, , selectedStudent, setSelectedStudent, selectedToDelete, setSelectedToDelete] = props.data;

    let handleEditClick = (student) => {
        setSelectedStudent(student);
    }

    let handleDeleteClick = (student) => {
        setSelectedToDelete(student);
    }

    return <>
        {
            jsonobj.map((object, index) => {
                let { name, age, mobile, email } = object;
                return <Fragment key={index}>
                    <tr style={{backgroundColor : index % 2 === 0 ? 'lightcyan' : 'lightgreen' }}>
                        <td>{name || "Imamuddin Ansari"}</td>
                        <td>{age || 23}</td>
                        <td>{mobile || 9876543210}</td>
                        <td>{email || "example@gmail.com"}</td>
                        <td className="actionCol">
                            <button className="btnEdit" onClick={() => handleEditClick(object)}>Edit</button>
                            <button className="btnDelete" onClick={() => handleDeleteClick(object)}>Delete</button>
                        </td>
                    </tr>
                </Fragment>
            })
        }
    </>
}
export default StudentList;