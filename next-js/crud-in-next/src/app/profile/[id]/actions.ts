'use server';

export async function getUserData(id: string) {
    const res = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}/api/user/${id}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Cache-Control': 'no-store',
            'Access-Control-Allow-Origin': '*'
        },
        cache: 'no-store'
    })
    return res;
}

export async function handleDeleteUser(id: number) {
    const res = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}/api/user/${id}`, {
        method: 'DELETE',
    })

    const data = res.json();

    return data;
}

export async function updateUser(id: string, formData: FormData) {

    const email = formData.get('email') as string
    const username = formData.get('username') as string
    const password = formData.get('password') as string

    const res = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}/api/user/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'X-Powered-By': 'Next.js',
            'Cache-Control': 'no-store'
        },
        body: JSON.stringify({ username, email, password })
    })

    const data = await res.json();
    console.log(data);

    return data;
}