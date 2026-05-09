let form = document.querySelector("form")
let inp1 = document.getElementById("inp1")
let inp2 = document.getElementById("inp2")
let inp3 = document.getElementById("inp3")
let inp4 = document.getElementById("inp4")
let table = document.getElementById("table")

console.log(form);

form.addEventListener("click", (e) => {
    e.preventDefault()
    if (e.target.innerText == "Add") {
        if (inp1.value != "" && inp2.value != "" && inp3.value != "" && inp4.value != "") {
            table.innerHTML += `<tr>
                                    <td>${inp1.value}</td>
                                    <td>${inp2.value}</td>
                                    <td>${inp3.value}</td>
                                    <td>${inp4.value}</td>
                                    <td><button>Edit</button></td>
                                    <td><button>Delete</button></td>
                                </tr>`
            inp1.value = ""
            inp2.value = ""
            inp3.value = ""
            inp4.value = ""
        }
    }
    else if (e.target.innerText == "Edit") {
        e.target.innerText = "Update"
        inp4.value = e.target.parentElement.previousElementSibling.innerText;
        inp3.value = e.target.parentElement.previousElementSibling.previousElementSibling.innerText;
        inp2.value = e.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.innerText;
        inp1.value = e.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.innerText;
    }
    else if (e.target.innerText == "Update") {
        e.target.innerText = "Edit"
        if (inp1.value != "" && inp2.value != "" && inp3.value != "" && inp4.value != "") {
            e.target.parentElement.previousElementSibling.innerText = inp4.value
            e.target.parentElement.previousElementSibling.previousElementSibling.innerText = inp3.value
            e.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.innerText = inp2.value
            e.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.innerText = inp1.value

            inp1.value = ""
            inp2.value = ""
            inp3.value = ""
            inp4.value = ""
        }
    }
    else if(e.target.innerText == "Delete"){
        e.target.parentElement.parentElement.remove();
    }
})