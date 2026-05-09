
let Greeting = () => {

    let hour = 6;

    if (hour < 12) {
        return <p>Good Morning</p>;
    } else if (hour < 18) {
        return <p>Good Afternoon</p>;
    } else {
        return <p>Good Evening</p>;
    }
}
export default Greeting;