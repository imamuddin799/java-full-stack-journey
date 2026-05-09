
import React from "react";

const WithAuthorization = (WrappedComponent) => {
    console.log(WrappedComponent);
    const AuthorizedComponent = (props) => {
        const { userRole, ...rest } = props;
        if (userRole !== "admin") {
            return <div>Access Denied.</div>;
        }
        return <WrappedComponent {...rest} />;
    };

    return AuthorizedComponent;
};

export default WithAuthorization;