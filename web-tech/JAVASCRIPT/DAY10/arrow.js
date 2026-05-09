let a = ()=>{
    console.log("hi");
}

a()
a()

// implicit arrow function
let b = ()=>console.log("hello");
b()
b()

// Explicit arrow function
let c = ()=>{
    console.log("hi arrow1");
    return "hi arrow"
}
console.log(c());
console.log(c());

let r = (s,d)=>{
    console.log("hi arguments");
    // console.log(arguments);
    console.log(s,d);
}
r(10,20,30)

console.log("prototype" in r);

// let l = new r()
// console.log(Object.getPrototypeOf(l)==r.prototype);
// g() //hoisting is not possible

var w = 25

let g=()=>{
    var w = 85
    console.log(w);
    console.log(this.w);
    console.log(window.w);
    console.log("hi hoisting");
}
g()