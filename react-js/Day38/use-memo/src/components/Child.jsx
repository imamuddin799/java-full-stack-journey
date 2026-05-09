import { memo, useState } from "react"

const Child = () => {

    console.log('Child Component rendered');

    const [count, setCount] = useState(0)

    return <>
        <div>
            <h1>Count from Child : {count}</h1>
            <button onClick={() => setCount(count + 1)}>Increment</button>
            <button onClick={() => setCount(count - 1)}>Decrement</button>
        </div>
    </>
}

export default memo(Child)