let gp = document.getElementById("gp")
let p = document.getElementById("p")
let ch = document.getElementById("ch")

gp.addEventListener("click", (e) => {
    // e.stopPropagation();
    e.stopImmediatePropagation()
    console.log("grand parent clicked");
    gp.style.backgroundColor = "hotpink"
})

p.addEventListener("click", (e) => {
    // e.stopPropagation();
    e.stopImmediatePropagation()
    console.log("parent clicked");
    p.style.backgroundColor = "yellow"
})
ch.addEventListener("click", (e) => {
    // e.stopPropagation();
    e.stopImmediatePropagation()
    console.log("child clicked");
    ch.style.backgroundColor = "red"
})

let gp1 = document.getElementById("gp")
let p1 = document.getElementById("p")
let ch1 = document.getElementById("ch")

gp1.addEventListener("click", (e) => {
    // e.stopPropagation();
    e.stopImmediatePropagation()
    console.log("grand parent 1 clicked");
    gp1.style.backgroundColor = "hotpink"
}, false)

p1.addEventListener("click", (e) => {
    // e.stopPropagation();
    e.stopImmediatePropagation()
    console.log("parent 1 clicked");
    p1.style.backgroundColor = "yellow"
}, false)
ch1.addEventListener("click", (e) => {
    // e.stopPropagation();
    e.stopImmediatePropagation()
    console.log("child 1 clicked");
    ch1.style.backgroundColor = "red"
}, false)

let gp2 = document.getElementById("gp")
let p2 = document.getElementById("p")
let ch2 = document.getElementById("ch")

gp2.addEventListener("click", (e) => {
    // e.stopPropagation();
    e.stopImmediatePropagation()
    console.log("grand parent 2 clicked");
    gp2.style.backgroundColor = "hotpink"
}, true)

p2.addEventListener("click", (e) => {
    // e.stopPropagation();
    e.stopImmediatePropagation()
    console.log("parent 2 clicked");
    p2.style.backgroundColor = "yellow"
}, true)
ch2.addEventListener("click", (e) => {
    // e.stopPropagation();
    e.stopImmediatePropagation()
    console.log("child 2 clicked");
    ch2.style.backgroundColor = "red"
}, true)