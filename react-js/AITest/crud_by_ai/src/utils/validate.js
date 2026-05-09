// utils/validate.js
export const validateStudent = (formData) => {
    const errors = {};

    // Validate name
    if (!formData.name || formData.name.trim() === "") {
        errors.name = "Name is required";
    }

    // Validate age: must be present and numeric
    if (!formData.age || formData.age.trim() === "") {
        errors.age = "Age is required";
    } else if (isNaN(formData.age)) {
        errors.age = "Age must be numeric";
    }

    // Validate mobile: must be present and exactly 10 digits
    if (!formData.mobile || formData.mobile.trim() === "") {
        errors.mobile = "Mobile number is required";
    } else if (!/^\d{10}$/.test(formData.mobile)) {
        errors.mobile = "Mobile must be 10 digits";
    }

    // Validate email: must be present and in valid format
    if (!formData.email || formData.email.trim() === "") {
        errors.email = "Email is required";
    } else if (!/\S+@\S+\.\S+/.test(formData.email)) {
        errors.email = "Email format is invalid";
    }

    return errors;
};