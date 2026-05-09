function demo(a, b){
    setTimeout(() => {
        for(let i = a; i <= b; i++){
            console.log(i);
        }
    },2000)
}
demo(1, "5a")

function d1(){
    console.log("hello");
}
d1()

function d2(){
    setTimeout(() => {
        console.log("hello d2 function");
    }, 3000)
}
d2()


let h = document.getElementById("demo")

let demo1 = setInterval(time1, 100) //here at time1, the function name should be there not function call ! time1()

function time1(){
    let date = new Date()
    let t = date.toLocaleTimeString()
    h.innerText = t
}

function stop1(){
    clearInterval(demo1)
}