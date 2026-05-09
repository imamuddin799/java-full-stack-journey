import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const SecondSingleUser = () => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  let { id } = useParams();

  const getUser = async () => {
    try {
      setLoading(true);
      const response = await fetch(`https://fakestoreapi.com/users/${id}`);
      if (!response.ok) {
        throw new Error("Failed to fetch user data");
      }
      const data = await response.json();
      setUser(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    getUser();
  }, [id]);

  if (loading) {
    return (
      <div className="flex justify-center items-center h-full">
        <p className="text-gray-500 text-lg">Loading user data...</p>
      </div>
    );
  }

  if (error) {
    return (
      <div className="flex justify-center items-center h-full">
        <p className="text-red-500 text-lg">{error}</p>
      </div>
    );
  }

  if (!user) {
    return null;
  }

  const { email, name, password, phone, username, address } = user;

  return (
    <div className="max-w-4xl mx-auto mt-10 p-8 bg-gradient-to-r from-blue-50 to-white rounded-xl shadow-lg border border-blue-200">
      <h2 className="text-3xl font-extrabold mb-8 text-center text-blue-900 tracking-wide">
        User Profile
      </h2>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-10">
        <div className="space-y-4">
          <UserInfo label="ID" value={id} />
          <UserInfo label="Username" value={username} />
          <UserInfo label="Full Name" value={`${name?.firstname} ${name?.lastname}`} />
          <UserInfo label="Email" value={email} />
          <UserInfo label="Phone" value={phone} />
          <UserInfo label="Password" value={password} />
        </div>
        <div className="space-y-4">
          <h3 className="text-xl font-semibold text-blue-800 border-b border-blue-300 pb-2">
            Address
          </h3>
          <UserInfo label="City" value={address?.city} />
          <UserInfo label="Street" value={address?.street} />
          <UserInfo label="Number" value={address?.number} />
          <UserInfo label="ZipCode" value={address?.zipcode} />
          <UserInfo
            label="Geolocation"
            value={`${address?.geolocation?.lat}, ${address?.geolocation?.long}`}
          />
        </div>
      </div>
    </div>
  );
};

const UserInfo = ({ label, value }) => (
  <div className="flex justify-between bg-white rounded-md shadow-sm p-4 border border-gray-200 hover:shadow-md transition-shadow duration-300">
    <span className="font-semibold text-gray-700">{label}:</span>
    <span className="text-gray-900 break-words">{value || "N/A"}</span>
  </div>
);

export default SecondSingleUser;