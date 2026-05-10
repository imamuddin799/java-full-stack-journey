
import Footer from '../components/Footer';
import PackageCard from '../components/PackageCard';
import { Fragment } from 'react';
import PackageHero from '../assets/images/packages/packages-hero.jpg'
import image1 from '../assets/images/packages/packages1.jpg'
import image2 from '../assets/images/packages/maldives.jpg'
import image3 from '../assets/images/packages/vietnam.jpg'
import image4 from '../assets/images/packages/morocco.jpg'

let Packages = () => {

    const cardDetails = [
        {
            continent: "Africa",
            country: 'Enchanting Mauritius',
            image: image1
        },
        {
            continent: "Asia",
            country: 'Majestic Maldives',
            image: image2
        },
        {
            continent: "Asia",
            country: 'Vibrant Vietnam',
            image: image3
        },
        {
            continent: "North Africa",
            country: 'Mystical Morocco',
            image: image4
        },
    ]

    return <>
        <section className="relative z-10 w-screen h-full">
            <div className="absolute z-20 inset-0 bg-cover" style={{ backgroundImage: `url(${PackageHero})` }}></div>
            <div className="py-55 relative z-30 flex justify-center items-center bg-[#00000099]">
                <div className="w-[40%] flex flex-col justify-start items-center">
                    <p className="text-white text-lg w-fit bg-[#88888888] py-1 px-9 rounded-3xl">{'Our Packages'.toUpperCase()}</p>
                    <h1 className="text-white w-fit text-7xl text-center py-5">Discover Your Perfect Adventure</h1>
                </div>
            </div>
        </section>
        <section className="w-screen flex flex-col gap-15 h-full justify-center items-center relative z-20 -mt-40 mb-30">
            {
                cardDetails.map((details, index) => {
                    return <Fragment key={index}>
                        <PackageCard continent={details.continent} country={details.country} image={details.image} />
                    </Fragment>
                })
            }
        </section>
        <Footer />
    </>
}

export default Packages;