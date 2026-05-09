function demo(){
    console.log("hello event");
    document.body.style.backgroundColor="red"
}
function light(){
    document.body.style.backgroundColor="white"
}
function dark(){
    document.body.style.backgroundColor="black"
}
function random(){
    let red = Math.floor(Math.random()*255)
    console.log(red);
    console.log(red/255);
    let green = Math.floor(Math.random()*255)
    console.log(green);
    console.log(green/255);
    let blue = Math.floor(Math.random()*255)
    console.log(blue);
    console.log(blue/255);

    document.body.style.backgroundColor = `rgb(${red}, ${green}, ${blue})`
}