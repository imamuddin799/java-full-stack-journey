
let ComponentF = (props) => {
    console.log(props);
    return <>
        {/* <h1>{props.children}</h1> */}
        {
            props.children
        }
    </>
}
export default ComponentF;