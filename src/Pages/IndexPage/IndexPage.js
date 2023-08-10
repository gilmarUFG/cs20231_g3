import Project from "../../Components/Project/Project.js";
import App from '../../App.js';
import React from 'react';
import './IndexPage.css'; // Import your CSS file

import homelogo from '../../Assets/home_logo.png';
import search_icon from '../../Assets/search.png';
import profile_placeholder from '../../Assets/profile-placeholder.png';

const Navbar = () => {
  return (
    <nav className="navbar">
      <img src={homelogo} alt="Logo da Financie.se" />
      <form action="" className="search-bar">
        <button type="submit">
          <img src={search_icon} alt="" />
        </button>
        <input className="texto" type="text" name="" id="" />
      </form>
      <ul className="navbar-links">
        <li>
          <a href="">
            <h2>Contato</h2>
          </a>
        </li>
        <li>
          <a href="">
            <h2>Sobre Nós</h2>
          </a>
        </li>
        <li>
          <a href="">
            <img
              src={profile_placeholder}
              alt="Foto de Perfil"
            />
          </a>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
