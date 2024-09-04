function generatePassword() {
    const length = parseInt(document.getElementById("passwordLength").value);
    const useUppercase = document.getElementById("uppercaseCheckbox").checked;
    const useLowercase = document.getElementById("lowercaseCheckbox").checked;
    const useNumbers = document.getElementById("numbersCheckbox").checked;
    const useSymbols = document.getElementById("symbolsCheckbox").checked;

    const uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    const lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
    const numberChars = "0123456789";
    const symbolChars = "!@#$%^&*()_+-=[]{}|;:,.<>?";

    let allowedChars = "";
    if (useUppercase) allowedChars += uppercaseChars;
    if (useLowercase) allowedChars += lowercaseChars;
    if (useNumbers) allowedChars += numberChars;
    if (useSymbols) allowedChars += symbolChars;

    if (allowedChars === "") {
        alert("Please select at least one character type.");
        return;
    }

    let password = "";
    for (let i = 0; i < length; i++) {
        const randomIndex = Math.floor(Math.random() * allowedChars.length);
        password += allowedChars[randomIndex];
    }

    document.getElementById("passwordDisplay").value = password;
    updatePasswordStrength(password);
}

function copyPassword() {
    var passwordField = document.getElementById("passwordDisplay");
    passwordField.select();
    document.execCommand("copy");
    alert("Copied the password: " + passwordField.value);
}

function updatePasswordStrength(password) {
    const strength = calculatePasswordStrength(password);
    const strengthElement = document.getElementById("passwordStrength");
    strengthElement.textContent = strength;

    // Optionally, you can add color coding
    if (strength === "Strong") {
        strengthElement.style.color = "green";
    } else if (strength === "Medium") {
        strengthElement.style.color = "orange";
    } else {
        strengthElement.style.color = "red";
    }
}

function calculatePasswordStrength(password) {
    // This is a simple strength calculation. You might want to use a more sophisticated algorithm.
    if (password.length < 8) {
        return "Weak";
    } else if (password.length < 12) {
        return "Medium";
    } else {
        return "Strong";
    }
}

// Add event listeners
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById("generateButton").addEventListener("click", generatePassword);
    document.getElementById("copyButton").addEventListener("click", copyPassword);
    document.getElementById("passwordLength").addEventListener("input", generatePassword);
    document.getElementById("uppercaseCheckbox").addEventListener("change", generatePassword);
    document.getElementById("lowercaseCheckbox").addEventListener("change", generatePassword);
    document.getElementById("numbersCheckbox").addEventListener("change", generatePassword);
    document.getElementById("symbolsCheckbox").addEventListener("change", generatePassword);
});
