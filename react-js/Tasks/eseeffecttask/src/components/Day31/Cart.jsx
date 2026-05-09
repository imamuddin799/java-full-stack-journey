import { Fragment, useEffect, useState } from "react"

let Cart = () => {
    let [cart, setCart] = useState()

    let getCart = async () => {
        let response = await fetch('https://fakestoreapi.com/carts')
        let data = await response.json()
        console.log(data);
        setCart(data)
    }

    useEffect(() => {
        getCart()
    }, [])

    return <>
        <section className="w-full flex flex-col justify-start items-center">
            <div className="w-[90%] flex flex-wrap gap-5 justify-center items-start">
                {
                    cart?.map((cartDetails, index) => {
                        let { userId, date, products } = cartDetails;

                        return <Fragment key={index}>
                            <div className="p-4 border-2 w-full h-full">
                                <h1 className="text-3xl text-pink-700 font-medium py-3">User ID : {userId}</h1>
                                <p>Date {date}</p>
                                <p>Products:</p>
                                <div className="w-full flex flex-wrap justify-center items-start">

                                    {
                                        products.map((products, index) => {
                                            let { productId, quantity } = products;
                                            return <Fragment key={index}>
                                                <div className="w-1/4 ">
                                                    <p>Product ID : {productId}</p>
                                                    <p>Quantity : {quantity}</p>
                                                </div>
                                            </Fragment>
                                        })
                                    }
                                </div>
                            </div>
                        </Fragment>
                    })
                }
            </div>
        </section>
    </>
}

export default Cart