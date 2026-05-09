import standOut from '../../assets/landingpage/images/desktop/image-stand-out.jpg'

let StandOut = () => {
    return <>
        <section className="w-full flex justify-between items-start">
            <div className="w-[50%]">
                <img src={standOut} alt="" className='w-full h-full' />
            </div>
            <div className="w-[50%] bg-white p-35 pr-21">
                <h1 className="text-5xl font-bold pb-7">Stand out to the right audience</h1>
                <p className="text-xl pb-10">Using a collaborative formula of designers, researchers, photographers, videographers and copy writers. we'll build and extend your brand in digital places.</p>
                <a href="" className="text-2xl font-bold border-b-2 border-amber-400">LEARN MORE</a>
            </div>
        </section>
    </>
}

export default StandOut