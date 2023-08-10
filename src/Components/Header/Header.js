import { Link } from "react-router-dom";
import { useContext, useEffect, useState } from "react";
import { UserContext } from "../../UserContext";
import './header.css';

import homelogo from '../../Assets/home_logo.png';
import search_icon from '../../Assets/search.png';
import profile_placeholder from '../../Assets/profile-placeholder.png';

export default function Header() {
  const {setUserInfo,userInfo} = useContext(UserContext);
  useEffect(() => {
    fetch('http://localhost:4000/profile', {
      credentials: 'include',
    }).then(response => {
      response.json().then(userInfo => {
        setUserInfo(userInfo);
      });
    });
  }, []);

  function logout() {
    fetch('http://localhost:4000/logout', {
      credentials: 'include',
      method: 'POST',
    });
    setUserInfo(null);
  }

  const username = userInfo?.username;

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
}

