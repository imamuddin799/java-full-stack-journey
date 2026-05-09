let isLoggedIn = true;

const IfElse1 = () => {
    if (isLoggedIn) {
        return <>
            <h1>Welcome back</h1>
        </>
    }
    else {
        return <>
            <h1>Please Log In</h1>
        </>
    }
}
export default IfElse1