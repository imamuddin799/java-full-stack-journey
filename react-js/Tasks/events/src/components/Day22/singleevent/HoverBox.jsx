import { useState } from "react"

let HoverBox = () => {

    let [message, setMassage] = useState("");

    return <>
        <div
            onMouseOver={() => setMassage("Mouse is over the the box!")}
            style={{padding: 20, background: "#ddd"}}
        >
            Hover over me
            <p>{message}</p>
        </div>
    </>
}
export default HoverBox;