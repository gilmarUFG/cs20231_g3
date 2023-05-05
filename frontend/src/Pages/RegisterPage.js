import { useState } from "react";

export default function RegisterPage() {
    
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [confirmPassword, setConfirmPassword] = useState('')
    
    async function register (ev) {
        ev.preventDefault();
        if (password !== confirmPassword) {
            alert('Passwords do not match');
            return;
        }
        try {
            await fetch('http://localhost:4000/register', {
                method: 'POST',
                body: JSON.stringify({username, password}),
                headers: {'Content-Type': 'application/json'}
            })
            alert('Registrado com sucesso')
        } catch (err) {
            alert('Falha ao registrar')
            console.log(err);
        }
    }
    
    return (
        <form className="register" onSubmit={register}>
            <h1>Register</h1>
            <input type="text" placeholder="username" value={username} onChange={ev => setUsername(ev.target.value)}/>
            <input type="password" placeholder="password" value={password} onChange={ev => setPassword(ev.target.value)}/>
            <input type="password" placeholder="confirm password" value={confirmPassword} onChange={ev => setConfirmPassword(ev.target.value)}/>
            <button type="Register">Register</button>
        </form>
    )
    
}