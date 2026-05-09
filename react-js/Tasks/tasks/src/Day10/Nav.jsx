import { Component, Fragment } from "react";

class Nav extends Component {
    render() {
        let nav = ["Home", "About Us", "Contact Us", "Login", "Register"];
        return <>
            <h1>Nav Using Class</h1>
            <ul>
                {
                    nav.map((element, index) => {
                        return <Fragment key={index}>
                            <li><a href="">{ element }</a></li>
                        </Fragment>
                    })
                }
            </ul>
        </>
    }
}
export default Nav;