import React from 'react'
import { Fragment } from 'react';
import { useState } from 'react';

let employeeDetails = [
    {
        EmpName: "Amit Sharma",
        EmpId: "EMP101",
        salary: 55000,
        designation: "Software Engineer",
        dateOfJoining: "2021-06-15"
    },
    {
        EmpName: "Sneha Verma",
        EmpId: "EMP102",
        salary: 60000,
        designation: "UI/UX Designer",
        dateOfJoining: "2022-01-10"
    },
    {
        EmpName: "Ravi Kumar",
        EmpId: "EMP103",
        salary: 75000,
        designation: "Project Manager",
        dateOfJoining: "2019-03-25"
    },
    {
        EmpName: "Neha Singh",
        EmpId: "EMP104",
        salary: 48000,
        designation: "Quality Analyst",
        dateOfJoining: "2023-04-12"
    },
    {
        EmpName: "Karan Mehta",
        EmpId: "EMP105",
        salary: 67000,
        designation: "DevOps Engineer",
        dateOfJoining: "2020-09-05"
    },
    {
        EmpName: "Anjali Das",
        EmpId: "EMP106",
        salary: 51000,
        designation: "Backend Developer",
        dateOfJoining: "2022-07-18"
    },
    {
        EmpName: "Vikram Rao",
        EmpId: "EMP107",
        salary: 82000,
        designation: "Tech Lead",
        dateOfJoining: "2018-11-30"
    },
    {
        EmpName: "Priya Nair",
        EmpId: "EMP108",
        salary: 58000,
        designation: "Frontend Developer",
        dateOfJoining: "2021-02-22"
    },
    {
        EmpName: "Siddharth Jain",
        EmpId: "EMP109",
        salary: 49000,
        designation: "Support Engineer",
        dateOfJoining: "2023-05-08"
    },
    {
        EmpName: "Ruchi Kapoor",
        EmpId: "EMP110",
        salary: 62000,
        designation: "Business Analyst",
        dateOfJoining: "2020-12-01"
    }
];

const Employee = () => {

    let [employees, setEmployee] = useState(employeeDetails)
    return (
        <table border={"2px solid"}>
            <tr>
                <td>Name</td>
                <td>Id</td>
                <td>Salary</td>
                <td>Designation</td>
                <td>Date Of Joining</td>
            </tr>
            {
                employees.map((element, index) => {
                    let { EmpName, EmpId, salary, designation, dateOfJoining } = element
                    return <Fragment key={index}>
                        <tr>
                            <td>{EmpName}</td>
                            <td>{EmpId}</td>
                            <td>{salary}</td>
                            <td>{designation}</td>
                            <td>{dateOfJoining}</td>
                        </tr>
                    </Fragment>
                })
            }
        </table>
    )
}

export default Employee