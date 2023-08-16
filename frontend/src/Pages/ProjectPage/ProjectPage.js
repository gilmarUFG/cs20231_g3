import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom'; // Import useNavigate and useParams

import homelogo from '../../Assets/home-logo.png';
import search from '../../Assets/search.png';

import './reset.css';
import './main.css';
import './project.css';

function ProjectPage() {
  const [projectData, setProjectData] = useState(null);
  const navigate = useNavigate(); // Get the navigate function from React Router
  const { projectId } = useParams(); // Get the project ID from the URL
  const apiUrl = `http://ec2-18-188-192-228.us-east-2.compute.amazonaws.com:8080/api/v1/projects/get/${projectId}`;

  useEffect(() => {
    fetch(apiUrl)
      .then(response => response.json())
      .then(data => setProjectData(data))
      .catch(error => console.error('Error fetching project data:', error));
  }, [apiUrl]);

  const handleDonateClick = () => {
    navigate(`/Contribution/${projectId}`); // Redirect to the donation page with the correct project ID
  };

  return (
    <div>
      <nav className="navbar">
        <a href="/"><img src={homelogo} alt="Logo da Financie.se"/></a>
        <form action="" className="search-bar">
          <button type="submit"><img src={search} alt="" /></button>
          <input className="texto" type="text" name="" id="" />
        </form>
        <ul className="navbar-links">
          <li><a href="/login"><h2>Login</h2></a></li>
          <li><a href="/register"><h2>Cadastrar</h2></a></li>
        </ul>
      </nav>

      <section className="banner">
        {projectData && <h1 className="banner-title">{projectData.title}</h1>}
      </section>

      <section className="principal">
        <h1>{projectData && projectData.subtitle}</h1>
        <div className="principal-contents">
          <div className="principal-contents-descricao-box">
            <div className="destaque">
              {projectData && projectData.description}
            </div>
          </div>
          <div className="principal-contents-pagamento-box">
            <div className="destaque">
              {projectData && `${projectData.percentageRaised}% da meta alcançada`}
            </div>
            <div className="texto">
              {projectData && `R$${projectData.totalRaised.toFixed(2)} / R$${projectData.fundraisingGoal.toFixed(2)}`}
            </div>
            <button className="purple-button texto" onClick={handleDonateClick} name='abada'>
              Doar
            </button>
          </div>
        </div>
      </section>
    </div>
  );
}

export default ProjectPage;
