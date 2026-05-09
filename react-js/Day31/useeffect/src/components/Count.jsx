import { useEffect, useState } from "react"

let Count = () => {

    let [count, setCount] = useState(0);

    useEffect(() => {
        let timerid = setInterval(() => {
            setCount(count + 1)
        }, 1000);

        return () => {
            clearInterval(timerid)
        }
    }, [count])

    return <>
        <section className="h-screen w-screen flex justify-center items-center">
            <div className="flex flex-col justify-center items-center">
                <h1 className="text-2xl">Count : {count}</h1>
                <div>
                <button onClick={() => setCount(count + 1)} className="py-2 px-4 border-2 my-3 bg-green-600 text-white">Increment</button>
                <button onClick={() => setCount(count - 1)} className="py-2 px-4 border-2 my-3 bg-red-600 text-white">Decrement</button>
                </div>
            </div>
        </section>
    </>
}

export default Count