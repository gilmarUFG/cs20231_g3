import { Button, FormControl, FormLabel, Input, Text } from "@chakra-ui/react";
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
        <FormControl className="form" onSubmit={register}>
            <Text style={{ fontSize:"25px" }}><strong>Cadastre-se</strong></Text>
            <br></br>

            <FormLabel className="form-label">Usuário:</FormLabel>
            <Input width="300px" type="text" value={username} onChange={ev => setUsername(ev.target.value)}/>

            <FormLabel className="form-label">Senha:</FormLabel>
            <Input width="300px" type="password" value={password} onChange={ev => setPassword(ev.target.value)}/>

            <FormLabel className="form-label">Confirmar senha:</FormLabel>
            <Input width="300px" type="password" value={confirmPassword} onChange={ev => setConfirmPassword(ev.target.value)}/>

            <br></br>
            <Button marginTop={"30px"} colorScheme="purple" type="Register">Efetuar cadastro</Button>
        </FormControl>
    )
    
}