import AuthorizedDashboard from "./authorization/AuthorizedDashboard";
import Greeting from "./Greeting";

let Home = () => {

    return <>
        <AuthorizedDashboard username="Imamuddin" userRole="admin" />
        <AuthorizedDashboard username="Guest" userRole="user" />
        <Greeting username="Imamuddin Ansari"/>
    </>
}
export default Home;