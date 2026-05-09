import React from 'react'
import { useState } from 'react'

const Short = () => {
    let [eligibal, setEligibel] = useState(true)
    return (
        <div>
            {
                eligibal && <h1>You are eligibale for something</h1>
            }
        </div>
    )
}

export default Short