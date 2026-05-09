let gp = document.getElementById("gp")
let p = document.getElementById("p")
let ch = document.getElementById("ch")

// gp.addEventListener("click", (e) => {
//     if(e.target.tagName == "SECTION"){
//         console.log("hi grand parent");
//     }
// })
// p.addEventListener("click", (e) => {
//     if(e.target.tagName == "ASIDE"){
//         console.log("hi parent");
//     }
// })
// gp.addEventListener("click", (e) => {
//     if(e.target.tagName == "DIV"){
//         console.log("hi child");
//     }
// })

gp.addEventListener("click", (e) => {
    if(e.target.tagName == "SECTION"){
        console.log("hi grand parent");
    }
    if(e.target.tagName == "ASIDE"){
        console.log("hi parent");
    }
    if(e.target.tagName == "DIV"){
        console.log("hi child");
    }

})