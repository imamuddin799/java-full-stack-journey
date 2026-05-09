import { useState } from "react"

let SecondMarriage = _ => {
    let [isMarried, setIsMarried] = useState(true);

    return <>
        {
            isMarried && <h1>You can enjoy marriage</h1>
        }
    </>
}
export default SecondMarriage;