console.log(a);
var a = 10;
console.log(a);

// console.log(b);
let b = 20;
console.log(b);

// console.log(c);
const c = 30;
console.log(c);
console.log(window);

// implicit typecasting
let s = 20, f= "50"
console.log(s);
console.log(f);
console.log(s+f);
console.log(s-f);
console.log(s*f);
console.log(f/s);
console.log(f%s);
console.log(2**4);
console.log(2*true);
console.log(2*false);

// explicit typecasting
let r = 50, y = "85"
console.log(r+y);
console.log(r + Number(y));
console.log(Boolean(r) + Boolean(y));
console.log(String(r));
console.log(typeof r);
console.log(typeof String(r));


let k = 10*"5"+8+true+false-"10"
console.log(k);