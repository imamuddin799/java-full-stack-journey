// a() hoisting is not possible
console.log(a);
var f = 10
var a = function (w,q){
    var f = 50
    console.log("hi");
    console.log(f);
    console.log(this.f);
    console.log(window.f);
    console.log(w,q);
    console.log(arguments[2]);
    return "hello"
}
a()
console.log(a);
console.log(a(55,25,45));
console.log("prototype" in a);

let r = new a()
console.log(Object.getPrototypeOf(r)==a.prototype);

let o = function *(){
    yield "hi generator function"
    yield "by generator function"
}
let g = o()
console.log(g.next().value);
console.log(g.next().value);