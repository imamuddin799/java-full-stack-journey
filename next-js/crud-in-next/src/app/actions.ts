'use server';

import { redirect } from "next/navigation";

export async function userData(formData: FormData) {
    const email = formData.get('email');
    const username = formData.get('username');
    const password = formData.get('password');


    const res = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}/api/user`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-Powered-By': 'Next.js',
            'Cache-Control': 'no-store'
        },
        body: JSON.stringify({ username, email, password })
    })
    
    const data = await res.json();
    console.log(data);

    if (res.ok) {
        console.log('redirecting to dashboard');
        console.log('fetch response>>>', res);
        redirect(`/profile/${data.data[0].id}`);
    } else {
        console.log(data);
    }

    console.log('fetch response:', res);
    console.log(res.headers.get('Content-Type'));
}