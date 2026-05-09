
let Temparature = () => {

    let temp = 39;

    if (temp > 35) {
        return <p>Very Hot</p>;
    } else if (temp > 25) {
        return <p>Warm</p>;
    } else {
        return <p>Cool</p>;
    }
}
export default Temparature;