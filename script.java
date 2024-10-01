const lengthEl = document.getElementById('length');
const uppercaseEl = document.getElementById('uppercase');
const numbersEl = document.getElementById('numbers');
const symbolsEl = document.getElementById('symbols');
const passwordEl = document.getElementById('password');
const generateBtn = document.getElementById('generate');
const copyBtn = document.getElementById('copy-btn');

const lowercaseChars = 'abcdefghijklmnopqrstuvwxyz';
const uppercaseChars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
const numberChars = '0123456789';
const symbolChars = '!@#$%^&*()_+~`|}{[]:;?,./-=<>';

function generatePassword() {
    const length = +lengthEl.value;
    let chars = '';
    let password = '';

    if (uppercaseEl.checked) {
        chars += uppercaseChars;
    }
    if (numbersEl.checked) {
        chars += numberChars;
    }
    if (symbolsEl.checked) {
        chars += symbolChars;
    }
    chars += lowercaseChars;

    if (chars === '') {
        alert('Veuillez sÃ©lectionner au moins une option.');
        return;
    }

    for (let i = 0; i < length; i++) {
        password += chars.charAt(Math.floor(Math.random() * chars.length));
    }

    passwordEl.value = password;
}

function copyPassword() {
    if (passwordEl.value === '') {
        alert('Aucun mot de passe Ã  copier.');
        return;
    }
    passwordEl.select();
    document.execCommand('copy');
    alert('Mot de passe copiÃ© dans le presse-papiers.');
}

generateBtn.addEventListener('click', generatePassword);
copyBtn.addEventListener('click', copyPassword);

document.getElementById('test-button').addEventListener('click', function() {
    const password = document.getElementById('password-test').value;
    const strengthBar = document.getElementById('strength-bar');
    const strengthText = document.getElementById('strength-text');

    // Ã‰valuer la force du mot de passe
    let strength = 0;
    if (password.length > 6) strength += 1;
    if (password.length > 10) strength += 1;
    if (/[A-Z]/.test(password)) strength += 1;
    if (/[0-9]/.test(password)) strength += 1;
    if (/[^A-Za-z0-9]/.test(password)) strength += 1;

    // Animer la barre et afficher le texte
    const width = (strength / 5) * 100;
    let color, text;

    switch (strength) {
        case 0:
        case 1:
            color = '#ff4d4d';
            text = 'Faible';
            break;
        case 2:
        case 3:
            color = '#ffa64d';
            text = 'Moyen';
            break;
        case 4:
        case 5:
            color = '#4dff4d';
            text = 'Fort';
            break;
    }

    strengthBar.style.width = width + '%';
    strengthBar.style.backgroundColor = color;
    strengthText.textContent = 'Mot de passe : ' + text;
    strengthText.style.color = color;

    // Animation ludique
    strengthBar.style.animation = 'pulse 0.5s';
    setTimeout(() => strengthBar.style.animation = '', 500);
});
