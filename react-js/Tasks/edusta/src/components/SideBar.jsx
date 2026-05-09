
import logo from '../assets/images/home/download.svg'

const SideBar = () => {
    return <>
        <div className="border-2 border-red-700 bg-black text-white w-1/6 h-full flex flex-col justify-start items-start overflow-y-auto">
            <div className='border-b border-gray-700 w-full flex justify-start items-center'>
                <div className='p-4'>
                    <img src={logo} alt="" className='invert' />
                </div>
                <div className='flex flex-col justify-start items-start '>
                    <h1 className='text-xl/5 font-bold'>Edusta</h1>
                    <p className='text-sm text-gray-300'>Next Generation</p>
                </div>
            </div>
        </div>
    </>
}

export default SideBar