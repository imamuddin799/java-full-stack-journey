let gp = document.getElementById("gp")
let p1 = document.getElementById("p1")
let p2 = document.getElementById("p2")
let p1ch = document.getElementById("p1ch")
let p2ch = document.getElementById("p2ch")
let gch = document.getElementById("gch")

gp.addEventListener("click",(e)=>{
    e.stopPropagation()
    gp.style.backgroundColor = randomColor()
    console.log("Grand Parent Clicked");
})

p1.addEventListener("click",(e)=>{
    e.stopPropagation()
    p1.style.backgroundColor = randomColor()
    console.log("Parent 1 Clicked");
})

p2.addEventListener("click",(e)=>{
    e.stopPropagation()
    p2.style.backgroundColor = randomColor()
    console.log("Parent 2 Clicked");
})

p1ch.addEventListener("click",(e)=>{
    e.stopPropagation()
    p1ch.style.backgroundColor = randomColor()
    console.log("Parent 1 Child Clicked");
})
p2ch.addEventListener("click",(e)=>{
    e.stopPropagation()
    p2ch.style.backgroundColor = randomColor()
    console.log("Parent 2 Child Clicked");
})
gch.addEventListener("click",(e)=>{
    e.stopPropagation()
    gch.style.backgroundColor = randomColor()
    console.log("Grand Child Clicked");
})

function randomColor(){
    let r = Math.floor(Math.random() * 255)
    let g = Math.floor(Math.random() * 255)
    let b = Math.floor(Math.random() * 255)
    console.log("[{"+r+"} {"+g+"} {"+b+"}]");
    return `rgb(${r}, ${g}, ${b})`
}