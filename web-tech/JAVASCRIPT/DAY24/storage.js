// localstorage

window.localStorage.setItem("name", "abc")
let a = window.localStorage.setItem("id", "147")
console.log(a);

let i = window.localStorage.getItem("id")
console.log(i);

let n = window.localStorage.getItem("name")
console.log(n);

window.localStorage.removeItem("id")
window.localStorage.clear()

// session storage

window.sessionStorage.setItem("role","web")
let r = window.sessionStorage.getItem("role")
console.log(r);

window.sessionStorage.setItem("address", "hyd")
let r1 = window.sessionStorage.getItem("address")
console.log(r1);

window.sessionStorage.removeItem("address")
window.sessionStorage.clear()