import { useState } from "react"

let InputField = () => {

    let [value, setValue] = useState("");

    return <>
        <input type="text" onChange={(e) => setValue(e.target.value)} placeholder="Type here" />
        <p>You typed : {value}</p>
    </>
}
export default InputField;