import transform from '../../assets/landingpage/images/desktop/image-transform.jpg'

let TransformBrand = () => {
   return <>
       <section className="w-full flex justify-between items-start">
           <div className="w-[50%] bg-white p-45 pr-21">
               <h1 className="text-5xl font-bold tracking-wider pb-7">Tranform your brand</h1>
               <p className="text-xl pb-10">We are a full service creative agency specializing in helping brands grow fast. Engage yout clients through compelling visuals that do most of the marketing for you</p>
               <a href="" className="text-2xl font-bold border-b-2 border-amber-400">LEARN MORE</a>
           </div>
           <div className="w-[50%]">
               <img src={transform} alt="" className='w-full h-full' />
           </div>
       </section>
   </>
}

export default TransformBrand;