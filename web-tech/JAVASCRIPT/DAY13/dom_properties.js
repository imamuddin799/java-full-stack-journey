let b = document.body
console.log(b);
console.log(b.firstElementChild);
console.log(b.lastElementChild.previousElementSibling);

let d = b.firstElementChild
console.log(d);
console.log(d.firstElementChild);
console.log(d.firstChild);

console.log(d.firstElementChild.nextElementSibling);
console.log(d.firstElementChild.nextSibling);
console.log(d.lastElementChild);
console.log(d.lastElementChild.previousElementSibling);
console.log(d.lastElementChild.previousElementSibling.previousSibling);

let r = d.lastElementChild.previousElementSibling.previousSibling
console.log(r.parentElement);
console.log(r.parentElement.parentElement);
console.log(r.parentNode.parentNode);

console.log(d.lastChild);
console.log(d.children);
console.log(d.childNodes);
console.log(d.childNodes.length);
console.log(d.childNodes[0]);