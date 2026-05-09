for (let i = 1; i <= 10; i++) {
    console.log("hi");
}

for (let i = 0; i <= 5; i++) {
    console.log("hi");
    console.log("\n");
    
}

for (let i = 0; i <= 5; i++) {
    console.log("hi"+i);
}

let str = ""
for (let i = 0; i <= 5; i++) {
    str += "*"
    str += "\n"
}
console.log(str);

let str1 = ""
for (let i = 0; i <= 5; i++) {
    str1 += "*"
    str1 += "<br>"
}
document.write(str1);

let str2 = ""
for (let i = 1; i <= 3; i++) {
    for(let j = 1; j <= 3; j++){
        str2 += "* "
    }
    str2 += "\n"
}
console.log(str2);

let str3 = ""
for(let i = 1; i <= 3; i++){
    for(let j = 1; j <= 3; j++){
        str3 += "* "
    }
    str3 += "<br>"
}
document.write(str3)

let str4 = "", space = 3, star = -1
for(let i = 1; i <= 3; i++){
    space--, star += 2
    for(let j = 1; j <= space; j++){
        str4 += " "
    }
    for(let j = 1; j <= star; j++){
        str4 += "*"
    }
    str4 += "\n"
}
console.log(str4);


let str5 = "", space1 = 3, star1 = -1
for(let i = 1; i <= 3; i++){
    space1--, star1 += 2
    for(let j = 1; j <= space1; j++){
        str5 += "&nbsp;&nbsp;"
    }
    for(let j = 1; j <= star1; j++){
        str5 += "*"
    }
    str5 += "<br>"
}
document.write(str5);

let i = 1
while(i <= 7){
    console.log("hello");
    i++
}

let j = 1
while(j <= 10){
    console.log(j);
    j++
}

let k = 1
do{
    console.log("hello do-while"+k);
    k++
}
while(k <= 10)