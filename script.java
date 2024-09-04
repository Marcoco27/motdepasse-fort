body {
    font-family: Arial, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    background-color: #f0f0f0;
}

.container {
    background-color: white;
    padding: 2rem;
    border-radius: 5px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    width: 350px;
}

h1 {
    text-align: center;
    margin-bottom: 1rem;
}

input[type="text"], input[type="number"] {
    width: 100%;
    padding: 0.5rem;
    margin-bottom: 1rem;
}

button {
    width: 100%;
    padding: 0.5rem;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 3px;
    cursor: pointer;
    margin-bottom: 1rem;
}

button:hover {
    background-color: #0056b3;
}

.options {
    margin-bottom: 1rem;
}

label {
    display: block;
    margin-bottom: 0.5rem;
}

#passwordStrength {
    font-weight: bold;
}
