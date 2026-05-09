
let GradeDisplay = () => {

    let grade = "A";

    if (grade === "A") {
        return <p>Excellent</p>
    } else if (grade === "B") {
        return <p>Good</p>
    } else if (grade === "C") {
        return <p>Average</p>
    } else {
        return <p>Fail</p>
    }
}
export default GradeDisplay;