'use client';

import { submitData } from '@/server/actions';

export default function Contact() {

  const handleSubmit = () => {
    console.log('Form submitted 1');
    console.log(document.getElementsByName('email')[0].value);
  }

  return (
    <form action={submitData}>
      <input name="email" type="email" />
      <button type="submit" onClick={handleSubmit}>Submit</button>
    </form>
  );
}