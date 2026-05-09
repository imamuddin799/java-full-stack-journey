console.log(window);
console.log(window.navigator.onLine);
if(window.navigator.onLine){
    document.body.innerHTML += "🤣"
}
else{
    document.body.innerHTML += "😓"
}

let btn = document.getElementById("btn")
let div = document.querySelector('div')
let span = document.getElementById("d1")

btn.addEventListener("click", () => {
    div.style.transform = "translateX(-280px)"
    div.style.transitionDuration = "3s"
})

let geo = document.getElementById('geo')
geo.addEventListener("click", () => {
    console.log("hi geo location");
    console.log(window.navigator.geolocation.getCurrentPosition((p) => {
        console.log(p.coords.latitude);
        console.log(p.coords.longitude);
        console.log(`https://www.google.co.in/maps/place/${p.coords.latitude},${p.coords.longitude}`);
        let map = `https://www.google.co.in/maps/place/${p.coords.latitude},${p.coords.longitude}`
        // window.open(map);
        window.location.href = map
    }));
})

console.log(window);
console.log(window.navigator);
console.log(window.navigator.geolocation);
let a = window.navigator.geolocation;

let lat;
let long;
a.getCurrentPosition((p) => {
    lat = p.coords.latitude
    long = p.coords.longitude
})

console.log(lat);
console.log(long);