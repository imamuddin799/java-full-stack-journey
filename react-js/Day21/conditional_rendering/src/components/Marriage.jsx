import { useState } from "react";

let Marriage = _ => {
    let [isMarried, setIsMarried] = useState(true);

    return<>
        <h1>{isMarried?"You can enjoy": "enjoy in react class"}</h1>
    </>
}
export default Marriage;