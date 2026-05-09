document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    // Clear previous errors
    document.getElementById('usernameError').textContent = '';
    document.getElementById('passwordError').textContent = '';

    let isValid = true;

    const username = document.getElementById('username').value.trim();
    const password = document.getElementById('password').value;

    if (username === '') {
        document.getElementById('usernameError').textContent = 'Username or email is required.';
        isValid = false;
    }

    if (password.length < 6) {
        document.getElementById('passwordError').textContent = 'Password must be at least 6 characters.';
        isValid = false;
    }

    if (isValid) {
        // For demonstration, just alert success
        alert('Login successful!\nUsername/Email: ' + username);
        // Here you can add actual login logic or API calls
        this.reset();
    }
});