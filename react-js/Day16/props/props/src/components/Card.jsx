import { useState } from "react"
import jsondata from "./MOCK_DATA.json"
import CardDetails from "./CardDetails"
function Card() {
    let [userData, setUserData] = useState(jsondata)
    return <>
        <div className="d1" >
            <div className="child">
                <CardDetails data={userData} />
            </div>
        </div>
    </>
}
export default Card;