
const Nav = () => {
    return <>
        <nav className="w-[60%] flex justify-between items-center text-white pt-10">
            <aside>Get the App</aside>
            <aside className="flex gap-14">
                <button className="bg-white text-gray-700 py-2 px-4 rounded-[13px] cursor-pointer">Login</button>
                <button className="bg-white text-gray-700 py-2 px-4 rounded-[13px] cursor-pointer">SignUp</button>
            </aside>
        </nav>
    </>
}

export default Nav