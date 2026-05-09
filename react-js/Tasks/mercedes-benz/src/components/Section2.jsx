import Card2 from "./smallcomponents/Card2"
import car1 from '../assets/images/imageye___-_f01f6151bdc78c913c23cda769c0092d7d065.png'
import car2 from '../assets/images/imageye___-_iris (4).png'
import car3 from '../assets/images/imageye___-_iris.png'
import Button2 from "./smallcomponents/Button2"

let Section2 = () => {
    return <>
        <section className="w-full flex justify-center items-start">
            <div className="w-[84%]">
                <h1 className="text-4xl my-12 w-[55%]">The perfect blend of luxury, sportiness and performance: Discover our latest models</h1>
                <Button2>Discover all models</Button2>
                <Button2 >Discover electric models</Button2>
                <div className="flex justify-between items-center gap-10">
                    <Card2 type="Limousine" car={car1} />
                    <Card2 type="SUV Range" car={car2} />
                    <Card2 type="Cabriolets / Roadsters" car={car3} />
                </div>
            </div>
        </section>
    </>
}

export default Section2