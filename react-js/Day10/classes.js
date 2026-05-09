// ! Class : It is a blueprint for creating the object.
// ? systax:
// class ClassName{
//      members of the class
// }

class React{
    no_of_star_candidates

    // ! It is used to initialize the non-static properties
    constructor(name, age, candidates) {
        this.name = name;
        this.age = age;
        this.no_of_star_candidates = candidates;
    }
    no_of_students = 104;
    static no_of_chairs = 105;

    reactClassInfo() {
        console.log(this.no_of_students);
        // console.log(this.no_of_chairs); // ! here we cannot call static members with 'this' keyword
        console.log(React.no_of_chairs);
    }

    static classtime() {
        console.log("8:30am If you late you have to give the intro");
    }
}

// ! non-static members ===> To call we use object reference variable

let react1 = new React("Raj", 30);
console.log(react1.no_of_students);
console.log(react1.name);
console.log(react1.age);

react1.reactClassInfo();

// ! static members ===> To call we use ClassName
console.log(React.no_of_chairs);
React.classtime();

// * Experiment
console.log(react1.no_of_students); // 104
console.log(react1.no_of_chairs); // undefined
console.log(React.no_of_students); // undefined
console.log(React.no_of_chairs); // 105
console.log(window);