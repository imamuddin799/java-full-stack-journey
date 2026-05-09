import { Fragment } from "react";

let CardChild = (props) => {

    const headingStyle = {
        overflow: "hidden",
        display: "-webkit-box",
        WebkitLineClamp: 2,          // Limits the heading to 2 lines
        WebkitBoxOrient: "vertical", // Sets the box orientation to vertical
        wordBreak: "break-word",     // Optional: improves word wrapping
    };

    // console.log(props.data);

    return <>
        {
            // props.data.map((object, index) => (

            //     <div key={index}>
            //         <img src={object.imageUrl} alt="img" />
            //         <h1>{object.title}</h1>

            //     </div>
            // ))

            props.data.map((object, index) => {
                let { imageUrl, title, description, interested } = object;
                return <Fragment key={index}>
                    <section style={{ width: "300px", borderRadius: "10px", border: "1px solid #9999" }}>
                        <img src={imageUrl} alt="" style={{ width: "100%", objectFit: "cover", borderTopLeftRadius: "10px", borderTopRightRadius: "10px" }} />
                        <div style={{ padding: "0px", margin:"6px"}}>
                            <h2 style={headingStyle}>{title}</h2>
                            <p style={{ fontSize: "15px" }}>{description}</p>
                            <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center" }}>
                                <p style={{ fontSize: "15px", fontWeight: "lighter" }}>{interested}</p>
                                <button style={{ height: "max-content", padding: "5px 10px", backgroundColor: "#358860", color: "white", fontWeight: "bolder", borderRadius: "5px" }}>Explore</button>
                            </div>
                        </div>
                    </section>
                </Fragment>
            })
        }
    </>
}
export default CardChild;