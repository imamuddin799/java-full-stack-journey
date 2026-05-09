import image from '../assets/images/16 (1).svg'
const Section5 = () => {
    return <>
        <section className="w-full flex flex-col justify-center items-center h-full">
            <div className="w-[84%] flex flex-col justify-start items-start h-full">
                <h3 className="text-lg font-medium text-gray-600 my-7">Disclaimer</h3>
                <p className="text-[10px] text-gray-500 w-[70%] ">Accessories, colors and fitments shown may not be a part of standard specifications. For detailed technical specification and price of the model available in India, please refer to the product brochure or contact the nearest Mercedes-Benz Franchise Partner.</p>
            </div>
            <div className="w-[84%] flex justify-between items-center gap-10 h-full">
                <div className="border border-gray-400 w-full p-4 h-full flex justify-between items-start gap-3">
                    <div className="flex justify-start items-start w-full h-full">svg</div>
                    <div className="flex flex-col justify-start items-start w-full h-full">
                        <h2>heading</h2>
                        <p>paragraph</p>
                    </div>
                    <div className="flex justify-center items-center w-full h-full">
                        <img src={image} alt="arrow" className="w-6 self-center" />
                    </div>
                </div>
                <div className="border border-gray-400 w-full p-4 h-full flex justify-between items-start gap-3">
                    <div className="flex justify-start items-start w-full h-full">svg</div>
                    <div className="flex flex-col justify-start items-start w-full h-full">
                        <h2>heading</h2>
                        <p>paragraph</p>
                    </div>
                    <div className="flex justify-center items-center w-full h-full">
                        <img src="" alt="arrow" className="" />
                    </div>
                </div>
                <div className="border border-gray-400 w-full p-4 h-full flex justify-between items-start gap-3">
                    <div className="flex justify-start items-start w-full h-full">svg</div>
                    <div className="flex flex-col justify-start items-start w-full h-full">
                        <h2>heading</h2>
                        <p>paragraph</p>
                    </div>
                    <div className="flex justify-center items-center w-full h-full">
                        <img src="" alt="arrow" className="" />
                    </div>
                </div>
                <div className="border border-gray-400 w-full p-4 h-full flex justify-between items-start gap-3">
                    <div className="flex justify-start items-start w-full h-full">svg</div>
                    <div className="flex flex-col justify-start items-start w-full h-full">
                        <h2>heading</h2>
                        <p>paragraph</p>
                    </div>
                    <div className="flex justify-center items-center w-full h-full">
                        <img src="" alt="arrow" className="" />
                    </div>
                </div>
            </div>
        </section>
    </>
}

export default Section5