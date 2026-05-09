let inp = document.getElementById("inp1")
let btn = document.getElementById("btn")

btn.addEventListener("click", (y) => {
    y.preventDefault()
    console.log(inp.value);
    inp.value = ""
})