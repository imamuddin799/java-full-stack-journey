let a = 10
console.log(a)//10
console.log(typeof a);//number

let b = 10.56356
console.log(b)//10.56356
console.log(typeof b);//number

let c = -10.5
console.log(c)//-10.5
console.log(typeof c);//number

let d = 50n
console.log(d)//50n
console.log(typeof d);//bigint

let e = true
console.log(e)//true
console.log(typeof e);//boolean

let f = false
console.log(f)//false
console.log(typeof f);//boolean

let g = 'i am a developer'
console.log(g)//i am a developer
console.log(typeof g);//string

let sal = 50000
let h = "i 'am a developer my sal is "+sal+" i am working for so many years"
console.log(h)//i 'am a developer my sal is 50000 i am working for so many years
console.log(typeof h);//string

let q = `i 'am a developer
 my sal is ${sal} 
 i am working for so many years`
console.log(q)//i 'am a developer my sal is 50000 i am working for so many years
console.log(typeof q);//string

let w = 25
console.log(w)//25
console.log(typeof w);//number
w=null
console.log(w);//null
console.log(typeof w);//object

let s
console.log(s);//undefined
console.log(typeof s);//undefined

let r = "10a"
console.log(r);//10a
console.log(typeof r);//string
console.log(isNaN(r));//true

let k = NaN
console.log(k);//NaN
console.log(typeof k);//number

let u = Symbol("hello")
console.log(u);
console.log(typeof u);
console.log(u.description);
