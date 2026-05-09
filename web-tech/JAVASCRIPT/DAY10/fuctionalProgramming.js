function demo(a,b,c){
    console.log("hi functional programming");
    console.log(a);
    console.log(b);
    // console.log(c);
    c(a,b)
}
demo(10,20,()=>{
    console.log("hi call back function");
})

demo(50,30,function(s,d){
    console.log(s+d);
})

demo(5,3,function d1(s,d){
    console.log(s-d);
})

var x = 25
function demo1(){
    var x = 35
    function d1(){
        console.log("hi d1 function");
        var x = 85
        console.log(x);
        console.log(window.x);
    }
    function d2(){
        console.log("hi d2 function");
        console.log(x);
        console.log(window.x);
    }
    d1()
    d2()

    // return d1
    return [d1,d2]
}
// demo1()()
demo1()[0]()
demo1()[1]
demo1()[1]()
