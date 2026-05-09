
let Register = () => {
    return <>
        <h1>Register Using Function</h1>
        <label htmlFor="fname">First Name : </label>
        <input type="text" name="fname" id="fname" /><br />

        <label htmlFor="lname">Last Name : </label>
        <input type="text" name="lname" id="lname" /><br />

        <label htmlFor="email">Email : </label>
        <input type="email" name="email" id="email" /><br />

        <label htmlFor="phone">Phone : </label>
        <input type="tel" name="phone" id="phone" /><br />

        <span>Gender : </span>
        <label htmlFor="male">Male : </label>
        <input type="radio" name="gender" id="male" />
        <label htmlFor="female">Female : </label>
        <input type="radio" name="gender" id="female" /><br />

        <label htmlFor="address">Address</label>
        <input type="text" name="address" id="address" /><br />

        <label htmlFor="password">Password : </label>
        <input type="password" name="password" id="password" /><br />

        <button type="submit">Submit</button>
        <button type="reset">Reset</button>
    </>
}
export default Register;