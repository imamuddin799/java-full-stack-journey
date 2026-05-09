// components/Home.jsx
import { useState, useEffect } from "react";
import Header from "./Header";
import Nav from "./Nav";
import Table from "./Table";
import StudentCard from "./StudentCard";
import EditStudentDialog from "./EditStudentDialog";
import DeleteStudentDialog from "./DeleteStudentDialog";
import SearchSortBar from "./SearchSortBar";

const initialStudents = [
    {
        "name": "IMAMUDDIN ANSARI",
        "age": "23",
        "mobile": "7033534142",
        "email": "imamu033@gmail.com"
    },
    {
        "name": "Arish",
        "age": "22",
        "mobile": "7439725133",
        "email": "arish@gmail.com"
    },
    {
        "name": "Amir Khan",
        "age": "34",
        "mobile": "8765432109",
        "email": "amir@gmail.com"
    },
    {
        "name": "Zain Ali",
        "age": "26",
        "mobile": "8123456789",
        "email": "zain@gmail.com"
    },
    {
        "name": "Sara Sheikh",
        "age": "29",
        "mobile": "8976543210",
        "email": "sara@gmail.com"
    },
    {
        "name": "Kabir Ahmed",
        "age": "31",
        "mobile": "7654321098",
        "email": "kabir@gmail.com"
    },
    {
        "name": "Meera Kapoor",
        "age": "24",
        "mobile": "9098765432",
        "email": "meera@gmail.com"
    },
    {
        "name": "Nisha Verma",
        "age": "27",
        "mobile": "8503945678",
        "email": "nisha@gmail.com"
    },
    {
        "name": "Rahul Sharma",
        "age": "32",
        "mobile": "7812546039",
        "email": "rahul@gmail.com"
    },
    {
        "name": "Pooja Mishra",
        "age": "28",
        "mobile": "9345627189",
        "email": "pooja@gmail.com"
    },
    {
        "name": "Ayaan Malik",
        "age": "25",
        "mobile": "9823645892",
        "email": "ayaan@gmail.com"
    },
    {
        "name": "Simran Kaur",
        "age": "30",
        "mobile": "8974561208",
        "email": "simran@gmail.com"
    },
    {
        "name": "Rohan Gupta",
        "age": "27",
        "mobile": "7643210982",
        "email": "rohan@gmail.com"
    },
    {
        "name": "Ananya Bose",
        "age": "22",
        "mobile": "8210456738",
        "email": "ananya@gmail.com"
    },
    {
        "name": "Varun Mehta",
        "age": "33",
        "mobile": "9871234506",
        "email": "varun@gmail.com"
    },
    {
        "name": "Shreya Patil",
        "age": "26",
        "mobile": "8112456789",
        "email": "shreya@gmail.com"
    },
    {
        "name": "Vikas Singh",
        "age": "31",
        "mobile": "9223456781",
        "email": "vikas@gmail.com"
    },
    {
        "name": "Fatima Shaikh",
        "age": "24",
        "mobile": "7023654987",
        "email": "fatima@gmail.com"
    },
    {
        "name": "Rajeev Kumar",
        "age": "35",
        "mobile": "8392745610",
        "email": "rajeev@gmail.com"
    },
    {
        "name": "Sneha Joshi",
        "age": "27",
        "mobile": "6789234512",
        "email": "sneha@gmail.com"
    },
    {
        "name": "Kunal Thakur",
        "age": "30",
        "mobile": "9018745623",
        "email": "kunal@gmail.com"
    },
    {
        "name": "Divya Narayan",
        "age": "28",
        "mobile": "7932456012",
        "email": "divya@gmail.com"
    },
    {
        "name": "Anil Yadav",
        "age": "33",
        "mobile": "8345691023",
        "email": "anil@gmail.com"
    },
    {
        "name": "Reema Chauhan",
        "age": "29",
        "mobile": "6782134509",
        "email": "reema@gmail.com"
    },
    {
        "name": "Saurabh Sen",
        "age": "32",
        "mobile": "9037482165",
        "email": "saurabh@gmail.com"
    },
    {
        "name": "Ritika Rao",
        "age": "26",
        "mobile": "8392105674",
        "email": "ritika@gmail.com"
    },
    {
        "name": "Mohit Choudhary",
        "age": "30",
        "mobile": "7204591368",
        "email": "mohit@gmail.com"
    },
    {
        "name": "Sana Iqbal",
        "age": "24",
        "mobile": "6789104325",
        "email": "sana@gmail.com"
    },
    {
        "name": "Ashish Tripathi",
        "age": "35",
        "mobile": "9023416785",
        "email": "ashish@gmail.com"
    },
    {
        "name": "Neha Sharma",
        "age": "28",
        "mobile": "7896542130",
        "email": "neha@gmail.com"
    },
    {
        "name": "Vivek Joshi",
        "age": "32",
        "mobile": "8456721390",
        "email": "vivek@gmail.com"
    },
    {
        "name": "Priya Kapoor",
        "age": "27",
        "mobile": "9345678012",
        "email": "priya@gmail.com"
    },
    {
        "name": "Arjun Mehta",
        "age": "31",
        "mobile": "7839024561",
        "email": "arjun@gmail.com"
    },
    {
        "name": "Maya Singh",
        "age": "29",
        "mobile": "6891234750",
        "email": "maya@gmail.com"
    },
    {
        "name": "Rohan Das",
        "age": "33",
        "mobile": "9745632108",
        "email": "rohan@gmail.com"
    },
    {
        "name": "Aditi Rao",
        "age": "25",
        "mobile": "8912546780",
        "email": "aditi@gmail.com"
    },
    {
        "name": "Manish Tiwari",
        "age": "34",
        "mobile": "7208412365",
        "email": "manish@gmail.com"
    },
    {
        "name": "Tara Sharma",
        "age": "26",
        "mobile": "7896520143",
        "email": "tara@gmail.com"
    },
    {
        "name": "Rahul Chauhan",
        "age": "29",
        "mobile": "9023675148",
        "email": "rahul.chauhan@gmail.com"
    },
    {
        "name": "Ishita Verma",
        "age": "27",
        "mobile": "6784230159",
        "email": "ishita@gmail.com"
    },
    {
        "name": "Sanjay Reddy",
        "age": "31",
        "mobile": "7451203698",
        "email": "sanjay@gmail.com"
    },
    {
        "name": "Priyanka Das",
        "age": "30",
        "mobile": "8136490275",
        "email": "priyanka@gmail.com"
    },
    {
        "name": "Harsh Mehta",
        "age": "28",
        "mobile": "9345678130",
        "email": "harsh@gmail.com"
    },
    {
        "name": "Arpita Ghosh",
        "age": "26",
        "mobile": "8923410675",
        "email": "arpita@gmail.com"
    },
    {
        "name": "Yash Sharma",
        "age": "33",
        "mobile": "7896542310",
        "email": "yash@gmail.com"
    }
];

