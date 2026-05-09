import AdminDashboard from "./AdminDashboard";
import WithAuthorization from "./WithAuthorization";

let AuthorizedDashboard = WithAuthorization(AdminDashboard);
console.log(AuthorizedDashboard);
export default AuthorizedDashboard;