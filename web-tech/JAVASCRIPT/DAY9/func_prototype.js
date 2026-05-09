function demo(){
    console.log("Hi demo func");
}
demo()

function demo1() {
    console.log("Hi");
}
demo1()

console.log("prototype" in demo);

let a = new demo()

console.log(Object.getPrototypeOf(a)==demo.prototype);

let b = new demo1

console.log(Object.getPrototypeOf(b)==demo.prototype);

// Generator function
function *demo2(){
    yield "hello"
    yield "hi"
    yield "bye"
}
// console.log(demo2());
let d = demo2();
console.log(d);
console.log(d.next().value);
console.log(d.next().value);
console.log(d.next().value);
console.log(d.next().value);

function *demo3(){
    console.log("hi js");
    yield "hi javascript"
    console.log("bye");
}
let k = demo3()
console.log(k.next().value);
k.next().value

console.log("prototype" in demo3);

function *demo4() {
    console.log(arguments);
    console.log(arguments[0]);
    console.log(arguments[2]);
}
let r = demo4(10,20,30)
r.next().value

var q = 105
let e = d1()
e.next().value;
function *d1(){
    var q = 40
    console.log(q);
    console.log(window.q);
    console.log(this.q);
    console.log("hi hoisting");
}

// let w = new d1();   //error
// console.log(Object.getPrototypeOf(w)==d1.prototype); //error