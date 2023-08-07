import React from 'react';
import axios from 'axios';
import logoImage from '../../Assets/logo-register.png'
import almostheldhandsheldhands from '../../Assets/almostheldhands.png'
import './RegisterPage.css';

function Register() {

  const handleSubmit = async (event) => {
    event.preventDefault();

    const id = 0;
    const name = event.target.elements.name.value;
    const email = event.target.elements.email.value;
    const password = event.target.elements.password.value;
    const confirmPassword = event.target.elements.confirmPassword.value;

    const url = 'http://ec2-18-188-192-228.us-east-2.compute.amazonaws.com:8080/api/v1/users/register/user'

    const data = {
      name,
      email,
      password,
      /*confirmPassword,*/
    };

    try {
      const response = await axios.post(url, data);

      console.log('API response:', response.data);
    } catch (error) {
      console.error('Error making API call:', error);
    }
  };

  return (
    <div>
      <section className="container">
        <div className="img-box">
          <img className="purple-image" src={almostheldhandsheldhands} alt="Mãos se cumprimentando" />
        </div>
        <div className="form-box">
          <div className="form-box-elements">
            <img className="logo" src={logoImage} alt="" />
            <h1 className="register-h1">Registrar</h1>
            <div className="destaque register-destaque">Crie sua conta na Financie.se</div>
            <form className="login-form" onSubmit={handleSubmit}>
              <input className="text-input texto" name="name" placeholder="Nome" type="text" />
              <input className="text-input texto" name="email" placeholder="E-mail" type="text" />
              <input className="text-input texto" name="password" placeholder="Senha" type="password" />
              <input className="text-input texto" name="confirmPassword" placeholder="Confirme sua senha" type="password" />
              <input className="purple-button texto" type="submit" value="Registrar" />
              <a className="alerta register-link" href="#">Já tenho uma conta</a>
            </form>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Register;
