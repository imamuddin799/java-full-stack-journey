import { NextResponse, NextRequest } from 'next/server'
import path from 'path'
import { readFile, writeFile } from 'fs/promises'

export async function GET() {
    const file = path.join(process.cwd(), 'data', 'users.json');
    const raw = await readFile(file, 'utf-8');
    const users = JSON.parse(raw);

    const payload = {
        success: true,
        message: "Users Fetched Successfully",
        data: [
            users
        ],
        error: null
    }
    const res = NextResponse.json(payload, {
        status: 200,
    });

    return res;
}

export async function POST(req: NextRequest) {

    const Content = req.headers.get('Content-Type');
    const poweredBy = req.headers.get('X-Powered-By');
    const cache = req.headers.get('Cache-Control');

    if (!(Content === 'application/json') || !poweredBy || !cache) {
        return NextResponse.json(
            { error: 'Missing required headers: Content-Type || X-Powered-By || Cache-Control' },
            { status: 400 }
        )
    }

    const { username, email, password } = await req.json();
    const file = path.join(process.cwd(), 'data', 'users.json');
    const raw = await readFile(file, 'utf-8');
    const users = JSON.parse(raw);
    const user = users.find((u: { email: string}) => u.email === email)

    if (user?.email) {
        const payload = {
            success: false,
            message: 'User already exists',
            data: null,
            error: 'User already exists error'
        }
        const res = NextResponse.json(payload, {
            status: 409,
            headers: {
                'Content-Type': 'application/json',
                'X-Powered-By': 'Next.js',
                'Cache-Control': 'no-store'
            }
        })

        return res;
    }

    users.push({ id: users.length + 1, username, email, password });

    await writeFile(file, JSON.stringify(users, null, 4), 'utf-8');

    const payload = {
        success: true,
        message: 'User created successfully',
        data: [
            {
                id: users.length,
                username: username,
                email: email
            }
        ],
        error: null
    }

    return NextResponse.json(payload, {
        status: 201,
        headers: {
            'Content-Type': 'application/json',
            'X-Custom-Header': 'my-value',
            'Cache-Control': 'no-store'
        }
    })
}
