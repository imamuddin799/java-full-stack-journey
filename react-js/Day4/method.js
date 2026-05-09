let user = {
    userName: "Raj",
    age: 30,
    sayHello: function () {
        console.log("Hello "+ this.userName);
    },
    sayBye() {
        console.log("Bye....👋👋👋👋👋");
    }
}

user.sayHello();
user.sayBye();
// ! The 'this' keyword refers to the object that is calling the method. In this case, it refers to the user object.


// ! Clousere
function outer() {
    let a = 10;
    function inner() {
        console.log(a);
    }
    return inner;
}
let innerFunc = outer();
innerFunc(); // 10 
// ! innerFunc is a closure that has access to the variables of outer function even after outer function has executed.
// ! Closure is a function that has access to the outer function's scope even after the outer function has returned.
// ! Closure is a powerful feature of JavaScript that allows you to create private variables and functions.
// ! It is used in many libraries and frameworks to create encapsulated code.
// ! It is also used in event handlers, callbacks, and asynchronous programming.