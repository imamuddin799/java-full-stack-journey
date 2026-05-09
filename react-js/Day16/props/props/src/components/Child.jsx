import { Fragment } from "react";

let Child = (props) => {

    return <>
        <ol type="I">
            {
                props.data.map((element, index) => {
                    return <Fragment key={index}>
                        <li>{element}</li>
                    </Fragment>
                })
            }
        </ol>
    </>
}
export default Child;