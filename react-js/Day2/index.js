let student = {
    sid: 101,
    sname: "Raj",
    sage: 27,
    skills: ["HTML", "CSS", "JS", "Python", "Django"],
    saddress: {
        street: "Ameerpet",
        city: "Hyderabad"
    }
}

let { sid, sname, sage, skills: [a, b, c, d, e], saddress: { street, city } } = student;
console.log(sid);
console.log(sname);
console.log(sage);
console.log(a);
console.log(b);
console.log(c);
console.log(d);
console.log(e);
console.log(street);
console.log(city);

// ! Mixed destructuring

let mixedData = [
    "Raj",
    26,
    false,
    null,
    undefined,
    ["HTML", "CSS", "JS", "React JS"],
    {
        street: "Ameerpet",
        city: "Hyderabad"
    },
    function () {
        console.log("Hello People");
    }
];

let [name, age, isMarried, kids, future, [skill1, skill2, skill3, skill4], { street: road, city: town }] = mixedData
let [, , , , ,skills, address] = mixedData
console.log(name);
console.log(age);
console.log(isMarried);
console.log(kids);
console.log(future);
console.log(skill1);
console.log(skill2);
console.log(skill3);
console.log(skill4);
console.log(road);
console.log(town);
console.log(skills);
console.log(address);

// ! Rest Parameter : It allows us to pass the indefinite number of arguments and
// ! it is stored in the form of array like object

// * arguments : It is an array like object which stores all the arguments passed to the function.

// function sum(a, b, c) {
//     console.log(a + b + c + arguments[3] + arguments[4] + arguments[5]);
//     console.log(arguments);
//     let sum = 0;
//     for (let i = 0; i < arguments.length; i++){
//         sum += arguments[i];
//     }
//     console.log(sum);
// }
// sum(10, 20, 30, 50, 60, 70);

// ! A rest parameter must be last in a parameter list

// function sum(a, b, c,...args) {
//     console.log(a + b + c + args[0] + args[1] + args[2]);
//     console.log(args);
// }
// sum(10, 20, 30, 50, 60, 70);


// Note : There is no 'arguments' object present in arrow function.
let sum = (a, b, c,...args) => {
    console.log(a + b + c + args[0] + args[1] + args[2]);
    console.log(args);
}
sum(10, 20, 30, 50, 60, 70);


// ! Cases of arrow function:

// ? Case I:
// variable_Declaration variable_Name = () => {
//     console.log("statements");
// }

// todo : example

// let demo ()

// ? Case II : If there is only one statement is there to execute then {} not required

// variable_Declaration variable_Name = () => statement;

// todo : example

// let demo = () => console.log("Hello people");
// demo()

// ? Case III : If there is only one parameter then no need to take the () in arrow function.

// variable_Declaration variable_Name = a => statement;

// todo : example

// let demo = a => console.log(a);
// demo(10)

// ? Case IV : If there is no parameter then you can use _ or $

// variable_Declaration variable_Name = _ => statement;

// todo : example

// let demo = _ => console.log("You can use _ or $");
// demo(10)