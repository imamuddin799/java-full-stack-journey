import { Fragment } from "react";

const SayHello = () => {

    let handleEvent = () => {
        alert("Hello bewda public");
    }

    let youClickMe = (e) => {
        console.log(e); //! event object is passed as an argument to event handler function when event triggred
        console.log("Thank You 🙏");
        return <>
            {
                Object.keys(e).map((ele, index) => {
                    console.log(ele);
                    return <Fragment key={index}>
                        <h2>{ele}</h2>
                    </Fragment>
                })
            }
        </>
    }

    return <>
        <button onClick={handleEvent}>Click Me</button>
        <button onDoubleClick={youClickMe}>Click You</button>
    </>
}

export default SayHello;