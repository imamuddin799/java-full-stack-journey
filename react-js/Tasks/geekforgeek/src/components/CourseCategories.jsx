import ibm from '../assets/images/ibm.png'
let CourseCategories = () => {
    return <>
        <section className="w-full my-12">
            <div className="flex justify-between my-3">
                <div>
                    <h1 className="text-2xl font-medium">Course Categories</h1>
                </div>
            </div>
            <div className="grid grid-cols-4 gap-6">
                <div className="rounded-sm py-5 px-4 bg-[#F5A572] flex justify-start items-center gap-4">
                    <img src="https://media.geeksforgeeks.org/img-practice/Miscellaneous-1641884151.svg" alt="" className="max-h-[25px]" />
                    <h1 className='text-lg font-bold text-white'>All</h1>
                </div>
                <div className="rounded-sm py-5 px-4 bg-[#31135E] flex justify-start items-center gap-4">
                    <img src="https://www.geeksforgeeks.org/_next/image?url=https%3A%2F%2Fmedia.geeksforgeeks.org%2Fimg-practice%2Fprod%2Fcourses%2F1%2FWeb%2FOther%2FGroup_1732701528.png&w=96&q=75" alt="" className="max-h-[25px]" />
                    <h1 className='text-lg font-bold text-white'>Certification Courses</h1>
                </div>
                <div className="rounded-sm py-5 px-4 bg-[#3079AC] flex justify-start items-center gap-4">
                    <img src="https://media.geeksforgeeks.org/img-practice/Group7132-1641554264.svg" alt="" className="max-h-[25px]" />
                    <h1 className='text-lg font-bold text-white'>DSA / Placements</h1>
                </div>
                <div className="rounded-sm py-5 px-4 bg-[#B88CBF] flex justify-start items-center gap-4">
                    <img src="https://media.geeksforgeeks.org/img-practice/PlacementTestSeries-1641884279.svg" alt="" className="max-h-[25px]" />
                    <h1 className='text-lg font-bold text-white'>Development / Testing</h1>
                </div>
                <div className="rounded-sm py-5 px-4 bg-[#ABD194] flex justify-start items-center gap-4">
                    <img src="https://media.geeksforgeeks.org/img-practice/Group7128-1641554202.svg" alt="" className="max-h-[25px]" />
                    <h1 className='text-lg font-bold text-white'>Machine Learning / Data Science</h1>
                </div>
                <div className="rounded-sm py-5 px-4 bg-[#627A92] flex justify-start items-center gap-4">
                    <img src='https://media.geeksforgeeks.org/img-practice/ProgrammingLanguages-1641884323.svg' alt="" className="max-h-[25px]" />
                    <h1 className='text-lg font-bold text-white'>Programming Languages</h1>
                </div>
                <div className="rounded-sm py-5 px-4 bg-[#21898C] flex justify-start items-center gap-4">
                    <img src='https://media.geeksforgeeks.org/img-practice/Group7134-1641554232.svg' alt="" className="max-h-[25px]" />
                    <h1 className='text-lg font-bold text-white'>Cloud / DevOps</h1>
                </div>
                <div className="rounded-sm py-5 px-4 bg-[#7C87A5] flex justify-start items-center gap-4">
                    <img src='https://media.geeksforgeeks.org/img-practice/gate-1641884189.svg' alt="" className="max-h-[25px]" />
                    <h1 className='text-lg font-bold text-white'>Gate</h1>
                </div>
            </div>
        </section>
    </>
}

export default CourseCategories