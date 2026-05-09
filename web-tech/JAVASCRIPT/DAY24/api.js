let inp = document.getElementById("inp1")
let btn = document.getElementById("btn")
let div = document.getElementById("d1")

btn.addEventListener("click", () => {
    window.fetch(`https://pixabay.com/api/?key=45607892-ebf247843c7e2f1530f4fcac1&q=${inp.value}&image_type=photo&per_page=${50}`)
    .then((x) => x.json())
    .then((data) => {
        console.log(data);
        for(let i of data.hits){
            console.log(i.largeImageURL);
            div.innerHTML += `<img src=${i.largeImageURL}>`
        }
        console.log(data);
    })
})

btn.addEventListener("click", async () => {
    console.log(inp.value);
    let s = await window.fetch(`https://pixabay.com/api/?key=45607892-ebf247843c7e2f1530f4fcac1&q=${inp.value}&image_type=photo&per_page=${50}`)

    let z = await s.json()
    console.log(z.hits);
    for(let i of z.hits){
        console.log(i.largeImageURL);
        div.innerHTML += `<img src = ${i.largeImageURL}>`
    }
})

let data = document.getElementById("data")
let ajax = new XMLHttpRequest()
console.log(ajax);
ajax.open("GET", "./country.json")
ajax.onload = (e) => {
    console.log(e);
    let conObject = JSON.parse(e.currentTarget.response)
    console.log(conObject[20].country);
    for(let i of conObject){
        data.innerHTML += `<option>${i.country}</option>`
    }
}
ajax.send()