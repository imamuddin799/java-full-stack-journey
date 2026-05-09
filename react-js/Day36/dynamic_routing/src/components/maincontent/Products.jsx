import { Fragment, useEffect, useState } from "react";
import { Link } from 'react-router-dom';
const Products = () => {

    const [products, setProducts] = useState([])

    const getProducts = async () => {
        const response = await fetch('https://fakestoreapi.com/products');
        const data = await response.json();
        setProducts(data);
    }

    useEffect(() => {
        getProducts();
    }, [])

    return <>
        <div className="bg-amber-400 w-full h-full flex flex-col items-start justify-center">
            <h1 className="text-4xl font-bold py-3 pl-2">Products</h1>
            <div className="w-full bg-fuchsia-400 h-full overflow-auto grid grid-cols-4 gap-4 justify-center items-center p-3">
                {
                    products.map((product, index) => {
                        const { image, id } = product;
                        return <Fragment key={index}>
                            <div className="bg-white flex flex-col items-center justify-between w-full p-2 h-90">
                                <div>
                                    <img src={image} alt={id} className="w-full h-60 object-contain" />
                                </div>
                                <div className="w-full flex justify-between items-center gap-3">
                                    <Link to={`/product/${id}`} state={product} className="w-fit py-1 px-5 bg-blue-600 text-white rounded-lg">View More</Link>
                                    <Link to={`/productsec/${id}`} className="w-fit py-1 px-5 bg-blue-600 text-white rounded-lg">View More</Link>
                                </div>
                            </div>
                        </Fragment>
                    })
                }
            </div>
        </div>
    </>
}

export default Products