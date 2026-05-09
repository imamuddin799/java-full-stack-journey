import GradeDisplay from "./components/elseifladder/GradeDisplay";
import Greeting from "./components/elseifladder/Greeting";
import SpeedInfo from "./components/elseifladder/SpeedInfo";
import Temparature from "./components/elseifladder/Temparature";
import AgeStatus from "./components/ifelse/AgeStatus";
import Banner from "./components/ifelse/Banner";
import StockStatus from "./components/ifelse/StockStatus";
import WelcomeMessage from "./components/ifelse/WelcomeMessage";
import ErrorMessage from "./components/shortcircuit/ErrorMessage";
import Notification from "./components/shortcircuit/Notification";
import OfflineMessage from "./components/shortcircuit/OfflineMessage";
import UserName from "./components/shortcircuit/UserName";
import ShirtSize from "./components/switchcase/ShirtSize";
import TrafficSignal from "./components/switchcase/TrafficSignal";
import UserRole from "./components/switchcase/UserRole";
import WeekType from "./components/switchcase/WeekType";
import AgeCheck from "./components/ternary/AgeCheck";
import CartMessage from "./components/ternary/CartMessage";
import GradeTag from "./components/ternary/GradeTag";
import LoginStatus from "./components/ternary/LoginStatus";

function App() {

  return <>
    {/* if else */}
    <WelcomeMessage />
    <StockStatus />
    <Banner />
    <AgeStatus />

    {/* else if */}
    <Temparature />
    <GradeDisplay />
    <Greeting />
    <SpeedInfo />

    {/* switch case */}
    <TrafficSignal />
    <WeekType />
    <UserRole />
    <ShirtSize />

    {/* ternary */}
    <LoginStatus />
    <CartMessage />
    <AgeCheck />
    <GradeTag />

    {/* short circuit */}
    <Notification />
    <OfflineMessage />
    <ErrorMessage />
    <UserName />
  </>
}
export default App;