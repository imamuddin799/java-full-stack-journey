// ! Named Module: Whenever we are exporting the piece of code with the help of
// ! name then it is called as named module.

// * Here we are using multiple export statements to export multiple variables and functions
// * which is not good practice. Instead we can use a single export statement
// * to export all the variables and functions at once.
// export function sayHello() {
//     console.log("Hello People");
// }

// export var isMarried = false;

// export let arr = [10, 20, 30, 40, 50];


function sayHello() {
    console.log("Hello People");
}

var isMarried = false;

let arr = [10, 20, 30, 40, 50];

// * Here we are using a single export statement to export all 
// * the variables and functions at once.
export { sayHello, isMarried, arr };

import { fromapp } from "./app.js";
fromapp();