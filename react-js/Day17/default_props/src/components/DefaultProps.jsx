
let DefaultProps = (props) => {

    let { ename, esalary } = props;
    return <>
        <h1>Default Props</h1>
        <h1>{ename || "Anonymous"}</h1>
        <h1>{esalary || 70000}</h1>
    </>
}
export default DefaultProps;