const Home = () => {
    const [view, setView] = useState("list");
    const [students, setStudents] = useState(initialStudents);
    const [selectedStudent, setSelectedStudent] = useState(null);
    const [editStudentForm, setEditStudentForm] = useState({});
    const [selectedToDelete, setSelectedToDelete] = useState(null);
    const [sortBy, setSortBy] = useState("");
    const [searchQuery, setSearchQuery] = useState("");

    // Process the student list by first sorting, then filtering out unmatched items if a search query is present.
    const getProcessedStudents = () => {
        let list = [...students];
        if (sortBy) {
            list.sort((a, b) => {
                if (sortBy === "age") {
                    return Number(a.age) - Number(b.age);
                } else {
                    return a[sortBy].localeCompare(b[sortBy]);
                }
            });
        }
        if (searchQuery.trim() !== "") {
            const lowerSearch = searchQuery.toLowerCase();
            list = list.filter(student =>
                student.name.toLowerCase().includes(lowerSearch) ||
                student.age.toString().toLowerCase().includes(lowerSearch) ||
                student.mobile.toLowerCase().includes(lowerSearch) ||
                student.email.toLowerCase().includes(lowerSearch)
            );
        }
        return list;
    };

    const processedStudents = getProcessedStudents();

    // Existing functions for editing and deleting...
    const handleCancelEdit = () => {
        setSelectedStudent(null);
    };

    const handleCancelDelete = () => {
        setSelectedToDelete(null);
    };

    const handleConfirmDelete = () => {
        setStudents(prev =>
            prev.filter(student => student.email !== selectedToDelete.email)
        );
        setSelectedToDelete(null);
    };

    const handleSaveEdit = (e) => {
        e.preventDefault();
        setStudents(prev =>
            prev.map(student =>
                student.email === selectedStudent.email ? editStudentForm : student
            )
        );
        setSelectedStudent(null);
    };

    const handleChangeEdit = (e) => {
        setEditStudentForm(prev => ({ ...prev, [e.target.name]: e.target.value }));
    };

    useEffect(() => {
        if (selectedStudent) {
            setEditStudentForm(selectedStudent);
        }
    }, [selectedStudent]);

    useEffect(() => {
        console.log("Current students:", students);
    }, [students]);

    return (
        <div className="home">
            <Nav view={view} setView={setView} />
            {/* Search and sort bar */}
            <SearchSortBar
                onSearch={setSearchQuery}
                onSortChange={setSortBy}
                currentSort={sortBy}
            />
            <div className={view === "list" ? "detailsList" : "detailsCard"}>
                <Header students={students} setStudents={setStudents} />
                {view === "list" ? (
                    <Table
                        students={processedStudents}
                        setSelectedStudent={setSelectedStudent}
                        setSelectedToDelete={setSelectedToDelete}
                        searchQuery={searchQuery}
                    />
                ) : (
                    <StudentCard
                        students={processedStudents}
                        setSelectedStudent={setSelectedStudent}
                        setSelectedToDelete={setSelectedToDelete}
                        searchQuery={searchQuery}
                    />
                )}
            </div>
            {selectedStudent && (
                <EditStudentDialog
                    student={selectedStudent}
                    formData={editStudentForm}
                    handleChange={handleChangeEdit}
                    handleCancel={handleCancelEdit}
                    handleSave={handleSaveEdit}
                />
            )}
            {selectedToDelete && (
                <DeleteStudentDialog
                    student={selectedToDelete}
                    handleCancel={handleCancelDelete}
                    handleConfirm={handleConfirmDelete}
                />
            )}
        </div>
    );
};

export default Home;