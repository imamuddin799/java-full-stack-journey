let plus = document.getElementById('plus')
let minus = document.getElementById('minus')
let span = document.querySelector('span')

console.log(plus);
console.log(minus);
console.log(span);

let i = 0;

plus.addEventListener("click", () => {
    if(span.innerText >= 0){
        span.innerText = ++i;
    }
})
minus.addEventListener("click", () => {
    if(span.innerText > 0){
        span.innerText = --i;
    }
})