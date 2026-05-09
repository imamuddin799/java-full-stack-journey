'use client';

import { userData } from '@/app/actions';

export default function Home() {

  const handleSubmit = () => {
    console.log('Form submitted 1');
    document.querySelectorAll('input').forEach(input => {
      console.log(input.name, input.value);
    })
  }

  return (
    <form action={userData} className='flex flex-col gap-4 p-4 max-w-md mx-auto text-2xl text-white '>
      <label htmlFor="">Email</label>
      <input name="email" type="email" className='text-white border-2 border-blue-500 rounded' />
      <label htmlFor="">Username</label>
      <input name="username" type="text" className='text-white border-2 border-blue-500 rounded' />
      <label htmlFor="">Password</label>
      <input name="password" type="password" className='text-white border-2 border-blue-500 rounded' />
      <button type="submit" onClick={handleSubmit} className='bg-blue-500 hover:bg-blue-700 rounded'>Submit</button>
    </form>
  );
}