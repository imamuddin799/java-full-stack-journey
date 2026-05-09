
const Card1 = (props) => {
    let { image, title} = props
    return <>
        <div className="border border-[#999] rounded-lg pt-2 flex flex-col justify-center items-center hover:scale-110 transition-all duration-2000 ease-in-out">
            <img src={image} alt="" />
            <h1>{title}</h1>
        </div>
    </>
}

export default Card1