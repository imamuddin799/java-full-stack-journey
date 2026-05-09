import ComponentD from "./ComponentD";

let ComponentC = (props) => {

    let { gold } = props;
    return <>
        <h1>ComponentC</h1>
        <ComponentD gold={gold} />
    </>
}
export default ComponentC;