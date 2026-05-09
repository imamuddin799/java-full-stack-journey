import emily from '../../assets/landingpage/images/image-emily.jpg'
import thomas from '../../assets/landingpage/images/image-thomas.jpg'
import jennie from '../../assets/landingpage/images/image-jennie.jpg'

let Testimonials = () => {
    return <>
        <section className="w-full h-screen flex justify-center items-center">
            <div className="w-[77%]">
                <div>
                    <h1 className='text-center text-2xl font-bold tracking-widest text-gray-400 mb-20'>CLIENT TESTIMONIALS</h1>
                </div>
                <div className='flex justify-between items-center gap-10'>
                    <div className='flex flex-col justify-start items-center gap-15'>
                        <img src={emily} alt="" className='max-w-[80px] rounded-[50%]' />
                        <p className='text-center text-lg font-medium text-gray-600'>We put our trust in Sunnyside and they delivered, making sure our needs were met and deadlines were always hit.</p>
                        <div className='flex flex-col justify-start items-center'>
                            <h1 className='text-xl font-bold my-2'>Emily R.</h1>
                            <p className='font-medium text-gray-400'>Marketing Director</p>
                        </div>
                    </div>
                    <div className='flex flex-col justify-start items-center gap-15'>
                        <img src={thomas} alt="" className='max-w-[80px] rounded-[50%]' />
                        <p className='text-center text-lg font-medium text-gray-600'>We put our trust in Sunnyside and they delivered, making sure our needs were met and deadlines were always hit.</p>
                        <div className='flex flex-col justify-start items-center'>
                            <h1 className='text-xl font-bold my-2'>Thomas S.</h1>
                            <p className='font-medium text-gray-400'>Chief Operating Officer</p>
                        </div>
                    </div>
                    <div className='flex flex-col justify-start items-center gap-15'>
                        <img src={jennie} alt="" className='max-w-[80px] rounded-[50%]' />
                        <p className='text-center text-lg font-medium text-gray-600'>We put our trust in Sunnyside and they delivered, making sure our needs were met and deadlines were always hit.</p>
                        <div className='flex flex-col justify-start items-center'>
                            <h1 className='text-xl font-bold my-2'>Jennie F.</h1>
                            <p className='font-medium text-gray-400'>Business Owner</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </>
}

export default Testimonials