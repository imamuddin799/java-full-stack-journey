import { Fragment } from "react";

function CardDetails(props) {
    return <>
        {
            props.data.map((object, index) => {
                let { first_name, last_name, email, gender, contact, age } = object;
                return <Fragment key={index}>
                    <section style={{background: "lightgreen", height: "auto", width: "400px", border: "2px solid" }}>
                        <h1 style={{borderBottom: "1px solid #888", paddingBottom:"5px"}}>{first_name}</h1>
                        <h1 style={{borderBottom: "1px solid #888", paddingBottom:"5px"}}>{last_name}</h1>
                        <h1 style={{borderBottom: "1px solid #888", paddingBottom:"5px"}}>{email}</h1>
                        <h1 style={{borderBottom: "1px solid #888", paddingBottom:"5px"}}>{gender}</h1>
                        <h1 style={{borderBottom: "1px solid #888", paddingBottom:"5px"}}>{contact}</h1>
                        <h1 style={{borderBottom: "1px solid #888", paddingBottom:"5px"}}>{age}</h1>
                    </section>
                </Fragment>
            })
        }
    </>
}
export default CardDetails;