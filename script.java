document.addEventListener('DOMContentLoaded', function() {
    const passwordDisplay = document.getElementById('passwordDisplay');
    const generateBtn = document.getElementById('generateBtn');
    const copyBtn = document.getElementById('copyBtn');
    const passwordLength = document.getElementById('passwordLength');
    const uppercaseCheckbox = document.getElementById('uppercaseCheckbox');
    const lowercaseCheckbox = document.getElementById('lowercaseCheckbox');
    const numbersCheckbox = document.getElementById('numbersCheckbox');
    const symbolsCheckbox = document.getElementById('symbolsCheckbox');
    const passwordStrength = document.getElementById('passwordStrength');

    generateBtn.addEventListener('click', generatePassword);
    copyBtn.addEventListener('click', copyPassword);

    function generatePassword() {
        const length = parseInt(passwordLength.value);
        const useUppercase = uppercaseCheckbox.checked;
        const useLowercase = lowercaseCheckbox.checked;
        const useNumbers = numbersCheckbox.checked;
        const useSymbols = symbolsCheckbox.checked;

        const uppercaseChars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
        const lowercaseChars = 'abcdefghijklmnopqrstuvwxyz';
        const numberChars = '0123456789';
        const symbolChars = '!@#$%^&*()_+-=[]{}|;:,.<>?';

        let allowedChars = '';
        if (useUppercase) allowedChars += uppercaseChars;
        if (useLowercase) allowedChars += lowercaseChars;
        if (useNumbers) allowedChars += numberChars;
        if (useSymbols) allowedChars += symbolChars;

        if (allowedChars === '') {
            alert('Please select at least one character type.');
            return;
        }

        let password = '';
        for (let i = 0; i < length; i++) {
            const randomIndex = Math.floor(Math.random() * allowedChars.length);
            password += allowedChars[randomIndex];
        }

        passwordDisplay.value = password;
        updatePasswordStrength(password);
    }

    function copyPassword() {
        passwordDisplay.select();
        document.execCommand('copy');
        alert('Password copied to clipboard!');
    }

    function updatePasswordStrength(password) {
        let strength = 'Weak';
        if (password.length >= 8) {
            strength = 'Medium';
            if (password.length >= 12 && /[A-Z]/.test(password) && /[a-z]/.test(password) && /[0-9]/.test(password) && /[^A-Za-z0-9]/.test(password)) {
                strength = 'Strong';
            }
        }
        passwordStrength.textContent = strength;
        passwordStrength.className = strength.toLowerCase();
    }
});
