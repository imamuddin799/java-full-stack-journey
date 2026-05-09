import { Fragment } from "react";
import UserDetails from "./UserDetails";

let UserInfo = () => {
    
    let userInfo = {
        username: "Imamuddin Ansari",
        age : 22
    }

    let sahilInfo = {
        username: "Sahil Shukla",
        age: 23
    }

    let users = [
        { "username": "arjun_01", "age": 25 },
        { "username": "meera_s", "age": 22 },
        { "username": "rahul_dev", "age": 28 },
        { "username": "kavya_m", "age": 24 },
        { "username": "nitesh89", "age": 30 },
        { "username": "simran.k", "age": 21 },
        { "username": "amit_king", "age": 27 },
        { "username": "priya_star", "age": 23 },
        { "username": "dev123", "age": 29 },
        { "username": "aisha_cool", "age": 26 },
        { "username": "ravi_rock", "age": 24 },
        { "username": "tanya_b", "age": 22 },
        { "username": "manoj_kr", "age": 31 },
        { "username": "neha_love", "age": 20 },
        { "username": "yash_hero", "age": 25 },
        { "username": "deepa_r", "age": 27 },
        { "username": "vivek_sh", "age": 26 },
        { "username": "isha_queen", "age": 23 },
        { "username": "sanjay007", "age": 28 },
        { "username": "ruchi_k", "age": 22 }
    ]
    return <>
        <UserDetails data={ userInfo } />
        <UserDetails data={sahilInfo} />
        {
            users.map((user, index) => {
                return <Fragment key={index}>
                    <UserDetails data={user} />
                </Fragment>
            })
        }
    </>
}
export default UserInfo;