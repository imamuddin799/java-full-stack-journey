import { useState } from "react";

let Header = (props) => {

    let [jsonobj, setJsonobj] = props.data;
    let [formStatus, setFormStatus] = useState(false);
    let [formData, setFormData] = useState({});

    let handleChange = (event) => {
        // console.log(event);
        // console.log(event.target);
        // console.log(event.target.name);
        // console.log(event.target.value);

        setFormData({ ...formData, [event.target.name]: event.target.value });
    }

    let handleAddStudent = () => {
        setFormStatus(true);
    }

    let handleFormClose = (event) => {
        event.preventDefault();
        setFormStatus(false)
    }

    let handleAddFormSubmit = (e) => {
        e.preventDefault();
        // console.log("form submitted");
        // console.log(e);
        // console.log(formData);
        // console.log(jsonobj);
        setJsonobj([...jsonobj, formData]);
        // console.log(jsonobj);
        setFormStatus(false);
    }

    return <>
        <div id="header">
            <h1>Students</h1>
            <button id="btnAddStudent" onClick={handleAddStudent}>Add Student</button>
            {formStatus && (
                <dialog open>
                    <form onSubmit={handleAddFormSubmit}>
                        <h2>Add Student Details</h2>
                        <div>
                            <label htmlFor="name"><strong>Name:</strong></label>
                            <input type="text" name="name" id="name" onChange={handleChange} />
                        </div>
                        <div>
                            <label htmlFor="age"><strong>Age:</strong></label>
                            <input type="text" name="age" id="age" onChange={handleChange} />
                        </div>
                        <div>
                            <label htmlFor="mobile"><strong>Mobile:</strong></label>
                            <input type="text" name="mobile" id="mobile" onChange={handleChange} />
                        </div>
                        <div>
                            <label htmlFor="email"><strong>Email:</strong></label>
                            <input type="email" name="email" id="email" onChange={handleChange} />
                        </div>
                        <hr />
                        <div>
                            <button className="btnSubmit" type="submit">Submit</button>
                            <button className="btnCancle" type="button" onClick={handleFormClose}>Cancle</button>
                        </div>
                    </form>
                </dialog>
            )}
        </div>
    </>
}
export default Header;