import { memo } from "react";

const Button = ({ handleClick, children }) => {

    console.log('Button - ', children);

    return <>
        <button onClick={handleClick} className="w-fit py-1 px-4 border border-teal-500 bg-orange-600 text-white cursor-pointer">{children}</button>
    </>
}

export default memo(Button);