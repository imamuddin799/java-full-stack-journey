import { useEffect, useState } from "react";
import { useParams } from "react-router-dom"

const SecondSingleProduct = () => {

    const [product, setProduct] = useState({})

    let { id } = useParams();
    console.log(id);

    const getProduct = async () => {
        const response = await fetch(`https://fakestoreapi.com/products/${id}`)
        const data = await response.json();
        setProduct(data);
    }

    useEffect(() => {
        getProduct();
    }, [])

    return <>
        <div className="w-full h-full flex flex-col items-center justify-start ">
            <div className="w-1/2 mt-3 bg-white">
                <div className="w-90% h-60">
                    <img src={product?.image} alt="" className="h-full w-auto mx-auto" />
                </div>
                <div className="p-3">
                    <h1 className="text-xl font-medium">Category : {product?.category}</h1>
                    <h1 className="text-xl font-medium">Description :</h1>
                    <p className="p-3 bg-slate-200 text-gray-600">{product?.description}</p>
                    <h1 className="text-xl font-medium">Title : {product?.title}</h1>
                    <h1 className="text-xl font-medium">Rating : {product?.rating?.rate}</h1>
                    <h1 className="text-xl font-medium">Number of people rated : {product?.rating?.count}</h1>
                    <h1 className="text-xl font-medium">Price : ${product?.price}</h1>
                </div>
            </div>
        </div>
    </>
}

export default SecondSingleProduct