import text1 from '../../assets/images/wordmark.svg'
import text2 from '../../assets/images/logo1.svg'
import text3 from '../../assets/images/logo2.svg'

const StickyDiv = () => {
  return (
    <>
      <div className="sticky top-15 z-[100] -translate-y-[50%]">
        <div className='absolute bg-white translate-y-[-50%] w-fit ml-[50%] translate-x-[-50%] flex'>
          <div className='py-6 px-7 w-full bg-black border border-gray-400'>
            <img src={text1} alt="" className="w-23 filter invert" />
          </div>
          <div className='py-6 px-7 w-full border border-gray-400'>
            <img src={text2} alt="" className="w-23" />
          </div>
          <div className='py-6 px-7 w-full border border-gray-400'>
            <img src={text3} alt="" className="w-23" />
          </div>
        </div>
      </div>
    </>
  );
};

export default StickyDiv;
