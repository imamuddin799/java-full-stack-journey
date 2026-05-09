// app/profile/page.tsx

import { getUserData } from "./actions";
import DeleteUserButton from "./DeleteUserButton";
import EditUserButton from "./EditUserButton";
export default async function ProfilePage({ params }: { params: Promise<{ id: string }> }) {
    // force fresh data on each request
    const { id } = await params;

    const res = await getUserData(id);

    if (!res.ok) {
        return <p className="text-red-500">Failed to load user profile</p>
    }

    const { data } = await res.json()
    const user = data[0]

    return (
        <div className="p-4 max-w-md mx-auto mt-10 bg-white rounded shadow">
            <h1 className="text-xl font-bold mb-2 text-black ">{user.username.toUpperCase()}</h1>
            <p className="text-gray-600">{user.email}</p>
            <p className="text-sm text-gray-500">ID: {user.id}</p>
            <p className="text-sm text-gray-500">Password: {user.password}</p>

            {/*  Edit + Delete */}
            <div className="flex gap-4 justify-start items-center">
                <EditUserButton user={user} />
                <DeleteUserButton userId={user.id} />
            </div>
        </div>
    )
}