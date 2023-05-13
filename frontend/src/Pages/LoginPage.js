import {useContext, useState} from "react";
import {Navigate} from "react-router-dom";
import {UserContext} from "../UserContext";
import { Button, FormControl, FormLabel, Input, Text } from "@chakra-ui/react";

export default function LoginPage() {

    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [redirect, setRedirect] = useState(false);
    const {setUserInfo} = useContext(UserContext);

    async function login (ev) {
        ev.preventDefault();
        const response = await fetch('http://localhost:4000/login', {
            method: 'POST',
            body: JSON.stringify({username, password}),
            headers: {'Content-Type': 'application/json'},
            credentials: 'include',
        })

        if (response.ok){
            response.json().then(userInfo => {
                setUserInfo(userInfo);
                setRedirect(true);
            });

        } else {
            alert('Falha ao logar')
        }
    }
    
    if (redirect) {
        return <Navigate to={'/'} />
    }
    
    return (
        <FormControl className="form" onSubmit={login}>
            <Text style={{ fontSize:"25px" }}><strong>Login</strong></Text>
            <br></br>

            <FormLabel className="form-label">Usuário:</FormLabel>
            <Input width="300px" type="text" value={username} onChange={ev => setUsername(ev.target.value)}/>

            <FormLabel className="form-label">Senha:</FormLabel>
            <Input width="300px" type="password" value={password} onChange={ev => setPassword(ev.target.value)}/>

            <br></br>
            <Button marginTop={"30px"} colorScheme="purple">Entrar</Button>
        </FormControl>
    )
}