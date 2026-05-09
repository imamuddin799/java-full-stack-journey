import { Fragment, useState } from "react";
import { useLocation } from "react-router-dom";

const SingleCart = () => {
    const location = useLocation();
    const [cart, setCart] = useState(location.state);

    const { id, userId, date, products } = cart;

    return <>
        <div className="w-full h-full flex flex-col items-center justify-start ">
            <div className="w-1/2 mt-3 bg-white">
                <div className="flex flex-col justify-start items-start w-full px-3 gap-3">
                    <h1><span className="text-lg font-medium">ID: </span> <span>{id}</span></h1>
                    <h1><span className="text-lg font-medium">User ID: </span> <span>{userId}</span></h1>
                    <h1><span className="text-lg font-medium">Date: </span> <span>{date}</span></h1>
                    <h1><span className="text-lg font-medium">Products: </span></h1>
                    <div className="w-full grid grid-cols-2 gap-5">
                        {
                            products.map((product, index) => {
                                const { productId, quantity } = product;
                                return <Fragment key={index}>
                                    <div>
                                        <h1><span className="text-lg font-medium">Product ID: </span> <span>{productId}</span></h1>
                                        <h1><span className="text-lg font-medium">Quantity: </span> <span>{quantity}</span></h1>
                                    </div>
                                </Fragment>
                            })
                        }
                    </div>
                </div>
            </div>
        </div>
    </>
}

export default SingleCart