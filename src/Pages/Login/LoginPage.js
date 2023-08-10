import React, { useState } from 'react';
import axios from 'axios';
import logoImage from '../../Assets/logo-register.png';
import heldhands from '../../Assets/heldhands.png';
import './LoginPage.css';

function LoginPage() {
  const [loginError, setLoginError] = useState(false);

  const handleLogin = async (event) => {
    event.preventDefault();

    const email = event.target.elements.email.value;
    const password = event.target.elements.password.value;

    const url = 'http://ec2-18-188-192-228.us-east-2.compute.amazonaws.com:8080/api/v1/auth/authenticate';


    const data = {
      email,
      password,
    };

    try {
      const response = await axios.post(url, data);

      console.log('Login successful:', response.data);
      window.location.href = '/';
      // You can handle successful login here, e.g., redirect to a dashboard
    } catch (error) {
      console.error('Error logging in:', error);
      setLoginError(true);
    }
  };

  return (
    <div>
      <section className="container">
        <div className="img-box">
          <img className="purple-image" src={heldhands} alt="Mãos se cumprimentando" />
        </div>
        <div className="form-box">
          <div className="form-box-elements">
            <img className="logo" src={logoImage} alt="" />
            <h1 className="register-h1">Login</h1>
            <div className="destaque register-destaque">Entre na sua conta</div>
            {loginError && (
              <div className="destaque register-destaque">
                Erro ao fazer login. Por favor, verifique suas credenciais.
              </div>
            )}
            <form className="login-form" onSubmit={handleLogin}>
              <input className="text-input texto" name="email" placeholder="E-mail" type="text" />
              <input className="text-input texto" name="password" placeholder="Senha" type="password" />
              <input className="purple-button texto" type="submit" value="Login" />
              <a className="alerta register-link" href="#">Não tenho uma conta</a>
            </form>
          </div>
        </div>
      </section>
    </div>
  );
}

export default LoginPage;
