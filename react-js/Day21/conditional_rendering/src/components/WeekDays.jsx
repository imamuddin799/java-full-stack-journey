
let WeekDays = _ => {
    let day = prompt("Enter the day").toUpperCase();
    switch (day) {
        case "SUNDAY": {
            return <>
                <h1>Sunday Funday</h1>
            </>
        }
        case "MONDAY": {
            return <>
                <h1>Attend the react js class</h1>
            </>
        }
        case "TUESDAY": {
            return <>
                <h1>advanced java mock is there for girls</h1>
            </>
        }
        case "WEDNESDAY": {
            return <>
                <h1>Attend the react js class</h1>
            </>
        }
        case "THURSDAY": {
            return <>
                <h1>advanced java mock is there for boys</h1>
            </>
        }
        case "FRIDAY": {
            return <>
                <h1>Attend the react js class</h1>
            </>
        }
        case "SATURDAY": {
            return <>
                <h1>May be you will get a holiday</h1>
            </>
        }
    }
}
export default WeekDays;