import { useReducer } from "react";

let reducer = (state, action) => {
    switch (action.type) {
        case 'INCREMENT':
            return state + 1;

        case 'DECREMENT':
            return state - 1;

        case 'RESET':
            return 0;
    }
}
const Counter = () => {

    const [state, dispatch] = useReducer(reducer, 10)

    return <>
        <div className="flex justify-center items-center w-screen h-screen">
            <div className="flex flex-col gap-3 justify-center items-center">
                <h1 className="w-full ml-[50%]">Count : {state}</h1>
                <div className="w-full">
                    <button onClick={() => { dispatch({ type: 'DECREMENT' }) }} className="px-5 py-1 mx-4 bg-red-500 text-white">Decrement</button>
                    <button onClick={() => { dispatch({ type: 'INCREMENT' }) }} className="px-5 py-1 mx-4 bg-green-500 text-white">Increment</button>
                    <button onClick={() => { dispatch({ type: 'RESET' }) }} className="px-5 py-1 mx-4 bg-gray-500 text-white">Reset</button>
                </div>
            </div>
        </div>
    </>
}

export default Counter