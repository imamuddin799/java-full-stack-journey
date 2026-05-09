import { useEffect } from "react";
import { useRef } from "react";

let Focus = () => {

    let inputref = useRef()

    useEffect(()=> {
        inputref.current.focus();
    })
    return <>
        <input type="text" ref={inputref} className="w-[300px] ml-[30px] px-4 border-1" />
    </>
}
export default Focus;