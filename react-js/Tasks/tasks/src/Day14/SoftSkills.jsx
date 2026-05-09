
import { Fragment } from 'react';
import { useState } from 'react';

let softSkills = [
    "Communication",
    "Teamwork",
    "Problem-solving",
    "Time Management",
    "Adaptability",
    "Critical Thinking",
    "Leadership",
    "Emotional Intelligence",
    "Conflict Resolution",
    "Creativity",
    "Work Ethic",
    "Decision Making",
    "Interpersonal Skills",
    "Active Listening"
];

const SoftSkills = () => {

    let [softSkill, setSoftSkills] = useState(softSkills);

    return (
        <>
            <h1>Soft Skills</h1>
            {
                softSkill.map((element, index) => {
                    return <Fragment key={index}>
                        <h2>{element}</h2>
                    </Fragment>
                })
            }
        </>
    )
}

export default SoftSkills