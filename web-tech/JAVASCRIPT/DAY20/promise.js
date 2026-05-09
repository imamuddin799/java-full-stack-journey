function demo1(a,b){
    new Promise((resolve, reject) => {
        setTimeout(() => {
            for(let i = a; i <= b; i++){
                console.log(i);
            }
        },3000)
    })
}
demo1(5, "10a")
function d2(){
    console.log("hello pending state");
}
d2()

function demo(a, b){
    new Promise((resolve, reject) => {
        setTimeout(() => {
            if(isNaN(a) || isNaN(b)){
                reject()
            }
            else{
                for(let i = a; i <= b; i++){
                    console.log(i);
                }
                resolve()
            }
        }, 3000)
    })
    .then(() => {
        console.log("Successfully Operation  Completed");
    })
    .catch(() => {
        console.error("Idiot give the correct values");
    })
}

demo(5, 10)
demo(5, "10a")
function d1(){
    console.log("hello pending state");
}
d1()

let bag_cleaned = true
let p = new Promise((resolve, reject) => {
    if(bag_cleaned){
        resolve()
    }
    else{
        reject()
    }
})
.then(() => {
    console.log("bag is cleaned");
})
.then(() => {
    console.log("hi second then");
})
.then(() => {
    console.log("hi 3rd then");
})
.then(() => {
    console.log("hi 4th then");
})
.catch(() => {
    console.log("bag is not cleaned idiot");
})
.catch(() => {
    console.log("hi 2nd catch");
})
.catch(() => {
    console.log("hi 3rd catch");
})
.catch(() => {
    console.log("hi 4th catch");
})
.finally(() => {
    console.log("HI FINALLY BLOCK");
})