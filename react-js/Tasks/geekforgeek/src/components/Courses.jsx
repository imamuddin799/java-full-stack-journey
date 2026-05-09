import { Fragment } from "react";
import { MdKeyboardArrowLeft } from "react-icons/md";
import { MdKeyboardArrowRight } from "react-icons/md";


let Courses = () => {

    let courses = ['DSA', 'Practice Problems', 'Python', 'C', 'C++', 'Java', 'Courses', 'Machine Learning', 'DevOps', 'Web Development', 'System Design', 'Aptitude', 'Projects'];
    return <>
        <section className="flex py-2">
            <div className="flex justify-center items-center"><MdKeyboardArrowLeft className="text-3xl" /></div>
            <div className="grow flex justify-stretch items-center gap-5">
                {
                    courses.map((course, index) => {
                        return <Fragment key={index}>
                            <a href="#" className="outline-0">{course}</a>
                        </Fragment>
                    })
                }
            </div>
            <div className="flex justify-center items-center"><MdKeyboardArrowRight className="text-3xl" /></div>
        </section>
    </>
}

export default Courses