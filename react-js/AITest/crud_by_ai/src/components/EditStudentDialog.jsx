// components/EditStudentDialog.jsx
import { useState, useEffect } from "react";
import { validateStudent } from "../utils/validate";

const EditStudentDialog = ({
    student,
    formData,
    handleChange,
    handleCancel,
    handleSave,
}) => {
    const [errors, setErrors] = useState({});
    const [touched, setTouched] = useState({});

    // Local wrapper to mark a field as touched when it changes
    const handleLocalChange = (e) => {
        handleChange(e);
        setTouched((prev) => ({ ...prev, [e.target.name]: true }));
    };

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
        handleSave(e);
        setErrors({});
        setTouched({});
    };

    const isFormValid =
        Object.keys(errors).length === 0 &&
        formData.name &&
        formData.age &&
        formData.mobile &&
        formData.email;

    const errorOrder = ["name", "age", "mobile", "email"];
    const summaryErrorField = errorOrder.find(
        (field) => touched[field] && errors[field]
    );
    const summaryError = summaryErrorField ? errors[summaryErrorField] : null;

    return (
        <dialog open className="dialog">
            <form onSubmit={handleSubmit} className="form">
                <h2>Edit Student Details</h2>
                <div className="form-group">
                    <label htmlFor="name"><strong>Name:</strong></label>
                    <input
                        type="text"
                        name="name"
                        id="name"
                        value={formData.name || ""}
                        onChange={handleLocalChange}
                    />
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
                        value={formData.age || ""}
                        onChange={handleLocalChange}
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
                        value={formData.mobile || ""}
                        onChange={handleLocalChange}
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
                        value={formData.email || ""}
                        onChange={handleLocalChange}
                        disabled
                    />
                    {/* Email is non-editable; no inline error needed */}
                </div>
                {/* Summary error message */}
                {summaryError && (
                    <div className="error summary-error">{summaryError}</div>
                )}
                <hr />
                <div className="button-group">
                    <button type="submit" className="btnSubmit" disabled={!isFormValid}>
                        Update
                    </button>
                    <button type="button" className="btnCancel" onClick={handleCancel}>
                        Cancel
                    </button>
                </div>
            </form>
        </dialog>
    );
};

export default EditStudentDialog;