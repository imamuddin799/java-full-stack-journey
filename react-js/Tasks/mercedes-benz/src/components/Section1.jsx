import Card1 from "./smallcomponents/Card1"
import car1 from '../assets/images/imageye___-_1746156855940 (4).jpg'
import car2 from '../assets/images/imageye___-_1746156855940 (3).jpg'
import car3 from '../assets/images/imageye___-_1746156855940 (1).jpg'
import car4 from '../assets/images/imageye___-_1746156855940.jpg'
import car5 from '../assets/images/imageye___-_1746156855940 (2).jpg'
let Section1 = () => {
    return <>
        <section className="w-full flex justify-center items-start">
            <div className="w-[84%]">
                <h1 className="text-5xl my-10">Our Recommendations.</h1>
                <div className="w-full grid grid-cols-[2fr_1fr] gap-10 mb-10">
                    <div><Card1 para="Crafting cars your way" heading="Because it's Mercedes-Benz." buttonText="Learn more" image={car1} scale={2} /></div>
                    <div><Card1 para="Switch on to Stand out." heading="The All new EQA" buttonText="Find available cars" image={car2} more="Learn More" /></div>
                </div>
                <div className="w-full grid grid-cols-[2fr_1fr] gap-10">
                    <div className="w-full grid grid-cols-2 gap-10">
                        <div><Card1 para="Dynamic all the way." heading="The new GLA" buttonText="Find available cars" image={car3} more="Learn More" /></div>
                        <div><Card1 para="Here's to the heart." heading="The all-new Mercedes-AMG C 63 S E Performance" buttonText="Learn more" image={car4} /></div>
                    </div>
                    <div><Card1 para="Explore our Online Store." heading="Browse & Buy your Mercedes-Benz" buttonText="Find available cars" image={car5} /></div>
                </div>
            </div>
        </section>
    </>
}

export default Section1