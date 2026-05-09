
const Card2 = ({ type, car }) => {
    return <>
        <div className="my-10 w-full relative bg-gradient-to-r from-slate-200 to-slate-50 p-5 flex">
            <div className='w-full'>
                <p className='font-medium'>Discover the models</p>
                <h1 className='text-3xl'>{type}</h1>
            </div>
            <div className='w-[60%] absolute -top-12 left-[40%]'>
                <img src={car} alt="" className='w-full' />
            </div>
        </div>
    </>
}

export default Card2