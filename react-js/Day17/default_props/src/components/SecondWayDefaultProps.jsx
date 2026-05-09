
let SecondWayDefaultProps = (props) => {

    let { ename = "Anonymous Employee", esalary = "50000" } = props;
    return <>
        <h1>{ename}</h1>
        <h1>{esalary}</h1>
    </>
}
export default SecondWayDefaultProps;