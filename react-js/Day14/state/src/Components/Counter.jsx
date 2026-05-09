import { useState } from "react";

// let count = useState(); //! Invalid hook call. Hooks can only be called inside of the body of a function component.

let Counter = () => {

    // let count = useState(10);
    // console.log(count);
    // console.log(count[0]);
    // console.log(count[1]);

    console.log("Re-rendering......");

    let [count, setCount] = useState(0);
    console.log(count);
    console.log(setCount);

    let [name, setName] = useState("Gajala");
    let [isMarried, setIsMarried] = useState(true);

    let handleIncrement = () => {
        setCount(count + 1);
    };

    let handleDecrement = () => {
        setCount(count - 1);
    };

    let handleReset = () => {
        setCount(0);
    };

    return <>
        <h1>Count {count}</h1>
        <h1>Name : {name}</h1>
        <button onClick={ handleIncrement }>+</button>
        <button onClick={ handleDecrement }>-</button>
        <button onClick={handleReset}>Reset</button><br />
        <button onClick={() => { setName("Raju") }}>Change Name</button>
        <h1>{isMarried ? "They will go for somewhere" : "They will come for react class"}</h1>
        <h1>{isMarried.toString()}</h1>
    </>
}
export default Counter;