import StudentList from "./StudentList";

let Table = (props) => {

    return <>
        <table>
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
                <StudentList data={props.data} />
            </tbody>
        </table>
    </>
}
export default Table;