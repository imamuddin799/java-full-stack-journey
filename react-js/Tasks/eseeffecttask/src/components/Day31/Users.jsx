import { Fragment, useEffect, useState } from "react"

let Users = () => {

    let [users, setUsers] = useState()

    let getUsers = async () => {
        let response = await fetch('https://fakestoreapi.com/users')
        let data = await response.json()
        console.log(data);
        setUsers(data)
    }

    useEffect(() => {
        getUsers()
    }, [])

    return <>
        <section className="w-full flex flex-col justify-start items-center">
            <div className="w-[90%] flex flex-wrap gap-5 justify-center items-start">
                {
                    users?.map((user, index) => {
                        let { username, email, password, id, name, phone, address: { city, street, zipcode, number, geolocation:{ lat, long }} } = user;

                return <Fragment key={index}>
                    <div className="p-4 border-2 w-1/4 h-full">
                        <h1 className="text-3xl text-pink-700 font-medium py-3">Username : {username}</h1>
                        <p className="text-xl text-red-600 font-medium">ID : {id}</p>
                        <p>Name: {name.firstname} {name.lastname}</p>
                        <p>Phone: {phone}</p>
                        <p className="text-green-600 font-medium py-2">Email : {email}</p>
                        <p>Address:</p>
                        <p>City: {city}</p>
                        <p>Street: {street}</p>
                        <p>Zipcode: {zipcode}</p>
                        <p>Number: {number}</p>
                        <p>Geo Location:</p>
                        <p>Latitude {lat}</p>
                        <p>Longitude {long}</p>
                        <p className="text-orange-700 font-medium py-2">Password : {password}</p>
                    </div>
                </Fragment>
                    })
                }
            </div>
        </section>
    </>
}

export default Users