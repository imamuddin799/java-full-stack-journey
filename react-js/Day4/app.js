// * Here to import the variables and functions from the demo.js file we are using multiple import statements
// * which is not good practice. Instead we can use a single import statement.

// import { sayHello } from "./demo.js";
// import { isMarried } from "./demo.js";
// import { arr } from "./demo.js";

// sayHello();
// console.log(isMarried);
// console.log(arr);

// * Here we are using a single import statement to import all the variables and functions at once.
// import { sayHello, isMarried, arr } from "./demo.js";
// sayHello();
// console.log(isMarried);
// console.log(arr);

// * We can also use the aliasing feature to rename the imported variables and functions
// * to avoid naming conflicts. Here we are using the aliasing feature to rename the imported variables and functions.
// import { sayHello as hello, isMarried as married, arr as array } from "./demo.js";
// or 

import * as data from "./demo.js";
data.sayHello();
console.log(data.isMarried);
console.log(data.arr);

export function fromapp() {
    console.log("I am coming from app.js file");
}