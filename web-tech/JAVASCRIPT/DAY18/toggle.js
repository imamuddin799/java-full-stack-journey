let login = document.getElementById("d1")
let form = document.querySelector("form")

login.addEventListener("mouseover", () => {
    let display = form.classList.toggle("none")
    console.log(display);
    if(display){
        form.style.display = "block"
    }
    else{
        form.style.display = "none"
    }
})

let div = document.querySelector("div")
function register1(){
    div.style.display = "block"
}
function register2(){
    div.style.display = "none"
}