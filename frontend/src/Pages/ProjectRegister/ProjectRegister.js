import React from 'react';
import './reset.css';
import './main.css';
import './projectregister.css';
import axios from 'axios';

function ProjectRegister() {

  const handleProjectRegister = async (event) => {
    event.preventDefault();

    const title = event.target.elements.title.value;
    const subtitle = event.target.elements.subtitle.value;
    const description = event.target.elements.description.value;
    const category = event.target.elements.category.value;  
    const minimumContributionValue = event.target.elements.minimumContributionValue.value;
    const fundraisingGoal = event.target.elements.fundraisingGoal.value;
    const endDate = event.target.elements.endDate.value;
    
    const url = 'http://ec2-18-188-192-228.us-east-2.compute.amazonaws.com:8080/api/v1/projects/create';

    const data = {
      title,
      subtitle,
      description,
      category,
      minimumContributionValue,
      fundraisingGoal,
      endDate,
    };

    try {
      // Get the token from localStorage
      const authToken = localStorage.getItem('authToken');

      const response = await axios.post(url, data, {
        headers: {
          Authorization: `Bearer ${authToken}` 
        }
      });

      console.log('Project created:', response.data);
      window.location.href = '/';
    } catch (error) {
      console.error('Error creating project:', error);
    }
  };

  return (
    <div className="viewport-div">
      <div className="main-container">
        <div className="inside-container">
          <h1 className="titulo-principal">Cadastre seu projeto</h1>
          <div className="destaque titulo-secundario">
            Insira as características do seu projeto para que todos possam ver e ajudar
          </div>

          <form className="register-project-form" onSubmit={handleProjectRegister}>
          <input className="text-input texto" placeholder="Título" type="text" name="title"/>
          <input className="text-input texto" placeholder="Subtítulo" type="text" name="subtitle"/>
          <input className="text-input texto" placeholder="Descrição" type="text" name="description"/>
          <input className="date-input texto" type="date" id="data-limite" name="endDate"/>
          <input className="number-input texto" placeholder="Meta de arrecadação" type="number" name="fundraisingGoal"/>
          <input className="number-input texto" placeholder="Valor mínimo para doação" type="number" name="minimumContributionValue"/>
          <select className="text-input texto" name="category" id="categoria">
            <option className="text-input texto" value="">
              Escolha uma categoria
            </option>
            <option className="text-input texto" value="ARTS">
              Artes
            </option>
            <option className="text-input texto" value="GAMES">
              Jogos
            </option>
            <option className="text-input texto" value="MUSIC">
              Música
            </option>
          </select>
            <input className="purple-button texto" type="submit" value="Criar projeto" />
          </form>

        </div>
      </div>
    </div>

  );
}

export default ProjectRegister;