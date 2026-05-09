function printTable() {
    let tableOf = document.getElementById("d1")
    let tableTill = document.getElementById("d2")

    tableOf = tableOf.value
    tableTill = tableTill.value

    let existingTable = document.getElementById("t1")
    if (existingTable) {
        existingTable.remove();
    }

    let table = document.createElement("table")
    table.setAttribute("border", "2px solid")
    table.setAttribute("id", "t1")
    let btn = document.getElementById("btn")
    btn.insertAdjacentElement("afterEnd", table);  //beforeBegin beforeEnd afterBegin afterEnd

    for (let i = 1; i <= tableTill; i++) {
        let tr = document.createElement("tr")
        table.appendChild(tr)

        let td1 = document.createElement("td")
        tr.appendChild(td1)
        // td1.innerText = `${tableOf}`
        // td1.style.padding = "10px 30px"
        let h1 = document.createElement("h2")
        td1.appendChild(h1)
        h1.textContent = `${tableOf}`
        td1.style.backgroundColor = `rgb(${random()}, ${random()}, ${random()})`
        h1.style.padding = "10px 30px"
        // h1.style.border = "2px solid"
        h1.style.margin = "0px 0px 0px 0px"

        let td4 = document.createElement("td")
        tr.appendChild(td4)
        let h4 = document.createElement("h2")
        td4.appendChild(h4)
        h4.textContent = `*`
        td4.style.backgroundColor = `rgb(${random()}, ${random()}, ${random()})`
        h4.style.padding = "10px 30px"
        // h1.style.border = "2px solid"
        h4.style.margin = "0px 0px 0px 0px"


        let td2 = document.createElement("td")
        tr.appendChild(td2)
        // td2.innerText = `${i}`
        // td2.style.padding = "10px 30px"
        let h2 = document.createElement("h2")
        td2.appendChild(h2)
        h2.textContent = `${i}`
        td2.style.backgroundColor = `rgb(${random()}, ${random()}, ${random()})`
        h2.style.padding = "10px 30px"
        // h2.style.border = "2px solid"
        h2.style.margin = "0px 0px 0px 0px"

        let td3 = document.createElement("td")
        tr.appendChild(td3)
        // td3.innerText = `${tableOf * i}`
        // td3.style.padding = "10px 30px"
        let h3 = document.createElement("h2")
        td3.appendChild(h3)
        h3.textContent = `${tableOf * i}`
        td3.style.backgroundColor = `rgb(${random()}, ${random()}, ${random()})`
        h3.style.padding = "10px 30px"
        // h3.style.border = "2px solid"
        h3.style.margin = "0px 0px 0px 0px"
    }
}

function random() {
    let random = Math.floor(Math.random() * 255)
    return random;
}