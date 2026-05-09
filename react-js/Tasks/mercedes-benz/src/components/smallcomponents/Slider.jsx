import SliderCard from "./SliderCard"
import image from '../../assets/images/1740015975368.jpg'
import image2 from '../../assets/images/1740065262547.jpg'

const Slider = () => {
  return <>
    <div className="w-full flex justify-between items-start gap-10">
      <SliderCard image={image} heading="Digital extras for your Mercedes-Benz" para="Simply book additional digital extras and experience your Mercedes-Benz in a new way." buttonDetails="Buy online now" />
      <SliderCard image={image2} heading="Maintenance and Service" para="Enjoy Peace of Mind with Mercedes-Benz Service, Maintenance and Repair." buttonDetails="Learn more" />
    </div>
  </>
}

export default Slider