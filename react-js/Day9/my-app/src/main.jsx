import { createElement } from "react";
import { createRoot } from "react-dom/client";

// ? createElement("tagName", {}, content/children);
let heading = createElement("h1", null, "Hello World!");
let para = createElement("p", { id: "para" }, "so busy peopleare present in this class");
let parent = createElement("div", { id: "parent" }, [heading, para]);
let root = document.getElementById("root");
// createRoot(root).render(parent);

// ! JSX
// ! JSX stands for JavaScript extension.
// ! JSX allows us to write HTML code inside JavaScript.
// ! JSX is a template language.
// ! It looks like HTML but is not HTML.

// createRoot(root).render(
//     <div>
//         <h1>Hello World!</h1>
//         <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
//     </div>
// )

// ! Rules of the JSX Elements:
// ! 1. Always same level elements wrapped inside the parent element.
// ! 2. JSX elements should be in the lowercase.
// ! 3. Always JSX elements should be closed with "/" (forward slash) either a self-closing tag or a closing tag
// ! 4. Instead of class we should use className and instead of for we should use htmlFor
// ! 5. Always attribute name should be in camelCase convention

// createRoot(root).render(
//     <div>
//         <h1 className="box">Hello world</h1>
//         {/* <H1>This is not valid</H1>*/}  {/* //! Always JSX elements must be lowercase */}
//         <p>This is a valid paragraph element.</p>
//         <label htmlFor="inp">First Name</label>
//         <input type="text" name="" id="inp" />
//     </div>
// );

import { Fragment } from "react";

// ! Fragment:
// ? 1. It is a component.
// ? 2. It is present inside the react.
// ? 3. It is used to avoid the extra node inside the dom.
// ? 4. In the Fragment we can use only one attribute i.e., key

// createRoot(root).render(
//     <Fragment>
//         <h1 className="box">Hello world</h1>
//         <p>This is a valid paragraph element.</p>
//         <label htmlFor="inp">First Name</label>
//         <input type="text" name="" id="inp" />
//     </Fragment>
// );

// ! Empty Fragment: <> </>
// ? We cannot use the key attribute inside the empty Fragment

// createRoot(root).render(
//     <>
//         <h1 className="box">Hello world</h1>
//         <p>This is a valid paragraph element.</p>
//         <label htmlFor="inp">First Name</label>
//         <input type="text" name="" id="inp" />
//     </>
// );

// ! JSX Expression
// ? 1. Whenever we are defining the {} braces inside the JSX elements then it is called as JSX expression.
// ? 2. JSX Expression is used to display the dynamic values or you can perform operations to render dynamic content within the JSX elements.

let fname = "John Doe"
createRoot(root).render(
    <>
        <div>
            fname : {fname} { 10 + 35 }
        </div>
    </>
);