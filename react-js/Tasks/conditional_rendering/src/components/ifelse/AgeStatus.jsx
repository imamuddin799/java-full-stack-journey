
let AgeStatus = () => {
    let age = 24;

    if (age >= 18) {
        return <p>You are an Adult.</p>
    } else {
        <p>You are a minor.</p>
    }
}
export default AgeStatus;