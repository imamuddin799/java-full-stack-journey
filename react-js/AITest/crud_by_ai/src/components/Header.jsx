// components/Header.jsx
import { useState, useEffect } from "react";
import { validateStudent } from "../utils/validate";

const Header = ({ students, setStudents }) => {
    const [isFormOpen, setIsFormOpen] = useState(false);
    const [formData, setFormData] = useState({});
    const [errors, setErrors] = useState({});
    const [touched, setTouched] = useState({}); // track if a field has been changed

    // Update form data and mark the field as touched
    const handleChange = (e) => {
        const updatedData = { ...formData, [e.target.name]: e.target.value };
        setFormData(updatedData);
        setTouched((prev) => ({ ...prev, [e.target.name]: true }));
    };

    const handleAddStudent = () => {
        setIsFormOpen(true);
    };

    const handleCloseForm = (e) => {
        e.preventDefault();
        setIsFormOpen(false);
        setFormData({});
        setErrors({});
        setTouched({});
    };

    // Re-validate whenever the formData changes
    useEffect(() => {
        setErrors(validateStudent(formData));
    }, [formData]);

    const handleSubmit = (e) => {
        e.preventDefault();
        const validationErrors = validateStudent(formData);
        if (Object.keys(validationErrors).length > 0) {
            setErrors(validationErrors);
            return;
        }
        setStudents([...students, formData]);
        setIsFormOpen(false);
        setFormData({});
        setErrors({});
        setTouched({});
    };

    // The form is valid if there are no errors and all fields have values.
    const isFormValid =
        Object.keys(errors).length === 0 &&
        formData.name &&
        formData.age &&
        formData.mobile &&
        formData.email;

    // Compute summary error based on an order. Only consider fields that have been touched.
    const errorOrder = ["name", "age", "mobile", "email"];
    const summaryErrorField = errorOrder.find(
        (field) => touched[field] && errors[field]
    );
    const summaryError = summaryErrorField ? errors[summaryErrorField] : null;

    return (
        <header className="header">
            <h1>Students</h1>
            <button onClick={handleAddStudent} className="btnAddStudent">
                Add Student
            </button>
            {isFormOpen && (
                <dialog open className="dialog">
                    <form onSubmit={handleSubmit} className="form">
                        <h2>Add Student Details</h2>
                        <div className="form-group">
                            <label htmlFor="name"><strong>Name:</strong></label>
                            <input
                                type="text"
                                name="name"
                                id="name"
                                onChange={handleChange}
                                value={formData.name || ""}
                            />
                            {/* Only show error if the field has been touched */}
                            {touched.name && errors.name && (
                                <span className="error">{errors.name}</span>
                            )}
                        </div>
                        <div className="form-group">
                            <label htmlFor="age"><strong>Age:</strong></label>
                            <input
                                type="text"
                                name="age"
                                id="age"
                                onChange={handleChange}
                                value={formData.age || ""}
                            />
                            {touched.age && errors.age && (
                                <span className="error">{errors.age}</span>
                            )}
                        </div>
                        <div className="form-group">
                            <label htmlFor="mobile"><strong>Mobile:</strong></label>
                            <input
                                type="text"
                                name="mobile"
                                id="mobile"
                                onChange={handleChange}
                                value={formData.mobile || ""}
                            />
                            {touched.mobile && errors.mobile && (
                                <span className="error">{errors.mobile}</span>
                            )}
                        </div>
                        <div className="form-group">
                            <label htmlFor="email"><strong>Email:</strong></label>
                            <input
                                type="email"
                                name="email"
                                id="email"
                                onChange={handleChange}
                                value={formData.email || ""}
                            />
                            {touched.email && errors.email && (
                                <span className="error">{errors.email}</span>
                            )}
                        </div>
                        {/* Summary error message: display the first error from touched fields */}
                        {summaryError && (
                            <div className="error summary-error">{summaryError}</div>
                        )}
                        <hr />
                        <div className="button-group">
                            <button type="submit" className="btnSubmit" disabled={!isFormValid}>
                                Submit
                            </button>
                            <button type="button" onClick={handleCloseForm} className="btnCancel">
                                Cancel
                            </button>
                        </div>
                    </form>
                </dialog>
            )}
        </header>
    );
};

export default Header;