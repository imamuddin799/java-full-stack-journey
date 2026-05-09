
let Banking = () => {
    let bank = prompt("enter the bank name").toUpperCase();
    console.log(bank);
    if (bank == "SBI") {
        return <>
            <h1>Welcome to SBI</h1>
        </>
    }
    else if (bank == "ICICI") {
        return <>
            <h1>Welcome to ICICI</h1>
        </>
    }
    else if (bank == "UNI") {
        return <>
            <h1>Welcome to UNION</h1>
        </>
    }
    else {
        return <>
            <h1>Come after the lunch</h1>
        </>
    }
}
export default Banking;