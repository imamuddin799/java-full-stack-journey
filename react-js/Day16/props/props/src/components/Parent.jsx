import Child from "./Child";

let Parent = () => {

    let skills = ["HTML", "CSS", "JS", "BOOTSTRAP", "TAILWIND"]
    return <>
        <Child data={skills} />
    </>
}
export default Parent;