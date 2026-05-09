let obj = {}
console.log(obj);

let obj1 = {
    name : "abc",
    id : 123,
    role : "web"
}

console.log(obj1);
console.log(obj1.name);

// new

let obj2 = new Object()
console.log(obj2);
obj2.phone = 1234567890
console.log(obj2);

// constructor

let obj3 = Object()
console.log(obj3);

// functional constructor way

function demo(a, b){
    this.a = a
    this.b = b
}
let obj4 = new demo(10, "abc")
console.log(obj4);

let obj5 = {
    name : "xyz",
    role : "dabba developer",
    id : 258
}
console.log(obj5);

// new key and value insertion

obj5.address = "hyd"
console.log(obj5);

// updation

obj5.name = "pqr"
console.log(obj5);

// delete

delete obj5.role
console.log(obj5);

// key and values and entries methods

let k = Object.keys(obj5)
console.log(k);

let v = Object.values(obj5)
console.log(v);

console.log("Entries");
let q = Object.entries(obj5)
for(let i of q){
    console.log(i);
}

let obj6 = {
    name : "qweer",
    id : 456,
    role : "asdfg"
}
console.log(obj6);

Object.seal(obj6)
console.log(Object.isSealed(obj6));
// Even after seal we can update exixting porperties but we can not add new properties
// updation p k and v

obj6.name = "rajkumar"
console.log(obj6);

// not possible to update a new k and v pair
obj6.age = 52
console.log(obj6);

Object.freeze(obj6)
console.log(Object.isFrozen(obj6));
// After freeze we can  neither update existing properties nor add new properties
//not possible to update p k and v

obj6.name = "rani"
console.log(obj6);

// not possible to update a new k and v

obj6.age = 52
console.log(obj6);

let obj7 = {
    id : 741,
    role : "sdfkjsklfd"
}
console.log(obj7);

let obj8 = {
    name : "qwerrr"
}
console.log(obj8);
let o = Object.assign(obj8, obj7)
console.log(o);
let p = Object.assign(obj7, obj8)
console.log(p);