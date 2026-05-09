'use server';

export async function submitData(formData: FormData) {
  const email = formData.get('email');
  console.log(`Received email: ${email}`);
}