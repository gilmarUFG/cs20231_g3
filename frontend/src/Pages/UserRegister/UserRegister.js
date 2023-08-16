import React from 'react';
import axios from 'axios';
import logoImage from '../../Assets/logo-register.png'
import almostheldhandsheldhands from '../../Assets/almostheldhands.png'
import './UserRegister.css';

function UserRegister() {
 
  const [passwordsMatch, setPasswordsMatch] = React.useState(true); // State to track password match
  
  const handleSubmit = async (event) => {
    event.preventDefault();

    const username = event.target.elements.name.value;
    const email = event.target.elements.email.value;
    const password = event.target.elements.password.value;
    const confirmPassword = event.target.elements.confirmPassword.value;

    // Verify if passwords match
    if (password !== confirmPassword) {
      setPasswordsMatch(false);
      console.error('Passwords do not match');
      return;
    }

    const url = 'http://ec2-18-188-192-228.us-east-2.compute.amazonaws.com:8080/api/v1/users/register/user'

    const data = {
      username,
      email,
      password,
    };

    try {
      const response = await axios.post(url, data);

      console.log('API response:', response.data);
      window.location.href = '/login';
    } catch (error) {
      console.error('Error making API call:', error);
      if (error.response) {
        console.log('API response:', error.response.data);
      }
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
            {/* Display error message if passwords do not match */}
            {!passwordsMatch && (
              <div className="destaque register-destaque">
                Senhas não conferem. Por favor, tente novamente.
              </div>
            )}
            <form className="login-form" onSubmit={handleSubmit}>
              <input className="text-input texto" name="name" placeholder="Nome" type="text" />
              <input className="text-input texto" name="email" placeholder="E-mail" type="text" />
              <input className="text-input texto" name="password" placeholder="Senha" type="password" />
              <input className="text-input texto" name="confirmPassword" placeholder="Confirme sua senha" type="password" />
              <input className="purple-button texto" type="submit" value="Registrar" />
              <a className="alerta register-link" href="/login">Já tenho uma conta</a>
            </form>
          </div>
        </div>
      </section>
    </div>
  );
}

export default UserRegister;