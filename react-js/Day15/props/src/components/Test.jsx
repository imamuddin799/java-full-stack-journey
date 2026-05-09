
let Test = (props) => {

    console.log(props);
    console.log("hi");
    let {fname, age, isMarried, data:{username, uage, contact}} = props
    return <>
        {/* <h1>{props.fname}</h1> */}
        <h1>Test</h1>
        <h1>{fname}</h1>
        <h1>{age}</h1>
        <h1>{isMarried ? "Married" : "Unmarried"}</h1>
        <h1>{username}</h1>
        <h1>{uage}</h1>
        <h1>{contact}</h1>
    </>
}
export default Test;