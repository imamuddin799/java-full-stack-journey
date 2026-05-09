import GitNav from "./components/GitNav"
import GitSignIn from "./components/GitSignIn"

const App = () => {
  return <>
    {/* <div className='flex h-[400px] m-10'>
      <div className='w-1/4 h-1/3 bg-yellow-300 text-blue-800 border-2 border-black text-[38px] p-5 rounded-2xl'>1</div>
      <div className='w-1/4 h-1/3 bg-yellow-300 text-blue-800 border-2 border-black text-[38px] p-5 rounded-2xl'>2</div>
      <div className='w-1/4 h-1/3 bg-yellow-300 text-blue-800 border-2 border-black text-[38px] p-5 rounded-2xl'>3</div>
    </div> */}
    <GitNav />
    <GitSignIn />
  </>
}
export default App