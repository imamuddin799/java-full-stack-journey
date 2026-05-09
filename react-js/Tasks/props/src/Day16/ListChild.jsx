import { Fragment } from "react";

let ListChild = (props) => {
    
    let toggleBackground = (number) => {
        return number % 2 == 0 ? "#555555" : "#aaccee"
    }
    let toggleColor = (number) => {
        return number % 2 == 0 ? "#ffffff" : "#000000"
    }
    return <>
        <table style={{width: "100%", backgroundColor:"#92f906"}}>
            <thead style={{ width: "100%", backgroundColor: "#126706", color:"white", fontWeight:"bolder" }}>
                <tr>
                    <th>Image Url</th>
                    <th>Heading</th>
                    <th>Description</th>
                    <th>Intrested People</th>
                </tr>
            </thead>
            <tbody>
                {
                    props.data.map((object, index) => {
                        let { imageUrl, title, description, interested } = object;
                        return <Fragment key={index}>
                            {
                                // <tr style={{ width: "100%", backgroundColor: toggleBackground(index), color: toggleColor(index), fontWeight: "bolder" }}>
                                <tr style={{ width: "100%", minHeight: "290px", height:"100px", background: `url(${imageUrl})`, backgroundRepeat: "no-repeat", backgroundSize: "100% 150%", color: toggleColor(index), fontWeight: "bolder" }}>
                                    <td style={{padding:"7px"}}>{imageUrl}</td>
                                    <td style={{padding:"7px"}}>{title}</td>
                                    <td style={{padding:"7px"}}>{description}</td>
                                    <td style={{padding:"7px"}}>{interested}</td>
                                </tr>
                            }
                        </Fragment>
                    })
                }
            </tbody>
        </table>
    </>
}
export default ListChild;