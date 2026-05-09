import { useEffect, useRef, useState } from "react"

let RandomColor = () => {
    let [count, setCount] = useState(0)

    let randomColor = () => {
        let r = Math.floor(Math.random() * 255);
        let g = Math.floor(Math.random() * 255);
        let b = Math.floor(Math.random() * 255);

        return `rgb (${r}, ${g}, ${b})`;
    }

    let ref = useRef();
    
    // useEffect(() => {
    //     ref.current.style.backgroundColor = randomColor();
    // }, [count])


    useEffect(() => {
        setInterval(() => {
            ref.current.style.backgroundColor = randomColor();
        }, 1000)
    }, [count])

    return <>
        <section ref={ref} style={{height: "100vh"}}>
            <button onClick={() => {setCount(count + 1)}}>
                Click Me
            </button>
        </section>
    </>
}
export default RandomColor;