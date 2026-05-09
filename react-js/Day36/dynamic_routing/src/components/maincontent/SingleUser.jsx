import { useState } from "react";
import { useLocation, useParams } from "react-router-dom"

const SingleUser = () => {
    const location = useLocation();
    const [user, setUser] = useState(location.state);

    const {address:{city, geolocation:{lat, long}, number, street, zipcode}, email, id, name:{firstname, lastname}, password, phone, username} = user;

    return <>
        <div className="w-full h-full flex flex-col items-center justify-start ">
            <div className="w-1/2 mt-3 bg-white">
                <div className="flex flex-col justify-start items-start w-full px-3 gap-3">
                    <h1><span className="text-lg font-medium">ID: </span> <span>{id}</span></h1>
                    <h1><span className="text-lg font-medium">Username: </span> <span>{username}</span></h1>
                    <h1><span className="text-lg font-medium">Full Name: </span> <span>{firstname} {lastname}</span></h1>
                    <h1><span className="text-lg font-medium">Email: </span> <span>{email}</span></h1>
                    <h1><span className="text-lg font-medium">Phone: </span> <span>{phone}</span></h1>
                    <h1><span className="text-lg font-medium">Address: </span></h1>
                    <h1><span className="text-lg font-medium">City: </span> <span>{city}</span></h1>
                    <h1><span className="text-lg font-medium">Street: </span> <span>{street}</span></h1>
                    <h1><span className="text-lg font-medium">Number: </span> <span>{number}</span></h1>
                    <h1><span className="text-lg font-medium">ZipCode: </span> <span>{zipcode}</span></h1>
                    <h1><span className="text-lg font-medium">Geolocation: </span> <span>{lat}</span>  <span>{long}</span></h1>
                    <h1><span className="text-lg font-medium">Password: </span> <span>{password}</span></h1>
                </div>
            </div>
        </div>
    </>
}

export default SingleUser