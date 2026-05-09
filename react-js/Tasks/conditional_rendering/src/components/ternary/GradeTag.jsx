
let GradeTag = () => {

    let score = 98;

    return <>
        <p>
            {
                score >= 90
                    ? "Excellent"
                    : score >= 70
                        ? "Good"
                        : score >= 50
                            ? "Pass"
                            : "Fail"
            }
        </p>
    </>
}
export default GradeTag;