import { useState } from "react";
import CardChild from "./CardChild";
import jsondata from "./cources.json"
import ListChild from "./ListChild";
let Card = () => {

    let [listToggle, setListToggle] = useState("card");

    let btnToggle = {
        backgroundColor: "#892380",
        color: "white",
        fontWeight: "bolder",
        padding: "5px",
        borderRadius: "4px"
    }

    let handleToggel = () =>{
        listToggle == "card" ? setListToggle("list") : setListToggle("card");
    }
    return <>
        <button style={btnToggle} onClick={handleToggel}>Toggle{listToggle == "card" ? "List" : "Card"}</button>
        {listToggle == "card" && (<div style={{ display: "flex", flexWrap: "wrap", gap: "20px", justifyContent: "center" }}>
            <CardChild data={jsondata} />
        </div>)}
        {listToggle == "list" && (<ListChild data={jsondata} />)}
    </>
}
export default Card;