// array destructuring
let arr = [10, 20, 30]

let [a, b, c] = arr
console.log(a);
console.log(b);
console.log(c);

// -------------------

console.log(arr);

let arr2 = [10, 20, 30]
let [a2, b2] = arr2
console.log(a2);
console.log(b2);
let [c2] = arr2
console.log(c2);

// ----------------------

// object destructuring

let obj = {
    name1 : "abc",
    id : 123,
    role : "web"
}
console.log(obj);
console.log(obj.name1);

let {name1, id, role} = obj;
console.log(name1);
console.log(id);
console.log(role);

//rest parameter and spread parameter

let arr4 = [10, 20, 30]
let arr5 = [50, 80]

// spread parameter

console.log(...arr4);
console.log(...arr5);

let arr6 = [...arr4, ...arr5]
console.log(arr6);

// rest parameter

function d1(q, ...w){
    console.log(q);
    console.log(w);
    console.log(...w);
}
d1(50, 80, 90, 40, 70)