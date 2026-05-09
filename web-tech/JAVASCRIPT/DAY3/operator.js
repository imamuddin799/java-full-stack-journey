// arithmetic operator

let a = 10, b = 20
console.log(a+b);//30
console.log(b-a);//10
console.log(a*b);//200
console.log(b%a);//0
console.log(b/a);//2
console.log(a++);//10
console.log(a);//11
console.log(++a);//12
console.log(--a);//11
console.log(a--);//11
console.log(a);//10
console.log(2**4);//16

// relational operator

let c = 20, d = 30
console.log(a==b);//false
console.log(5=="5");//true
console.log(5!="5");//false
console.log(c!=d);//true
console.log(5==="5");//false
console.log(5!=="5");//true
console.log(c>d);//false
console.log(c>=d);//false
console.log(c<d);//true
console.log(c<=d);//true

// assignment operator

let s = 20
console.log(s);//20
s+=5
console.log(s);//25
s-=5
console.log(s);//20
s*=2
console.log(s);//40
s/=2
console.log(s);//20
s%=2
console.log(s);//0

let r = 2
console.log(r**=5);//32

// logical operator

let t = 20, f = 80, g = 90, h = 100
console.log((t>f)&&(g<h));//false

console.log((t>f)||(g<h));//true

let o = true
console.log(!o);//false

// ternary operator

let k = 1000; l = 12500, m = 285000

let q = (k>l)?("k is greater"):("l is greater");
console.log(q);

let w = (k > l)?(k>m?("k is greater"):("m is greater")):((l>m)?("l is greater"):("m is greater"))
console.log(w);