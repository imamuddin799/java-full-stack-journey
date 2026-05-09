import { useState } from "react"

let WelcomeMessage = () => {
    let [isLoggedIn] = useState(true);
    if (isLoggedIn) {
        return <h1>Welcome Back!</h1>
    }
    else {
        return <h1>Please Log In</h1>
    }
}
export default WelcomeMessage;