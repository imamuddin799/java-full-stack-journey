
let WeekType = () => {

    let day = "Friday";

    switch (day) {
        case "Saturday":
        case "Sunday":
            return <p>Weekend</p>;
        case "Monday":
        case "Tuesday":
        case "Wednesday":
        case "Thursday":
        case "Friday":
            return <p>Weekday</p>;
        default:
            return <p>Unknown Day</p>;
    }
}
export default WeekType;