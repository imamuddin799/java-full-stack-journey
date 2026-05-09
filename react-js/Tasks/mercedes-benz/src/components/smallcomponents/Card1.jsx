import ButtonBlue from './ButtonBlue'
import LearnMore from './LearnMore'

let Card1 = ({ para, heading, buttonText, image, more, scale }) => {
    return <>
        <section className="w-full h-full">
            <div className="w-full h-full relative overflow-hidden group">
                <img src={image} alt="" className='object-cover transition-all duration-300 group-hover:scale-105' />
                <div className={`absolute inset-x-0 bottom-0 bg-gradient-to-t from-black via-black/90 to-transparent ${scale === 1 ? 'h-[50%]' : scale === 2 ? 'h-[70%]' : 'h-[50%]'}`}>
                    <div className='absolute bottom-0 text-white p-10 pb-20'>
                        <p className='text-lg mb-3'>{para}</p>
                        <h1 className='text-3xl mb-10'>{heading}</h1>
                        <div className='flex justify-start items-center gap-4'>
                            <ButtonBlue>{buttonText}</ButtonBlue>
                            {more && (<LearnMore>{more}</LearnMore>)}
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </>
}

export default Card1