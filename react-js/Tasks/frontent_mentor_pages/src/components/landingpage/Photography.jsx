import design from '../../assets/landingpage/images/desktop/image-graphic-design.jpg'
import photography from '../../assets/landingpage/images/desktop/image-photography.jpg'

const Photography = () => {
    return <>
        <section className="w-full flex justify-between items-start">
            <div className="w-[50%] relative">
                <img src={design} alt="" className='w-full h-full' />
                <div className='w-full absolute bottom-0 flex flex-col justify-center items-center'>
                    <div className='w-1/2 flex flex-col justify-center items-center mb-10'>
                        <h1 className='text-3xl font-bold mb-10'>Graghic Design</h1>
                        <p className='text-center font-medium'>Greate design makes you memorable. We deliver artwork that unserscores your brand message and captures potential clients' attention.</p>
                    </div>
                </div>
            </div>
            <div className="w-[50%] relative">
                <img src={photography} alt="" className='w-full h-full' />
                <div className='w-full absolute bottom-0 flex flex-col justify-center items-center'>
                    <div className='w-1/2 flex flex-col justify-center items-center mb-10'>
                        <h1 className='text-3xl font-bold mb-10 text-[#21554a]'>Photography</h1>
                        <p className='text-center font-medium'>Increase your credibility by getting the most stunning, high-quality photos that improve your business image.</p>
                    </div>
                </div>
            </div>
        </section>
    </>
}

export default Photography;