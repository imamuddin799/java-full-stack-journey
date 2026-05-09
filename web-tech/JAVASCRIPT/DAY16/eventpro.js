let gp = document.getElementById("gp")
let p = document.getElementById("p")
let ch = document.getElementById("ch")

gp.addEventListener("click", ()=>{
    console.log("Grand Parent Clicked");
    gp.style.backgroundColor = "yellow"
},true)
p.addEventListener("click", ()=>{
    console.log("Parent Clicked");
    p.style.backgroundColor = "red"
},true)
ch.addEventListener("click", ()=>{
    console.log("Child Clicked");
    ch.style.backgroundColor = "blue"
},true)


let gp2 = document.getElementById("gp2")
let p2 = document.getElementById("p2")
let ch2 = document.getElementById("ch2")

gp2.addEventListener("click", ()=>{
    console.log("Grand Parent Clicked");
    gp2.style.backgroundColor = "yellow"
},false)
p2.addEventListener("click", ()=>{
    console.log("Parent Clicked");
    p2.style.backgroundColor = "red"
},false)
ch2.addEventListener("click", ()=>{
    console.log("Child Clicked");
    ch2.style.backgroundColor = "blue"
},false)
let gp3 = document.getElementById("gp3")
let p3 = document.getElementById("p3")
let ch3 = document.getElementById("ch3")

gp3.addEventListener("click", (e)=>{
    e.stopPropagation();
    console.log("Grand Parent Clicked");
    gp3.style.backgroundColor = "yellow"
},false)
p3.addEventListener("click", (e)=>{
    e.stopPropagation();
    console.log("Parent Clicked");
    p3.style.backgroundColor = "red"
},false)
ch3.addEventListener("click", (e)=>{
    e.stopPropagation();
    console.log("Child Clicked");
    ch3.style.backgroundColor = "blue"
},false)