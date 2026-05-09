import { Fragment, useEffect, useState } from "react"

const FetchAPI = () => {

    let [prodcts, setProducts] = useState()

    // ! If the dependency changed the useEffect will execute again
    let [count, setCount] = useState(0);

    let getProducts = async () => {
        let response = await fetch("https://fakestoreapi.com/products")
        console.log(response);
        let data = await response.json()
        setProducts(data)
    }

    useEffect(() => {
        getProducts();
    }, [count])

    return <>
        <div className="w-screen h-screen flex flex-col justify-start items-center">
            <button onClick={() => setCount(count + 1)} className="border-2 py-1 px-4">Increase Count</button>
            <div className="w-[90%] flex flex-wrap gap-2 justify-center items-center">
                {
                    prodcts?.map((product, index) => {
                        let { image, category, price } = product;
                        return <Fragment key={index}>
                            <div className="w-1/6 h-300px flex flex-col justify-center items-center">
                                <img src={image} alt="" className="w-[98%] h-[150px]" />
                                <h1>{category}</h1>
                                <p>{price}</p>
                                <button className="bg-green-300 py-1 w-[90%]">Add to cart</button>
                            </div>
                        </Fragment>
                    })
                }
            </div>
        </div>
    </>
}

export default FetchAPI