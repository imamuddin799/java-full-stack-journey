import { MdOutlineKeyboardArrowRight } from "react-icons/md";
// import grow from '../assets/images/grow.svg'
// import ibm from '../assets/images/ibm.png'
// import level from '../assets/images/level.svg'
// import rating from '../assets/images/rating.svg'
// import star from '../assets/images/star.png'
import { Fragment } from "react";
import Card from "./Card";

const Cards = (props) => {

    let { heading, cardDetails } = props.data;

    return <>
        {cardDetails.length >= 4 && (
            <div className="w-full my-12">
                <div className="flex justify-between my-3">
                    <div>
                        <h1 className="text-2xl font-medium">{heading}</h1>
                    </div>
                    <div className="flex justify-end items-center gap-2 font-medium">
                        <p>View All</p>
                        <div className="rounded-2xl bg-[#2F8D46]">
                            <MdOutlineKeyboardArrowRight className="text-white text-xs" />
                        </div>
                    </div>
                </div>
                <div className="grid grid-cols-4 gap-8">
                    {
                        cardDetails.map((item, index) => {
                            return <Fragment key={index}>
                                {
                                    index < 4 && <Card data={item} />
                                }
                            </Fragment>
                        })
                    }
                </div>
            </div>)
        }

        {cardDetails.length < 4 && (
            <div className="w-full my-12">
                <div className="flex justify-between my-3">
                    <div>
                        <h1 className="text-2xl font-medium">{heading}</h1>
                    </div>
                    {/* <div className="flex justify-end items-center gap-2 font-medium">
                        <p>View All</p>
                        <div className="rounded-2xl bg-[#2F8D46]">
                            <MdOutlineKeyboardArrowRight className="text-white text-xs" />
                        </div>
                    </div> */}
                </div>
                <div className="grid grid-cols-4 gap-8">
                    {
                        cardDetails.map((item, index) => {
                            return <Fragment key={index}>
                                <Card data={item} />
                            </Fragment>
                        })
                    }
                </div>
            </div>)
        }
    </>
}
export default Cards


// Card Template
// {/* <div className="border border-gray-300 flex flex-col justify-between items-center rounded-sm hover:scale-105 transition-all duration-200">
//                         <div className="w-full">
//                             <div className="w-full relative">
//                                 <img src="https://media.geeksforgeeks.org/img-practice/prod/courses/504/Mobile/Other/Course_DSA_to_Dev_1720846081.webp" alt="" className="w-full rounded-sm" />
//                                 <p className="w-full absolute bottom-0 text-center text-xs p-1 bg-[#354A25] text-white">Recommended for working professional</p>
//                             </div>
//                             <div className="flex justify-between items-center my-3">
//                                 <div className="flex items-center">
//                                     <img src={grow} alt="" className="opacity-75" />
//                                     <p className="text-xs"><span>569+</span> interested Geeks</p>
//                                 </div>
//                                 <div className="flex justify-end items-center gap-1 border border-gray-300 mr-3 rounded ">
//                                     <img src={star} alt="" />
//                                     <span className="text-sm">4.4</span>
//                                 </div>
//                             </div>
//                             <div className="px-2 w-full my-3">
//                                 <h1 className="font-medium">DSA to Development: A Complete Guide</h1>
//                             </div>
//                             <div className="flex justify-start items-center mx-2 my-3 w-full">
//                                 <img src={level} alt="" className="opacity-75" />
//                                 <p className="text-xs text-gray-700">Beginner</p>
//                             </div>
//                             <div className="flex justify-between items-center mx-2 my-3">
//                                 <div className="flex gap-1">
//                                     <img src={rating} alt="" />
//                                     <span className="text-[#DE7C04] text-xs font-medium">2 seats left</span>
//                                 </div>
//                                 <div className="max-h-[25px]">
//                                     <img src={ibm} alt="" />
//                                 </div>
//                             </div>

//                         </div>
//                         <div className="w-full text-center p-3 my-3">
//                             <button className="w-full bg-[#FFD700] font-medium p-1 rounded text-sm">Avail Discount</button>
//                         </div>
//                     </div> */}