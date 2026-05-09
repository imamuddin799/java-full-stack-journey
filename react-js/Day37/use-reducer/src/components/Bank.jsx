import { useReducer, useState } from "react"

const reducer = (state, action) => {
    switch (action.type) {
        case 'DEPOSIT':
            return { ...state, balance: state.balance + action.payload }
        case 'WITHDRAW':
            return { ...state, balance: state.balance - action.payload }
        default:
            return state;
    }
}

const account = { balance: 0, error: 'Some error' }

const Bank = () => {

    const [state, dispatch] = useReducer(reducer, account);

    const [amount, setAmount] = useState('');

    return <>
        <div className="w-screen h-screen flex justify-center items-center">
            <div className="w-1/2 flex flex-col justify-center items-center">
                <div className="w-1/2 flex flex-col">
                    <label htmlFor="">Enter Amount</label>
                    <input type="number" name="" id="" value={amount} onChange={(e) => setAmount(e.target.value)} className="outline-0 border p-2" />
                </div>
                <div className="flex justify-between items-start gap-5">
                    <button className="border-2 my-2 py-1 px-6 bg-green-600 text-white" onClick={() => {dispatch({ type: 'DEPOSIT', payload: Number(amount) }); setAmount("")}}>Deposit</button>
                    <button className="border-2 my-2 py-1 px-6 bg-red-600 text-white" onClick={() => {dispatch({ type: 'WITHDRAW', payload: Number(amount) }); setAmount("")}}>Withdraw</button>
                </div>
                <div>
                    <h2>Balance: {state.balance}</h2>
                </div>
            </div>
        </div>
    </>
}

export default Bank