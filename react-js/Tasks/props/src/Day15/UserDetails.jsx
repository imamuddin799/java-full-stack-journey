
let UserDetails = (props) => {

    let capitalize = (name) => {
        let arrName = name.includes(" ") ? name.split(" ") : name.split("_");
        let capitalizedName = arrName.map((word) => {
            return word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
        });
        return capitalizedName.join(" ");
    };

    let { username, age } = props.data;
    
    return <>
        <h1>Hello {capitalize(username)}, Your age is {age}</h1>
    </>
}
export default UserDetails;