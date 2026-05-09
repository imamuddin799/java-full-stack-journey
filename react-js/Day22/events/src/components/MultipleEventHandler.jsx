
let MultipleEventhandler = () => {

    let handlePayment = () => {
        console.log("Payment Successful");
    }

    let handleCurrentBalance = _ => {
        console.log("current balance 2000");
    }
    
    let handleDebitAmount = () => {
        console.log("150 debited from you account");
    }

    return <>
        <h1>Multiple Event handlers</h1>
        <button onClick={() => {
            handlePayment();
            handleCurrentBalance();
            handleDebitAmount();
        }}>
            Make Payment
        </button>
    </>
}

export default MultipleEventhandler;