import ComponentC from "./ComponentC";

let ComponentB = (props) => {

    let { gold } = props;
    return <>
        <h1>ComponentB</h1>
        <ComponentC gold={gold} />
    </>
}
export default ComponentB;