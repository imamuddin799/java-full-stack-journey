// components/SearchSortBar.jsx
import { useState } from "react";

const SearchSortBar = ({ onSearch, onSortChange, currentSort }) => {
    const [searchInput, setSearchInput] = useState("");

    // Immediately update parent on every change (even for the first character)
    const handleInputChange = (e) => {
        const value = e.target.value;
        setSearchInput(value);
        onSearch(value); // Update parent's search query instantly
    };

    const handleSortChange = (e) => {
        onSortChange(e.target.value);
    };

    const handleSearch = () => {
        onSearch(searchInput);
    };

    return (
        <div className="search-sort-bar">
            <input
                type="text"
                placeholder="Search..."
                value={searchInput}
                onChange={handleInputChange}
            />
            <button onClick={handleSearch}>Search</button>
            <select value={currentSort} onChange={handleSortChange}>
                <option value="">Sort By</option>
                <option value="name">Name</option>
                <option value="age">Age</option>
                <option value="email">Email</option>
            </select>
        </div>
    );
};

export default SearchSortBar;
