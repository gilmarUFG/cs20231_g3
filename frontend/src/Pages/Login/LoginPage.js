import React from 'react';
import logoImage from '../../Assets/logo-register.png'
import heldhands from '../../Assets/heldhands.png'
import './LoginPage.css';

function Login() {
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
            <form className="login-form" action="">
              <input className="text-input texto" placeholder="E-mail" type="text" />
              <input className="text-input texto" placeholder="Senha" type="password" />
              <input className="purple-button texto" type="submit" value="Login" />
              <a className="alerta register-link" href="#">Não tenho uma conta</a>
            </form>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Login;
