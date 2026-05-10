import { Link } from "react-router-dom";

function MyErrorPage() {
    return (
        <div style={{ padding: 20 }}>
            <h2>Route not found</h2>
            <Link href="/">Go Home</Link>
        </div>
    );
}

export default MyErrorPage;