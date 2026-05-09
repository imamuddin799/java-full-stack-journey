
let ShirtSize = () => {

    let size = "S";

    switch (size) {
        case "S":
            return <p>Small</p>;
        case "M":
            return <p>Medium</p>;
        case "L":
            return <p>Large</p>;
        default:
            return <p>Unknown Size</p>;
    }
}
export default ShirtSize;