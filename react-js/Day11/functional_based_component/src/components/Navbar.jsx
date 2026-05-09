
// ! Don't create nav with fixed values instead use array and map method to display dynamicaly

// let Navbar = () => {
//     return <>
//         <section>
//             <nav>
//                 <ul>
//                     <li><a href="">Home</a></li>
//                     <li><a href="">About Us</a></li>
//                     <li><a href="">Contect Us</a></li>
//                     <li><a href="">Login</a></li>
//                     <li><a href="">Register</a></li>
//                     <li><a href="">Help</a></li>
//                 </ul>
//             </nav>
//         </section>
//     </>
// }
// export default Navbar;

import { Fragment } from "react";

let Navbar = () => {
    let links = ["Home", "About Us", "Contact Us", "Login", "Register", "Help"];
    return <>
        <section>
            <nav>
                <ul>
                    {
                        links.map((element, index) => {
                            return <Fragment key={ index }>
                                <li><a href="">{element}</a></li>
                            </Fragment>
                        })
                    }
                </ul>
            </nav>
        </section>
    </>
}
export default Navbar;