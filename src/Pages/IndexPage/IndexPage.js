import React, { useState, useEffect } from "react";
import { Link } from 'react-router-dom'; // Importação do Link para roteamento
import App from '../../App';
import './IndexPage.css';

import homelogo from '../../Assets/home-logo.png';
import search from '../../Assets/search.png';


function IndexPage() {
    const [highlightedProjects, setHighlightedProjects] = useState([]);

    useEffect(() => {
        // Faz a chamada à API para obter os projetos
        fetch("http://ec2-18-188-192-228.us-east-2.compute.amazonaws.com:8080/api/v1/projects/category/GAMES")
            .then(response => response.json())
            .then(data => setHighlightedProjects(data))
            .catch(error => console.error("Erro ao buscar projetos:", error));
    }, []);

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

            <section className="features">
                <a href="/ProjectRegister" className="feature-link">
                    <div className="features-feature" id="feature-cadastro-campanha">
                        <h1>Cadastre uma campanha</h1>
                        <div className="destaque">Mostre ao mundo o que você quer fazer</div>
                    </div>
                </a>
                <a href="" className="feature-link">
                    <div className="features-feature" id="feature-veja-resultados">
                        <h1>Veja resultados</h1>
                        <div className="destaque">Conheça projetos que ganharam vida</div>
                    </div>
                </a>
            </section>

            <section className="highlights">
                <h1>Projetos em destaque</h1>
                <div className="highlights-carousel">
                    {highlightedProjects.map(project => (
                        <div className="highlights-carousel-item" key={project.id}>
                            <div className="highlighted-project">
                                <h1>{project.title}</h1>
                                <h3>{project.subtitle}</h3>
                                <p>{project.description}</p>
                                <Link to={`/ProjectPage/${project.id}`} className="button">
                                    Ver mais
                                </Link>
                            </div>
                        </div>
                    ))}
                </div>
            </section>
        </div>
    );
}


export default IndexPage;
