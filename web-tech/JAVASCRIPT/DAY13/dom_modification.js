let h = document.getElementById("d1")
console.log(h);
console.log(h.innerText);
console.log(h.textContent);
h.textContent += " hi"
console.log(h.innerText);
h.innerText = "tata bye bye good bye"

let b = document.body
console.log(b);
console.log(b.firstElementChild);
console.log(b.firstElementChild.innerHTML);

let c = b.innerHTML += `<table id = d2 border= 2px solid height = 200px width = 200px>
                            <tr>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>`
console.log(c);
// console.log(c.firstElementChild.firstElementChild);
let f = document.getElementById("d2")
console.log(f);

let q = document.createElement("table")
console.log(q);
q.setAttribute("border", "2px solid")
q.style.height = "200px"
q.style.width = "200px"
b.append(q)

let t1 = document.createElement("tr")
console.log(t1);
q.append(t1)

let td1 = document.createElement("td")
t1.append(td1)
td1.style.backgroundColor = "red"
console.log(td1);

let td2 = document.createElement("td")
t1.append(td2)
td2.style.backgroundColor = "green"
console.log(td2);

let t2 = document.createElement("tr")
console.log(t2);
q.appendChild(t2)

let td3 = document.createElement("td")
t2.appendChild(td3)
td3.style.backgroundColor = "skyblue"
console.log(td3);

let td4 = document.createElement("td")
t2.appendChild(td4)
td4.style.backgroundColor = "yellow"
console.log(td4);