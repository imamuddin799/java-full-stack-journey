import gif1 from '../assets/images/gif1.gif'
import gif2 from '../assets/images/gif2.jpg'
import Cards from './Cards'
import CourseCategories from './CourseCategories'
import popular from '../data/PopularNow.json'
import liveCourses from '../data/liveCourses.json'
import DSA from '../data/dsaCourses.json'
import special from '../data/special.json'
import beginner from '../data/beginner.json'
import offline from '../data/offline.json'

let WebPageBody = () => {
   return <>
       <section className="w-full flex justify-center items-start pb-20">
           <div className="w-[90%] rounded-xl px-12 bg-white">
               <div className='my-12 flex gap-8 w-full'>
                   <div><img src={gif1} alt=""  className='rounded-lg' /></div>
                   <div><img src={gif2} alt=""  className='rounded-lg' /></div>                   
               </div>
               <Cards data={popular} />
               <CourseCategories />
               <Cards data={liveCourses} />
               <Cards data={DSA} />
               <Cards data={special} />
               <Cards data={beginner} />
               <div className='w-full grid grid-cols-2 gap-6'>
                   <div className='w-full rounded-lg hover:scale-105 transition-all duration-200'><img src="https://media.geeksforgeeks.org/img-practice/prod/courses/3/Web/Header/tech101-web-webp_1747396898.webp" alt="" className='w-full rounded-lg' /></div>
                   <div className='w-full rounded-lg hover:scale-105 transition-all duration-200'><img src="https://media.geeksforgeeks.org/img-practice/prod/courses/3/Web/Header/dsatodev-web-webp_1747396868.webp" alt="" className='w-full rounded-lg' /></div>
                   <div className='w-full rounded-lg hover:scale-105 transition-all duration-200'><img src="https://media.geeksforgeeks.org/img-practice/prod/courses/1/Web/Navigation/web-web_1734602497.webp" alt="" className='w-full rounded-lg' /></div>
                   <div className='w-full rounded-lg hover:scale-105 transition-all duration-200'><img src="https://media.geeksforgeeks.org/img-practice/prod/courses/2/Web/Other/web-web_1734602902.webp" alt="" className='w-full rounded-lg' /></div>
               </div>
               <Cards data={offline} />
           </div>
       </section>
   </>
}

export default WebPageBody