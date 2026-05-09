import Card1 from "./Card1";
import c1_1 from '../assets/images/c1-1.webp'
import c1_2 from '../assets/images/c1-2.webp'
import c1_3 from '../assets/images/c1-3.jpg'
import c1_4 from '../assets/images/c1-4.webp'
import { Fragment } from "react";
import Card2 from "./Card2";

import c2_1 from '../assets/images/c2-1.jpg'
import c2_2 from '../assets/images/c2-2.webp'
import c2_3 from '../assets/images/c2-3.jpg'
import c2_4 from '../assets/images/c2-4.jpg'

const CardsContainer = () => {

    let items = [
        {
            image: c1_1,
            title: "Order Food Online"
        },
        {
            image: c1_2,
            title: "Go out for a meal"
        },
        {
            image: c1_3,
            title: "Night Life & Clubs"
        },
        {
            image: c1_4,
            title: "Zomato Pro"
        }
    ]
    let items2 = [
        {
            image: c2_1,
            title: "Newly Opened"
        },
        {
            image: c2_2,
            title: "Best Of Chennai"
        },
        {
            image: c2_3,
            title: "Trending this week"
        },
        {
            image: c2_4,
            title: "Newly Opened"
        }
    ]

    return <>
        <div className="w-[75%] flex flex-col justify-center items-center mt-20">
            <div className="w-full grid grid-cols-[repeat(auto-fit,_minmax(200px,_1fr))] justify-center items-center gap-14 mb-20">
                {
                    items.map((item, index) => {
                        let { image, title } = item;
                        return <Fragment key={index}>
                            <Card1 image={image} title={title} />
                        </Fragment>
                    })
                }
            </div>
            <div className="w-full flex flex-col justify-center items-start">
                <h1 className="text-4xl font-medium">Collections</h1>
                <div className="w-full text-lg text-gray-700 flex justify-between items-center mb-3">
                    <p>Explore curated list of top restaurants, cafes, pubs and barsin Chennai, based on trends</p>
                    <a href="#" className="text-sm text-red-400">All Collections in Chennai</a>
                </div>
            </div>
            <div className="w-full grid grid-cols-[repeat(auto-fit,_minmax(200px,_1fr))] justify-center items-center gap-4">
                {
                    items2.map((item, index) => {
                        let { image, title } = item;
                        return <Fragment key={index}>
                            <Card2 image={image} title={title} />
                        </Fragment>
                    })
                }
            </div>
        </div>
    </>
}

export default CardsContainer