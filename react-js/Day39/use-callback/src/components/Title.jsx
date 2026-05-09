import { memo } from "react";

const Title = () => {

    console.log('title is re-rendering');

    return <>
        <div>
            <h1>useCallback hook</h1>
        </div>
    </>
}

export default memo(Title)