
let SpeedInfo = () => {

    let speed = 120;

    if (speed > 100) {
        return <p>Too Fast</p>;
    } else if (speed > 60) {
        return <p>Normal Speed</p>
    } else {
        return <p>Slow</p>
    }
}
export default SpeedInfo;