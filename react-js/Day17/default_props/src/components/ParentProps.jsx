import DefaultProps from "./DefaultProps"
import SecondWayDefaultProps from "./SecondWayDefaultProps";

let ParentProps = () => {

    return <>
        <DefaultProps ename="Raj" esalary={20000} />
        <DefaultProps ename="Vishal" />
        <DefaultProps esalary={50000} />
        <SecondWayDefaultProps />
        <SecondWayDefaultProps ename="Divya Bharthi" esalary={7999999} />
        <SecondWayDefaultProps ename="John Doe" esalary={898779} />
        <SecondWayDefaultProps esalary={893738779} />
    </>
}
export default ParentProps;