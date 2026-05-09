import arrow from '../../assets/landingpage/images/icon-arrow-down.svg'
import Nav from './Nav'

let FirstSect = () => {
   return <>
       <section className="w-screen h-screen flex flex-col justify-start items-center">
           <Nav  />
           <div className='flex flex-col justify-center items-center'>
               <h1 className="my-20 text-white text-6xl font-bold tracking-wider">WE ARE CREATIVES</h1>
               <img src={arrow} alt="" className='my-5' />
           </div>
       </section>
   </>
}

export default FirstSect