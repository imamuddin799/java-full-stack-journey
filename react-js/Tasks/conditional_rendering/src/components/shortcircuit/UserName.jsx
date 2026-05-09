
let UserName = () => {

    let user = {
        name: "John"
    }

    return <p>{user && user.name}</p>
}
export default UserName;