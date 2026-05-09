
let Voting = () => {

    let age = 20;

    if (age > 18) {
        return <h1>You are eligible for voting</h1>
    }
    else {
        return <h1>You are not eligible for voting</h1>
    }
}
export default Voting;