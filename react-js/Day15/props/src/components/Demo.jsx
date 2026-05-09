import Test from "./Test"

let Demo = () => {
    let user = {
        username: "Vishal",
        uage: 30,
        contact: 9874382992
    }
    return <>
        <Test fname="Raj" age={30} isMarried={false} data={user} />
    </>
}
export default Demo;