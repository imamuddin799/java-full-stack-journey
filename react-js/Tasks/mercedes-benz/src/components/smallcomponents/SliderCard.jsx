import Button2 from './Button2'

const SliderCard = ({ image, heading, para, buttonDetails }) => {
    return <>
        <div className="w-full">
            <div className='w-full'>
                <img src={image} alt="" className='w-full object-contain' />
            </div>
            <h2 className='text-lg font-medium my-5'>{heading}</h2>
            <p className='text-lg my-4'>{para}</p>
            <Button2>{buttonDetails}</Button2>
        </div>
    </>
}

export default SliderCard