// ! Spread Operator: It spreads the values from an array or object
// import { sayHello } from "Day4\demo";
// ? Syntax: ...arrayName/objectName
// ? you can use spread anywhere

// todo example:
let arr = [10, 20, 30, 40, 50, 60];
console.log(...arr);


// ! copying an array into another array using spread operator
let arr1 = [10, 20, 30, 40, 50];
console.log(arr1, "arr1");

// let newArr = [...arr1]; //! shaallow copy
//let newArr = arr1; //! reference copy
let newArr = [ 60, 70,,...arr1, 80, 90];
console.log(newArr, "newArr");

// ! Merging the multiple arrays into single array using spread operator
let cars = ["Rolls Royce", "BMW", "Nano", "Alto"];
let players = ["Rohit Sharma", "Virat Kohli", "MS Dhoni", "Raina", "Yuvraj Singh"];
let mergedArray = [...cars, ...players];
console.log(mergedArray);

// ! Adding the new elements with previous elements of an array.

let arr2 = ["HTML", "CSS", "JavaScript"];
let newArr2 = [...arr2, "ReactJS"];
arr2.push(...newArr2);
console.log(arr2);
console.log(newArr2);

// ! Copying an object into another object using spread operator
// ? shallow copy of object
let employee = {
    eId: 101,
    eName: "Shubhlakshmi",
    eSalary: 57000,
    isMarried: false
}
let newObj = { ...employee };
console.log(newObj, "newObj"); // shallow copy

// ! Copying multiple objects into single object using spread operator
let movie = {
    movieName: "Pushpa 2",
    diractor: "Sukumar",
    musicdirector: "Devi Sri Prasad",
    actors: ["Allu Arjun", "Rashmika Mandanna", "Fahadh Faasil", "Jagapathi Babu"],
}
let movie2 = {
    movieName: "KGF",
    diractor: "Prashanth Neel",
    musicdirector: "Ravi Basrur",
    actors: ["Yash", "Srinidhi Shetty", "Raveena Tondon"],
}
let newObje = { ...movie, ...movie2 };
// ! If the keys are same then latest values will be considered in object
console.log(newObje);


// ? Shallow copy of an object:
// ! If you are coping one object into another object and updating
// ! the top level properties then it wont affect the original object
// ! and updating the nested object properties will affect on original object.

let user = {
    userName: "Raj",
    age: 30,
    address: {
        street: "Karve Nagar",
        city: "Pune",
    }
}
console.log(user, "user");
let shallowCopy = { ...user };
console.log(shallowCopy, "shallowCopy");
shallowCopy.userName = "Raj Kumar"; // ! It won't affect on original object
shallowCopy.address.street = "Kothrud"; // ! It will affect on original object
// ! If you want to copy nested object then you have to use JSON.parse(JSON.stringify(obj))
console.log(user);
console.log(shallowCopy, "shallowCopy after updating userName and address street");


// ! Deep copy of an object:
// ? If you are coping one object into another object and updating the top level
// ? properties and nested properties then it won't affect the original object.
// ? If you want to copy nested object then you have to use JSON.parse(JSON.stringify(obj)) 
let user1 = {
    userName: "Raj",
    age: 30,
    address: {
        street: "Karve Nagar",
        city: "Pune",
    }
}
console.log(user1, "user1");
let jsonObject = JSON.stringify(user1); // ! It will convert the object into string
console.log(jsonObject, "jsonObject"); // ! It will convert the object into the json object
let deepCopy = JSON.parse(jsonObject); // ! then convert into the normal object
console.log(deepCopy, "deepCopy");

deepCopy.userName = "Raj Kumar"; // ! It won't affect on original object
deepCopy.address.street = "Kothrud"; // ! It won't affect on original object
console.log(user1, "user1 after updating userName");
console.log(deepCopy, "deepCopy after updating userName");

let func = {
    "sayHi": function () {
        console.log("Hello");
    },
    "ud" : undefined
}

func.sayHi();
console.log(func.ud);