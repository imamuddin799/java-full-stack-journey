
const Card2 = (props) => {
    let { image, title } = props
    return <>
        <div className="flex flex-col justify-center items-center relative">
            <img src={image} alt="" className="w-full rounded-lg" />
            <h1 className="absolute bottom-4 left-7 text-white font-bold">{title}</h1>
        </div>
    </>
}

export default Card2