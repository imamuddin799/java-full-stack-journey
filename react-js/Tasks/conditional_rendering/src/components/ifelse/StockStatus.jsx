import { useState } from "react"

let StockStatus = () => {

    let [isAvailable, setIsAvailable] = useState(true);

    if (isAvailable) {
        return <p>Item is in Stock</p>
    } else {
        return <p>Item is out of Stock</p>
    }
}
export default StockStatus;