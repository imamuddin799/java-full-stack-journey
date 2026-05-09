// ! Spread Operator Examples
// * Example 1:
let arr1 = [1, 2, 3];
let arr2 = [4, 5, 6];
let mergedArr = [...arr1, ...arr2];
console.log(mergedArr);

let obj1 = {
    a: 1,
    b: 2
}
let obj2 = {
    c: 3,
    d: 4
}

let newobj = { ...obj1, ...obj2 }
console.log(newobj);

// * Example 2:
let str = "Imamuddin Ansari"
let name = [...str.toUpperCase()];
console.log(name);

// ! Shallow Copy Examples
// * Example 1:
let nestedObj = {
    a: 1,
    b: {
        c: 2
    }
}
let newObj = {...nestedObj}
console.log(newObj, "shallow copy");

// * Example 2:
let arr = [1, 4, 5];
let newArr = [0, ...arr.splice(0, 1), 2, 3, ...arr.splice(1)]
console.log(newArr);

// ! Deep Copy Example
// * Example 1:
let obj = {
    a: 1,
    b: 2,
    c: {
        d: 3,
        e: 4,
    }
}
let json = JSON.stringify(obj);
console.log(json);
let newObje = JSON.parse(json);
newObje.c.d = 30;
console.log(obj.c.d);
console.log(newObje.c.d);

// * Example 2:
let object1 = {
    objName: "bat",
    color: "yellow",
    weight: "2kg",
}
let newObject = JSON.parse(JSON.stringify(object1));
newObject.weight = "1.5kg";
console.log(object1.weight);
console.log(newObject.weight);



























// Advanced Level Examples of Spread Operator in JavaScript

// 1. Spread operator with arrays - merging and cloning
// const arr1 = [1, 2, 3];
// const arr2 = [4, 5, 6];

// // Merging arrays
// const mergedArr = [...arr1, ...arr2];
// console.log('Merged Array:', mergedArr); // [1, 2, 3, 4, 5, 6]

// // Cloning array (shallow copy)
// const clonedArr = [...arr1];
// console.log('Cloned Array:', clonedArr); // [1, 2, 3]

// // 2. Spread operator with objects - merging and cloning
// const obj1 = { a: 1, b: 2 };
// const obj2 = { b: 3, c: 4 };

// // Merging objects (obj2 properties overwrite obj1 if same keys)
// const mergedObj = { ...obj1, ...obj2 };
// console.log('Merged Object:', mergedObj); // { a: 1, b: 3, c: 4 }

// // Cloning object (shallow copy)
// const clonedObj = { ...obj1 };
// console.log('Cloned Object:', clonedObj); // { a: 1, b: 2 }

// // 3. Spread operator in function calls - passing array elements as arguments
// function sum(x, y, z) {
//     return x + y + z;
// }

// const numbers = [10, 20, 30];
// console.log('Sum:', sum(...numbers)); // 60

// // 4. Using spread operator to convert iterable to array
// const str = "hello";
// const chars = [...str];
// console.log('Characters:', chars); // ['h', 'e', 'l', 'l', 'o']

// // 5. Spread operator with rest parameters in function definitions
// function multiply(multiplier, ...args) {
//     return args.map(num => num * multiplier);
// }

// console.log('Multiply:', multiply(2, 1, 2, 3)); // [2, 4, 6]

// // 6. Spread operator with nested objects (shallow copy limitation)
// const nestedObj = { a: 1, b: { c: 2 } };
// const shallowCopy = { ...nestedObj };
// shallowCopy.b.c = 42;
// console.log('Original nestedObj:', nestedObj.b.c); // 42 (changed due to shallow copy)
// console.log('Shallow copy:', shallowCopy.b.c); // 42

// // 7. Spread operator with arrays inside objects
// const objWithArray = { arr: [1, 2, 3] };
// const copyObjWithArray = { ...objWithArray, arr: [...objWithArray.arr] };
// copyObjWithArray.arr.push(4);
// console.log('Original object array:', objWithArray.arr); // [1, 2, 3]
// console.log('Copied object array:', copyObjWithArray.arr); // [1, 2, 3, 4]

// // 8. Using spread operator to add elements in the middle of an array
// const baseArr = [1, 4, 5];
// const newArr = [0, ...baseArr.slice(0, 1), 2, 3, ...baseArr.slice(1)];
// console.log('New Array:', newArr); // [0, 1, 2, 3, 4, 5]

// // 9. Spread operator with Sets and Maps
// const set = new Set([1, 2, 3]);
// const arrFromSet = [...set];
// console.log('Array from Set:', arrFromSet); // [1, 2, 3]

// const map = new Map([['a', 1], ['b', 2]]);
// const arrFromMap = [...map];
// console.log('Array from Map:', arrFromMap); // [['a', 1], ['b', 2]]

// // 10. Spread operator to create a new Date from arguments array
// const dateArgs = [2024, 5, 15];
// const date = new Date(...dateArgs);
// console.log('Date:', date.toDateString());

// 11. Spread operator with React props (example)
// const defaultProps = { color: 'blue', size: 'medium' };
// const customProps = { size: 'large', disabled: true };
// const combinedProps = { ...defaultProps, ...customProps };
// console.log('Combined Props:', combinedProps);