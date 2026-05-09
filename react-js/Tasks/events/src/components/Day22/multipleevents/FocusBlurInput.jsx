import { useState } from "react"

let FocusBlurInput = () => {

    let [status, setStatus] = useState("")

    return <>
        <input
            onFocus={() => setStatus("Input focused")}
            onBlur={() => setStatus("Input blurred")}
            placeholder="Focus me"
        />
        <p>{status}</p>
    </>
}
export default FocusBlurInput;