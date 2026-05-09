let studentDetails = {
    studentName: "Raj",
    age: 30,
    isMarried: false,
    isWorking: false,
    noOfchildren: null,
    salary: undefined,
    address: {
        village: "Rajapur",
        district: "Patna",
        state: "Bihar",
    },
    skills: ["HTML", "CSS", "JS", "React"]
}

let { studentName, age, isMarried, isWorking, noOfchildren, salary, address: { village, district, state } } = studentDetails;

let Day9Task = () => {
    return (
        <>
            <h1>Day 9 Task</h1>
            <h1>Student Details</h1>
            <h2>Student Name : {studentName}</h2>
            <h2>Student Age : {age}</h2>
            <h2>Student Marrital Status : {isMarried ? "Mairried" : "Single"}</h2>
            <h2>Student Working Status : {isWorking ? "Working in MNC company" : "Jobless fellow"}</h2>
            <h2>Student has No of Children : {noOfchildren ? noOfchildren : 0}</h2>
            <h2>Student Salary : {salary ? 50000 : 0}</h2>
            <h2>Student Address</h2>
            <h2>Village : {village}</h2>
            <h2>District : {district}</h2>
            <h2>State : {state}</h2>

            <table border={"2px solid black"}>
                <tr>
                    <th>s.no</th>
                    <th>subject</th>
                    <th>marks</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Mathematics</td>
                    <td>35</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Physics</td>
                    <td>49</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Chemistry</td>
                    <td>55</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>English</td>
                    <td>70</td>
                </tr>
            </table>
        </>
    )
}

export default Day9Task