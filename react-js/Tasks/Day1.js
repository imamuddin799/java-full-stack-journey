// ! Example 1: Destructuring an object
const user = {
    name: "Amir",
    address: {
        city: "New York",
        country: "USA"
    }
};

let { name, address: { city, country } } = user
console.log(name); // Amir
console.log(city); // New York
console.log(country); // "USA"

// ! Example 2: Destructuring an object
let employee = {
    empName: "Alice",
    empAge: 30,
    position: "Software Engineer",
};

let { enpName: fullName, empAge: age, position: role } = employee;
console.log(fullName);
console.log(age);
console.log(role);

// ! Example 3: Destructuring an object
let book = {
    title: "JavaScript Mastery",
    author: "John Smith",
    year: 2024,
    publisher: "TechBooks",
    pages: 450,
};

let { title, author, year, publisher, pages } = book;
console.log(title);
console.log(author);
console.log(year);
console.log(publisher);
console.log(pages);

// ! Example 1: Destructuring an array
let fruits = ["apple", "banana", "cherry", "date"];
let [firstFruit, secondFruit, thirdFruit, fourthFruit] = fruits;
console.log(firstFruit);
console.log(secondFruit);
console.log(thirdFruit);
console.log(fourthFruit);

// ! Example 2: Destructuring an array
let numbers = [1, 2, 3, 4, 5, { a: 6, b: 7 }, function () { return 8; }];
let [num1, num2, num3, num4, num5, obj, func] = numbers
console.log(num1);
console.log(num2);
console.log(num3);
console.log(num4);
console.log(num5);
console.log(obj.a);
console.log(obj.b);
console.log(func()); // calling the function

// ! Example 3: Destructuring an array
let colors = ["red", "green", "blue", "yellow"];
let [color1, color2, color3, color4] = colors
console.log(color1); // red
console.log(color2); // green
console.log(color3); // blue
console.log(color4); // yellow

// ! Example 4: Destructuring an array
let mixedArray = [1, "hello", true, null, { key: "value" }, [1, 2, 3]];
let [num, str, bool, nil, obj2, arr] = mixedArray;
console.log(num); // 1
console.log(str); // "hello"
console.log(bool); // true
console.log(nil); // null
console.log(obj2.key); // "value"
console.log(arr[0]); // 1
console.log(arr[1]); // 2
console.log(arr[2]); // 3
console.log(arr.length); // 3