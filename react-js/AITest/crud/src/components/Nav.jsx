 
let Nav = (props) => {

    let [toggle, setToggle] = props.data

    let handleToggleClick = () => {
        toggle == "list" ? setToggle("card") : setToggle("list");
    }
    return <>
        <div id="navbar">
            <h1>Student Management System</h1>
            <button id="toggleList" onClick={handleToggleClick}>ToggleList</button>
        </div>
    </>
}
export default Nav;