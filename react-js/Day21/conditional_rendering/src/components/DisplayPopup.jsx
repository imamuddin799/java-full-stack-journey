import { useState } from "react"

let DisplayPopup = _ => {
    let [popup, setPopup] = useState(true);

    let togglePopup = () => {
        setPopup(!popup);
    }

    return <>
        <button onClick={togglePopup}>Display Popup</button>
        {
            popup && (
                <dialog open>
                    <h1>Popup opened</h1>
                    <button onClick={togglePopup}>close popup</button>
                </dialog>
            )
        }
    </>
}
export default DisplayPopup;