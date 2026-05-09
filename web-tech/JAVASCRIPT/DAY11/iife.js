(
    function(a,b){
        console.log("hi iife");
        console.log(a+b);
    }
)(10,20);

var d = 505;
(
    function demo(){
        var d = 50
        console.log("hi demo function in iife");
        console.log(arguments);
        console.log(d);
        console.log(window.d);
        console.log(this.d);
    }
)(50,20)

let r = (
    ()=>{
        console.log("hi arrow function");
        return "hello"
    }
)()
console.log(r);
console.log(r);
// console.log("prototype" in r); //it is not possible