import ButtonBlue from "./smallcomponents/ButtonBlue"
import video from '../assets/videos/liI-tvc-30s-eqs-wodp-wsf-weotr-16-9-vo-en-hqmaster-l-ending-h264-1-1.mp4'
import image from '../assets/images/imageye___-_1746543608983.jpg'

const Section4 = () => {
    return <>
        <section className="w-full flex flex-col justify-center items-center h-full">
            <div className="w-[84%] flex justify-center items-center gap-10 h-full">
                <div className="py-50 w-[50%] pr-20">
                    <h1 className="text-4xl w-full">DEFINING CLASS since 1886.</h1>
                    <p className='my-8'>A lot has changed since the invention of the automobile in 1886. With each decade, we have been able to further develop the technology that began with us - and still do today. This is how a car became more than a car.</p>
                    <ButtonBlue>Learn more</ButtonBlue>
                </div>
                <div className="h-[500px] w-[50%]">
                    <video src={video} controls className="h-full object-cover"></video>
                </div>
            </div>
            <div className="w-[84%] flex justify-center items-center gap-10 h-full">
                <div className="h-[500px] w-[50%]">
                    <img src={image} controls className="h-full object-cover" />
                </div>
                <div className="py-50 w-[50%] pl-20">
                    <h1 className="text-4xl w-full">History and brand world.</h1>
                    <p className='my-8'>The Mercedes star is more than just a logo. Mercedes-Benz stands for exciting experiences based on timeless design, cutting-edge technology and attention to detail.</p>
                    <ButtonBlue>Learn more</ButtonBlue>
                </div>
            </div>
        </section>
    </>
}

export default Section4