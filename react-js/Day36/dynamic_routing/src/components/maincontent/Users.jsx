import { Fragment, useEffect, useState } from "react";
import { Link } from "react-router-dom";

const Users = () => {
    const [users, setUsers] = useState([])

    const getUsers = async () => {
        const response = await fetch('https://fakestoreapi.com/users');
        const data = await response.json();
        console.log(data);
        setUsers(data);
    }

    useEffect(() => {
        getUsers();
    }, [])

    return <>
        <div className="bg-amber-400 w-full h-full flex flex-col items-start justify-center">
            <h1 className="text-4xl font-bold py-3 pl-2">Users</h1>
            <div className="w-full bg-fuchsia-400 h-full overflow-auto grid grid-cols-3 gap-4 justify-center items-center p-3">
                {
                    users.map((user, index) => {
                        const { name:{firstname, lastname}, email, phone, id } = user;
                        return <Fragment key={index}>
                            <div className="bg-white flex flex-col items-center justify-between w-full p-2 gap-5">
                                <div className="flex flex-col justify-start items-start w-full px-3 gap-3">
                                    <h1><span className="text-lg font-medium">Full Name: </span> <span>{firstname} {lastname}</span></h1>
                                    <h1><span className="text-lg font-medium">Email: </span> <span>{email}</span></h1>
                                    <h1><span className="text-lg font-medium">Phone: </span> <span>{phone}</span></h1>
                                </div>
                                <div className="w-full flex justify-between px-3 items-center gap-3">
                                    <Link to={`/user/${id}`} state={user} className="w-fit py-1 px-5 bg-blue-600 text-white rounded-lg">View More</Link>
                                    <Link to={`/usersec/${id}`} className="w-fit py-1 px-5 bg-blue-600 text-white rounded-lg">View More</Link>
                                </div>
                            </div>
                        </Fragment>
                    })
                }
            </div>
        </div>
    </>
}

export default Users