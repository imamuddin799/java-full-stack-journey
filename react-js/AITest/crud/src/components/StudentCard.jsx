import { Fragment } from "react";
import Card from "./Card";

let StudentCard = (props) => {

    let [jsonobj, setJsonobj] = props.data;
    let [,, selectedStudent, setSelectedStudent, selectedToDelete, setSelectedToDelete] = props.data

    return <>
        <div className="cards">
            {
                jsonobj.map((object, index) => {
                    return <Fragment key={index}>
                        <Card details={object} data={[jsonobj, setJsonobj, selectedStudent, setSelectedStudent, selectedToDelete, setSelectedToDelete]} />
                    </Fragment>
                })
            }
        </div>
    </>
}
export default StudentCard;