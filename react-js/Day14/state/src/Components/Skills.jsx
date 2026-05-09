import { Fragment, useState } from "react"

let Skills = () => {
    let [skills, setSkills] = useState(["HTML", "CSS", "JS", , "TAILWIND", "BOOTSTRAP"]);

    console.log(skills);

    return <>
        {
            skills.map((element, index) => {
                return <Fragment key={index}>
                    <h1>{element}</h1>
                </Fragment>
            })
        }
    </>
}
export default Skills;