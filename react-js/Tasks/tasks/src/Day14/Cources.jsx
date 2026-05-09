import React, { Fragment } from 'react'
import { useState } from 'react';

let availableCourses = [
    {
        courseName: "Java Full Stack",
        duration: "6 Months",
        fees: 42000,
        skills: ["sql", "Java", "html", "css", "js", "advance java"],
        trainers: ["Karishma ma'am", "Pavan sir", "Reshma ma'am", "Ravi sir"]
    },
    {
        courseName: "Python Full Stack",
        duration: "5 Months",
        fees: 32000,
        skills: ["sql", "Python", "html", "css", "js", "django"],
        trainers: ["Rewanth Reddy sir", "Rafiq sir", "Geeta ma'am", "Sagar sir"]
    },
    {
        courseName: "Testing",
        duration: "4 Months",
        fees: 26000,
        skills: ["sql", "Manual Testing", "selenium", "Automation", "api testing"],
        trainers: ["Karishma ma'am", "Kaushik sir", "Hemanth sir", "Nandini ma'am"]
    },
    {
        courseName: "Web Development",
        duration: "3 Months",
        fees: 28000,
        skills: ["html", "css", "js", "bootstrap", "react"],
        trainers: ["Sneha ma'am", "Raj sir", "Rohit sir", "Divya ma'am"]
    },
    {
        courseName: "Data Science",
        duration: "6 Months",
        fees: 50000,
        skills: ["Python", "Pandas", "Numpy", "Machine Learning", "Deep Learning"],
        trainers: ["Rohini ma'am", "Ibrahim sir", "Neha ma'am", "Anil sir"]
    },
    {
        courseName: "DevOps",
        duration: "4.5 Months",
        fees: 40000,
        skills: ["Linux", "AWS", "Docker", "Kubernetes", "CI/CD"],
        trainers: ["Rakesh sir", "Manoj sir", "Shweta ma'am", "Tanya ma'am"]
    },
    {
        courseName: "Android Development",
        duration: "5 Months",
        fees: 35000,
        skills: ["Java", "Kotlin", "Android Studio", "SQLite", "Firebase"],
        trainers: ["Arvind sir", "Monica ma'am", "Ritu ma'am", "Jatin sir"]
    },
    {
        courseName: "UI/UX Design",
        duration: "3.5 Months",
        fees: 30000,
        skills: ["Figma", "Adobe XD", "html", "css", "design thinking"],
        trainers: ["Simran ma'am", "Naveen sir", "Anuja ma'am", "Aakash sir"]
    }
];

const Cources = () => {

    let [courses, setCources] = useState(availableCourses);
    return (
        <table border="2px solid">
            <tr>
                <td>Cource</td>
                <td>Duraton</td>
                <td>Fees</td>
            </tr>
            {
                courses.map((element, index) => {
                    let { courseName, duration, fees } = element
                    return <Fragment key={index}>
                        <tr>
                            <td>{ courseName }</td>
                            <td>{ duration }</td>
                            <td>{fees}</td>
                        </tr>
                    </Fragment>
                })
            }
        </table>
    )
}

export default Cources