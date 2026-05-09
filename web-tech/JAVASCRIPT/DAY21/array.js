// literal way

let arr = []
console.log(arr);

// new keyword

let arr1 = new Array()
console.log(arr1);

// constructor

let arr2 = Array()
console.log(arr2);

let a = [10, "hello", NaN, undefined, null, true, false, -5, 5.345, 10]
console.log(a);
console.log(a[5]);
console.log(a.length);

let b = []
console.log(b);

b.push(40, 50, 80, 90, "hi", true)
console.log(b);

b.push(85)
console.log(b);

b.unshift(55, 25)
console.log(b);

b.pop()
console.log(b);

b.pop()
console.log(b);

b.shift()
console.log(b);

b.shift()
console.log(b);

console.log(b.slice(1, 3));
console.log(b[1]);
console.log(b);

b.splice(1, 2, "hello")
console.log(b);

b.splice(2, 1)
console.log(b);

let c = [11, 21, -4, 8, 5, 7, 65]
let w = c.sort((r, q) => {
    return r - q
})

console.log(w);

console.log(c.sort((r, q) => {
    return q - r;
}));

let s = [10, 50, 80, 90]
console.log(s.reverse());
console.log(w.reverse());

let sum = 0
let as = []
for(let i = 0; i < s.length; i++){
    sum += [i]
}
as.push(sum)
console.log(sum);
console.log(as);

// reduce

console.log(s.reduce((acc, value) => {
    return acc + value
}));

// filter

for(let i = 0; i < s.length; i++){
    if(s[i] > 50){
        console.log(s[i]);
    }
}

let d1 = s.filter ((y) => {
    return y > 50
})

console.log(d1);
console.log(s);

//map

let d2 = s.map((t) => {
    return t + 5
})

console.log(d2);

// DAY 22

let arr3 = [10, 20, 30, 40]
console.log(arr3);
for(let i of arr3){
    console.log(i);
}

for(let i in arr3){
    console.log(i);
}

let arr4 = [10, [20, 53], [[30, 40]], [[[[[50, 60, 80]]]]]]
console.log(arr4);
console.log(arr4.flat(1));
console.log(arr4.flat(3));
console.log(arr4.flat(Infinity));

let arr5 = [10, 55, 85, 95, 10, 45, 15, 25]
console.log(arr5);

console.log(arr5.includes(35));
console.log(arr5.includes(-10));
console.log(arr5.includes(25));

console.log(arr5.indexOf(95));
console.log(arr5.indexOf(65));
console.log(arr5.indexOf(10));

console.log(arr5.lastIndexOf(10));

arr5.forEach((v, i) => {
    console.log(v, i);
})

let arr6 = arr5.entries()

for(let i of arr6){
    console.log(i);
}

let arr7 = [50, 80]
let arr8 = [55, 85, 95]
let a5 = arr7.concat(arr8)
let a6 = arr8.concat(arr7)
console.log(arr7);
console.log(a5);
console.log(a6);