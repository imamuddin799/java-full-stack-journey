
let UserRole = () => {

    let role = "admin";

    switch (role) {
        case "admin":
            return <p>Full Access</p>;
        case "editor":
            return <p>Edit Access</p>;
        case "viewer":
            return <p>No Access</p>;
        default:
            return <p>No Access</p>
    }
}
export default UserRole;