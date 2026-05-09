// let user = {
//     userName: "Raj",
//     age: 30,
//     isMarried : false
// }

// ! Object destructuring : Extracting the values of an object with the help of key of an object

// ! var_declaration { } = objectname;

// let { userName, age, isMarried } = user
// console.log(userName);
// console.log(isMarried);
// console.log(age);

// let user = {
//     userName: "Raj",
//     age: 30,
//     isMarried: false,
//     address: {
//         street: "Ameerpet",
//         city : "Hyderabad"
//     }
// }

// let { userName, age, isMarried, address: { street, city } } = user;
// console.log(userName);
// console.log(age);
// console.log(isMarried);
// console.log(street);
// console.log(city);

// let user = {
//     userName: "Raj",
//     age: 30,
//     isMarried: false,
//     address: {
//         street: "Ameerpet",
//         city : "Hyderabad"
//     }
// }

// let { userName, age, isMarried, address } = user;
// let { street, city } = address;
// console.log(userName);
// console.log(age);
// console.log(isMarried);
// console.log(street);
// console.log(city);


// ! with alias name
let user = {
    name: "Raj",
    age: 30,
    isMarried: false,
    address: {
        name : "Raj S.B",
        street: "Ameerpet",
        city : "Hyderabad"
    }
}

let { name, age, isMarried, address: { name: fullName, street, city } } = user;
console.log(name);
console.log(age);
console.log(isMarried);
console.log(fullName);
console.log(street);
console.log(city);

// ! Array destructuring : Extracting the values/element of an array with the help of distinct variables.

// let arr = [10, 20, 30, 40, 50];
// let [a, b, c, d, e] = arr;
// console.log(a);
// console.log(b);
// console.log(c);
// console.log(d);
// console.log(e);

let arr = [10, 20, 30, 40];
let arr1 = [100, 200, 300, 400];

let [a, b, c, d] = arr;
// ? let [a, b, c, d] = arr  // we can't destructure with same variables again
let [e, f, g, h] = arr1;