import { Fragment, useEffect, useState } from "react";
import { Link } from "react-router-dom";

const Carts = () => {
    const [carts, setCarts] = useState([])

    const getCarts = async () => {
        const response = await fetch('https://fakestoreapi.com/carts');
        const data = await response.json();
        console.log(data);
        setCarts(data);
    }

    useEffect(() => {
        getCarts();
    }, [])

    return <>
        <div className="bg-amber-400 w-full h-full flex flex-col items-start justify-center">
            <h1 className="text-4xl font-bold py-3 pl-2">Carts</h1>
            <div className="w-full bg-fuchsia-400 h-full overflow-auto grid grid-cols-3 gap-4 justify-start items-start p-3">
                {
                    carts.map((cart, index) => {
                        const { id, userId, date, products } = cart;
                        return <Fragment key={index}>
                            <div className="bg-white flex flex-col items-center justify-between w-full p-2 gap-5">
                                <div className="flex flex-col justify-start items-start w-full px-3 gap-3">
                                    <h1><span className="text-lg font-medium">User ID: </span> <span>{userId}</span></h1>
                                    <h1><span className="text-lg font-medium">Date: </span> <span>{date}</span></h1>
                                    <h1><span className="text-lg font-medium">No of Products: </span> <span>{products.length}</span></h1>
                                </div>
                                <div className="w-full flex justify-between px-3 items-center gap-3">
                                    <Link to={`/cart/${id}`} state={cart} className="w-fit py-1 px-5 bg-blue-600 text-white rounded-lg">View More</Link>
                                    <Link to={`/cartsec/${id}`} className="w-fit py-1 px-5 bg-blue-600 text-white rounded-lg">View More</Link>
                                </div>
                            </div>
                        </Fragment>
                    })
                }
            </div>
        </div>
    </>
}

export default Carts