// ! Global scope: The variables and functions declared in the global scope are accessible from anywhere in the code.
var a = 10; // ! Global scope
console.log(window);
{
    var c = 30; // ! Global scope
}
console.log(c);
console.log(window);
function demo() {
    var d = 40; // ! Function/Local scope
    console.log(d);
}
demo();
// console.log(d); // ! ReferenceError: d is not defined
console.log(window);

// debugger; // ! Debugger: The debugger statement is used to pause the execution of the code and inspect the variables and functions at that point in time.
// ! Function scope: The variables and functions declared in the function scope are accessible only within the function.
// ! Block scope: The variables and functions declared in the block scope are accessible only within the block.
let age = 30; // ! Script scope
console.log(window);
{
    let b = 20; // ! Block scope
    console.log(b);
}
console.log(window);
function demo1() {
    let e = 50; // ! Function/Local scope
    console.log(e);
}
console.log(window);