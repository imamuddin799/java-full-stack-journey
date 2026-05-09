import { useState } from "react"
import ExpensiveComponent from "./ExpensiveComponent"
import Child from "./Child"
import UseMemoExample from "./UseMemoExample"

const Memo = () => {

    const [count, setCount] = useState(0)

    console.log('Memo component rendered');
    return <>
        <div>
            <h1>Count : {count}</h1>
            <button onClick={() => setCount(count + 1)}>Increment</button>
            <button onClick={() => setCount(count - 1)}>Decrement</button>
            <ExpensiveComponent />
            <Child />
            <UseMemoExample />
        </div>
    </>
}

export default Memo