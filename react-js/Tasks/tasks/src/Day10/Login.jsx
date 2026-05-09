import { Component } from "react";

class Login extends Component {
    render() {
        return <>
            <h1>Login Using Class</h1>
            <label htmlFor="email">Email : </label>
            <input type="email" name="email" id="email" /><br />

            <label htmlFor="password">Password : </label>
            <input type="password" name="password" id="password" /><br />

            <button type="submit">Submit</button>
            <button type="reset">Reset</button>
        </>
    }
}
export default Login;