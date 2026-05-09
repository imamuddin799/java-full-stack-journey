function demo(){
    console.log("Hi");
}
demo()
demo()

d1()
function d1(){
    console.log("happy new year");
}
function d2(a,b){
    console.log(a+b);
    console.log(a,b);
}
d2(10,20)
d2(50,80)
d2("100a",5)

function d3(){
    let a = 50, b = 75
    console.log(a+b);
}
d3()
d3()

function d4(s,d,f,g){
    console.log(s,d,f,g);
    console.log(s+d);
    console.log(arguments);
    console.log(arguments[7]);
    console.log(arguments[5]);
}
d4(10,20)
d4(5,2,3,6)
d4(51,54,85,78,46,1,2,3)

function d5(){
    console.log(arguments);
    console.log(arguments[3]);
}
d5(5,4,8)

var g = 45
function d6(){
    var g = 75
    console.log(g);
    console.log(window.g);
    console.log(this.g);
}
d6()

function d7(a,b){
    console.log(a+b);
}
d7(10,20)
console.log(d7);
console.log(d7(40,5));

function d8(a,b){
    console.log(a+b);
    return "hi"
    console.log("hello");
    return "hi bye"
}
console.log(d8(50,80));