console.dir(document);

let h1 = document.getElementById("heading1");
let h2 = document.getElementById("heading2");
console.dir(h1);
console.dir(h2);

console.log(h1.nextSibling); //! comment node
console.log(h1.nextElementSibling); //! element node

// ! reconciliation process:
// 1. When the webpage is loaded, the browser creates a real DOM tree from the HTML document.
// 2. React-Dom creates a virtual DOM tree, which is a lightweight copy of the real DOM tree.
// 3. When we make changes to the virtual DOM, React-Dom compares the new virtual DOM tree with the previous one to identify the differences with the help of the diffing algorithm.
// 4. All the changes are collected in a batch and then patched to the real-dom. this process is called as patching. and the whole process is called as reconciliation process.