import { useState } from "react";

let MouseEventsBox = () => {

    let [status, setStatus] = useState("")

    return <>
        <div
            onMouseEnter={() => setStatus("Mouse Entered")}
            onMouseLeave={() => setStatus("Mouse Left")}
            style={{padding: 20, background: "#ddd"}}
        >
            Hover In/Out
            <p>{status}</p>
        </div>
    </>
}
export default MouseEventsBox;