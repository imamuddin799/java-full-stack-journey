
import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import Products from "../components/maincontent/Products";
import Users from "../components/maincontent/Users";
import Carts from "../components/maincontent/Carts";
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
                path: '/carts',
                element: <Carts />
            }
        ]
    }
])