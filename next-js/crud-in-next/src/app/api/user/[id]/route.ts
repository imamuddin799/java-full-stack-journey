// app/api/user/[id]/route.ts
import { NextRequest, NextResponse } from 'next/server'
import { readFile, writeFile } from 'fs/promises'
import path from 'path'

const filePath = path.join(process.cwd(), 'data', 'users.json')

/**
 * GET /api/user/[id]
 * Returns a single user by ID.
 */
export async function GET(req: NextRequest, { params }: { params: Promise<{ id: string }> }) {
    const { id: userId } = await params;
    const id = parseInt(userId, 10);
    const raw = await readFile(filePath, 'utf-8')
    const users = JSON.parse(raw) as Array<{ id: number; username: string; email: string }>

    const user = users.find(u => u.id === id)
    if (!user) {
        return NextResponse.json(
            {
                success: false,
                message: `User with id ${id} not found`,
                data: null,
                error: `User with id ${id} not found`
            },
            { status: 404 }
        )
    }

    return NextResponse.json(
        {
            success: true,
            message: `User with id ${id} found`,
            data: [user],
            error: null
        },
        { status: 200 }
    )
}

/**
 * PUT /api/user/[id]
 * Updates username and/or email for a user.
 */
export async function PUT(req: NextRequest, { params }: { params: Promise<{ id: string }> }) {
    const { id: userId } = await params;
    const id = parseInt(userId, 10);
    const { username, email, password } = await req.json()

    // Load existing users
    const raw = await readFile(filePath, 'utf-8')
    const users = JSON.parse(raw) as Array<{ id: number; username: string; email: string; password: string }>

    // Find and update
    const idx = users.findIndex(u => u.id === id)
    if (idx === -1) {
        return NextResponse.json(
            {
                success: false,
                message: `Cannot update: user with id ${id} not found`,
                data: null,
                error: `User with id ${id} not found`
            },
            { status: 404 }
        )
    }

    // Apply updates
    if (username) users[idx].username = username
    if (email) users[idx].email = email
    if (password) users[idx].password = password;

    // Persist changes
    await writeFile(filePath, JSON.stringify(users, null, 4), 'utf-8')

    // Return updated user
    return NextResponse.json(
        {
            success: true,
            message: `User with id ${id} updated successfully`,
            data: [users[idx]],
            error: null
        },
        {
            status: 200,
            headers: {
                'Content-Type': 'application/json',
                'Cache-Control': 'no-store',
                'Access-Control-Allow-Origin': '*',
            }
        }
    )
}


/**
 * DELETE /api/user/[id]
 * Removes the user with the given ID.
 */
export async function DELETE(req: NextRequest, { params }: { params: Promise<{ id: string }> }) {
    const { id: userId } = await params;
    const id = parseInt(userId, 10);

    // Load users
    const raw = await readFile(filePath, 'utf-8')
    const users = JSON.parse(raw) as Array<{ id: number; username: string; email: string }>

    // Check existence
    const idx = users.findIndex(u => u.id === id)
    if (idx === -1) {
        return NextResponse.json(
            {
                success: false,
                message: `Cannot delete: user with id ${id} not found`,
                data: null,
                error: `User with id ${id} not found`
            },
            { status: 404 }
        )
    }

    // Remove and persist
    const [deletedUser] = users.splice(idx, 1)
    await writeFile(filePath, JSON.stringify(users, null, 4), 'utf-8')

    // Respond with deleted record
    return NextResponse.json(
        {
            success: true,
            message: `User with id ${id} deleted successfully`,
            data: [deletedUser],
            error: null
        },
        {
            status: 200,
            headers: {
                'Content-Type': 'application/json',
                'Cache-Control': 'no-store',
                'Access-Control-Allow-Origin': '*',
            }
        }
    )
}