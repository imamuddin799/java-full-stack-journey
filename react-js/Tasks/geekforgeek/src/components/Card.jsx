
import grow from '../assets/images/grow.svg'
import ibm from '../assets/images/ibm.png'
import level from '../assets/images/level.svg'
import rating from '../assets/images/rating.svg'
import star from '../assets/images/star.png'


const Card = (props) => {

    let { imageUrl, noOfGeeks, courseName, rating: rate, level: lev, recommend, com, seats } = props.data

    return <>
        <div className="border border-gray-300 flex flex-col justify-between items-center rounded-sm hover:scale-105 transition-all duration-200">
            <div className="w-full">
                <div className="w-full relative">
                    <img src={imageUrl} alt="" className="w-full rounded-sm" />
                    {
                        recommend && <p className="w-full absolute bottom-0 text-center text-xs p-1 bg-[#354A25] text-white">Recommended for working professional</p>
                    }
                </div>
                <div className="flex justify-between items-center my-3">
                    <div className="flex items-center">
                        <img src={grow} alt="" className="opacity-75" />
                        <p className="text-xs"><span>{noOfGeeks}</span> interested Geeks</p>
                    </div>
                    <div className="flex justify-end items-center gap-1 border border-gray-300 mr-3 rounded ">
                        {!!rate && (<>
                            <img src={star} alt="" />
                            <span className="text-sm">{rate}</span>
                        </>)}
                    </div>
                </div>
                <div className="px-2 w-full my-3">
                    <h1 className="font-medium">{courseName}</h1>
                </div>
                <div className="flex justify-start items-center mx-2 my-3 w-full">
                    <img src={level} alt="" className="opacity-75" />
                    <p className="text-xs text-gray-700">{lev}</p>
                </div>
                <div className="flex justify-between items-center mx-2 my-3">
                    <div className="flex gap-1">
                        {
                            seats && (<>
                                <img src={rating} alt="" />
                                <span className="text-[#DE7C04] text-xs font-medium">{seats} seats left</span>
                            </>)
                        }
                    </div>
                    <div className="max-h-[25px]">
                        {
                            com && <img src={com} alt="" />
                        }
                    </div>
                </div>
            </div>
            <div className="w-full text-center p-3 my-3">
                <button className="w-full bg-[#FFD700] font-medium p-1 rounded text-sm cursor-pointer">Avail Discount</button>
            </div>
        </div>
    </>
}
export default Card