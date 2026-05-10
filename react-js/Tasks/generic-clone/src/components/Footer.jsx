import ImageOfferings from '../assets/images/offerings/final.jpg'
const Footer = () => {
   return <>
       <div className="relative top-0 h-full w-screen">
           <div className="absolute inset-0 h-full w-full bg-no-repeat bg-cover bg-center filter  brightness-25" style={{backgroundImage: `url(${ImageOfferings})`}}></div>
           <div className="relative z-10 h-full w-full flex flex-col items-center justify-center text-white text-center py-30 font-sans">
               <div className='flex flex-col gap-10 w-1/2'>
                   <p className='text-[17px]'>{'Prefix for the Footer Call to action section will be here'.toUpperCase()}</p>
                   <h1 className='text-4xl font-medium pb-10'>We Will Write a Convincing Call To Action to Engage Your Audience Here</h1>
                   <aside className="w-full flex justify-center items-center">
                       <button className="bg-[#2a9d8f] text-white py-3 px-7 font-medium">CALL TO ACTION</button>
                   </aside>
               </div>
           </div>
       </div>
       <div className='text-center py-5 text-gray-500'>
           <p>Copyright &copy; 2025 Generic</p>
       </div>
   </>
}

export default Footer