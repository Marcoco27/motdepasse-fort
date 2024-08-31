function generatePassword() {
    // Your password generation logic here
    // This function should generate a password based on user preferences and display it in the input field
}

function copyPassword() {
    var passwordField = document.getElementById("passwordDisplay");
    passwordField.select();
    document.execCommand("copy");
    alert("Copied the password: " + passwordField.value);
}