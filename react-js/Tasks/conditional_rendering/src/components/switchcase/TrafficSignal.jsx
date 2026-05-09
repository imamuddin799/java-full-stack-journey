
let TrafficSignal = () => {

    let color = "red";

    switch (color) {
        case "red":
            return <p>Stop</p>
        case "green":
            return <p>Go</p>
        case "yellow":
            return <p>Wait</p>
        default:
            return <p>Invalid Signal</p>
    }
}
export default TrafficSignal;