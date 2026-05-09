let str = "hello World"
console.log(str);

let str1 = new String("hello new keyword")
console.log(str1);

let str2 = String("hi string constructor")
console.log(str2);

let str3 = "Hello JavaScript"
console.log(str3);
console.log(str3.toUpperCase);
console.log(str3.toLowerCase);

console.log(str3.replace("Hello", "HTML"));
console.log(str3.replace('a', 'q'));
console.log(str3.replaceAll('a', 'q'));

console.log(str3.slice(6, 10));
console.log(str3);
console.log(str3.substring(2, 5));
console.log(str3.substring(5));

console.log(str3.substr(6, 4));

let str4 = "Hello "
console.log(str4.repeat(5));

let str5 = "  hello   world     "
console.log(str5);
console.log(str5.trim());
console.log(str5.trimStart());
console.log(str5.trimEnd());
console.log(str5);

console.log(str5.includes("j"));
console.log(str5.includes("h"));

console.log(str5.charAt(5));
console.log(str5.charAt(15));

console.log(str5.charCodeAt(5));
console.log(str5.charCodeAt(7));
console.log(str5.charCodeAt(15));
console.log(str5.split(""));
console.log(str5.split(' '));
console.log(str5.split("l"));
console.log(str5.split("@"));

console.log(str5.indexOf("l"));
console.log(str5.lastIndexOf("l"));

console.log(str5.search("w"));