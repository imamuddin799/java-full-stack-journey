
import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import Products from "../components/maincontent/Products";
import Users from "../components/maincontent/Users";
import Carts from "../components/maincontent/Carts";
import SingleProduct from "../components/maincontent/SingleProduct";
import SecondSingleProduct from "../components/maincontent/SecondSingleProduct";
import SingleUser from "../components/maincontent/SingleUser";
import SecondSingleUser from "../components/maincontent/SecondSingleUser";
import SecondSingleCart from "../components/maincontent/SecondSingleCart";
import SingleCart from "../components/maincontent/SingleCart";
export const routes = createBrowserRouter([
    {
        path: '/',
        element: <App />,
        children: [
            {
                index: true,
                element: <Products />
            },
            {
                path: '/users',
                element: <Users />
            },
            {
                path: '/user/:id',
                element: <SingleUser />
            },
            {
                path: '/usersec/:id',
                element: <SecondSingleUser />
            },
            {
                path: '/carts',
                element: <Carts />
            },
            {
                path: '/cart/:id',
                element: <SingleCart />
            },
            {
                path: '/cartsec/:id',
                element: <SecondSingleCart />
            },
            {
                path: '/product/:id',
                element: <SingleProduct />
            },
            {
                path: '/productsec/:id',
                element: <SecondSingleProduct />
            }
        ]
    }
])