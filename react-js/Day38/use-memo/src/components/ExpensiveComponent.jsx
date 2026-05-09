import { useMemo } from "react"

const ExpensiveComponent = () => {

    const memoizedvalue = useMemo(() => {
        let sum = 0;
        for (let i = 1; i < 10000000000; i++){
            sum += i;
        }
        return sum;
    }, [])

    return <>
        <div>
            <h1>Result : { memoizedvalue }</h1>
        </div>
    </>
}

export default ExpensiveComponent