import { Component } from "react";

class About extends Component {
    render() {
        let obj = {
            fname: "Imamuddin",
            lname: "Ansari",
            email: "imam@gmail.com",
            phone: 9876543210,
            gender : "Male"
        }
        return <>
            <h1>About Us Using Class</h1>
            <h2>First Name : { obj.fname }</h2>
            <h2>Last Name : { obj.lname }</h2>
            <h2>Email : { obj.email }</h2>
            <h2>Phone : { obj.phone }</h2>
            <h2>Gender : { obj.gender }</h2>
        </>
    }
}
export default About;