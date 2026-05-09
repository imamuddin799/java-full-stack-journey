import React, { useState, useEffect, Fragment } from 'react';

const Form3 = () => {
    const [projectName, setProjectName] = useState('');
    const [rate, setRate] = useState('');
    const [billingType, setBillingType] = useState('Hourly');
    const [deadline, setDeadline] = useState({ month: 'November', day: '12', year: '2015' });
    const [validDays, setValidDays] = useState([]);
    const [priority, setPriority] = useState('High');
    const [required, setRequired] = useState('Design & Implementation');

    const months = [
        'January', 'February', 'March', 'April', 'May', 'June',
        'July', 'August', 'September', 'October', 'November', 'December'
    ];
    const years = Array.from({ length: 30 }, (_, i) => `${2000 + i}`);

    const isLeapYear = (year) => {
        return (year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0));
    };

    const priorityOptions = ['High', 'Medium', 'Low'];

    const getDaysInMonth = (month, year) => {
        const monthIndex = months.indexOf(month);
        if (monthIndex === 1) {
            return isLeapYear(parseInt(year)) ? 29 : 28;
        }
        const monthsWith30 = [3, 5, 8, 10];
        return monthsWith30.includes(monthIndex) ? 30 : 31;
    };

    useEffect(() => {
        const maxDays = getDaysInMonth(deadline.month, deadline.year);
        const newDays = Array.from({ length: maxDays }, (_, i) => `${i + 1}`);
        setValidDays(newDays);

        if (parseInt(deadline.day) > maxDays) {
            setDeadline({ ...deadline, day: `${maxDays}` });
        }
    }, [deadline.month, deadline.year]);

    const handleSubmit = (e) => {
        e.preventDefault();
        const formData = {
            projectName,
            rate,
            billingType,
            deadline: `${deadline.day}-${deadline.month}-${deadline.year}`,
            required,
            priority
        };
        console.log("Submitted Data:", formData);
    };

    return (<>
        <section className='w-screen h-screen flex justify-center items-center'>
            <form onSubmit={handleSubmit} className="w-1/2 mx-auto bg-white shadow-[0_0_20px_#000]">
                <div className='p-6'>
                    <h2 className="text-xl font-semibold mb-4 text-center">Create a New Project</h2>

                    <div className="mb-4 flex gap-4">
                        <div className='w-full'>
                            <label className="block font-medium mb-1 text-[#666666]">Project Name</label>
                            <input
                                type="text"
                                className="w-full bg-[#cdcdcd] px-3 py-2 outline-0 font-medium"
                                value={projectName}
                                onChange={(e) => setProjectName(e.target.value)}
                                required
                            />
                        </div>
                        <div className="w-full flex gap-2 mb-4">
                            <div className="flex-1">
                                <label className="block font-medium mb-1 text-[#666666]">Rate</label>
                                <input
                                    type="number"
                                    className="w-full bg-[#cdcdcd] px-3 py-2 outline-0 font-medium"
                                    value={rate}
                                    onChange={(e) => setRate(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="w-40">
                                <label className="block font-medium mb-1 text-[#666666]">Billing</label>
                                <select
                                    className="w-full bg-[#cdcdcd] px-3 py-2 outline-0 font-medium"
                                    value={billingType}
                                    onChange={(e) => setBillingType(e.target.value)}
                                >
                                    <option>Hourly</option>
                                    <option>Fixed</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div className="mb-4 flex gap-4">
                        <div className="mb-4 w-[55%]">
                            <label className="block font-medium mb-1 text-[#666666]">Deadline</label>
                            <div className="flex gap-2">
                                <select
                                    className="w-[50%] bg-[#cdcdcd] px-3 py-2 outline-0 font-medium"
                                    value={deadline.month}
                                    onChange={(e) => setDeadline({ ...deadline, month: e.target.value })}
                                >
                                    {months.map((m) => (
                                        <option key={m}>{m}</option>
                                    ))}
                                </select>

                                <select
                                    className="w-[22%] bg-[#cdcdcd] px-3 py-2 outline-0 font-medium"
                                    value={deadline.day}
                                    onChange={(e) => setDeadline({ ...deadline, day: e.target.value })}
                                >
                                    {validDays.map((d) => (
                                        <option key={d}>{d}</option>
                                    ))}
                                </select>

                                <select
                                    className="w-[28%] bg-[#cdcdcd] px-1 py-2 outline-0 font-medium"
                                    value={deadline.year}
                                    onChange={(e) => setDeadline({ ...deadline, year: e.target.value })}
                                >
                                    {years.map((y) => (
                                        <option key={y}>{y}</option>
                                    ))}
                                </select>
                            </div>
                        </div>

                        <div className="mb-4 w-[45%]">
                            <label className="block font-medium mb-1 text-[#666666]">Required</label>
                            <select
                                className="w-full bg-[#cdcdcd] px-3 py-2 outline-0 font-medium"
                                value={deadline.year}
                                onChange={(e) => setRequired(e.target.value)}
                            >
                                <option value='Design & Implementation'>Design & Implementation</option>
                            </select>
                        </div>
                    </div>

                    <div className="w-40 mb-4">
                        <label className="block font-medium mb-1 text-[#666666]">Priority</label>
                        <div className="flex items-center pl-3  bg-[#cdcdcd]">
                            <span
                                className={`h-3 w-3 rounded-full ${priority === 'High'
                                    ? 'bg-red-500'
                                    : priority === 'Medium'
                                        ? 'bg-yellow-500'
                                        : 'bg-green-500'
                                    }`}
                            ></span>
                            <select
                                className="w-full bg-[#cdcdcd] px-3 py-2 outline-0 font-medium"
                                value={priority}
                                onChange={(e) => setPriority(e.target.value)}
                            >
                                {
                                    priorityOptions.map((p, index) => (<Fragment key={index}>
                                        <option value={p}>{p}</option>
                                    </Fragment>
                                    ))
                                }
                            </select>
                        </div>
                    </div>

                    <div className="mb-4 flex gap-4">
                        <div className='w-full'>
                            <h1 className="block font-medium mb-1 text-[#666666]">Team</h1>
                            <div className='flex justify-start gap-2'>
                                <div className='w-[50px] rounded-[50%] flex justify-center items-center bg-gray-300'>+</div>
                                <img src="https://i.pravatar.cc/100" alt="" className='border w-[50px] rounded-[50%]' />
                                <img src="https://i.pravatar.cc/100" alt="" className='border w-[50px] rounded-[50%]' />
                                <img src="https://i.pravatar.cc/100" alt="" className='border w-[50px] rounded-[50%]' />
                                <img src="https://i.pravatar.cc/100" alt="" className='border w-[50px] rounded-[50%]' />
                                <img src="https://i.pravatar.cc/100" alt="" className='border w-[50px] rounded-[50%]' />
                            </div>
                        </div>
                    </div>
                </div>

                <div className="flex justify-between mt-6">
                    <button type="button" className="w-full px-10 py-4 bg-gray-700 text-white text-left cursor-pointer hover:bg-gray-900">
                        Cancel
                    </button>
                    <button type="submit" className="w-full px-10 py-4 bg-blue-600 text-white text-right cursor-pointer hover:bg-blue-700">
                        Create
                    </button>
                </div>
            </form>
        </section>
    </>

    );
};

export default Form3;
