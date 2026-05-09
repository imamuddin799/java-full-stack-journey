// app/(auth)/login/page.tsx
import LoginForm from './LoginForm'

export default async function LoginPage({
    searchParams,             // ← a Promise<{ registered?: string }>
}: {
    searchParams: Promise<{ registered?: string }>
}) {
    const { registered } = await searchParams
    const justRegistered = registered === 'true'

    return <LoginForm registered={justRegistered} />
}
