
const Home = () => {
    return <>
        <div>
            Welcome {localStorage.getItem("user")}
        </div>
    </>
}

export default Home