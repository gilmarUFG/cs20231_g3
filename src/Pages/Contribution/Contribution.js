import React from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';

import './reset.css';
import './main.css';
import './Contribution.css';

function Donate() {
    const { projectId } = useParams();

    const handleSubmit = async (event) => {
        event.preventDefault();

        const value = event.target.elements.valor.value;
        const paymentMethod = "PIX";
        const url = `http://ec2-18-188-192-228.us-east-2.compute.amazonaws.com:8080/api/v1/contributions/${projectId}`;

        const data = {
            value,
            paymentMethod
        };

        try {
            const authToken = localStorage.getItem('authToken');
            const response = await axios.post(url, data, {
                headers: {
                  Authorization: `Bearer ${authToken}` 
                }
            });            
            console.log('API response:', response.data);
            window.location.href = '/';

        } catch (error) {
            console.error('Error making API call:', error);

            if (error.response) {
                console.log('API response data:', error.response.data);
                console.log('API response status:', error.response.status);
            } else if (error.request) {
                console.log('No response received:', error.request);
            } else {
                console.log('Error setting up the request:', error.message);
            }
        }
    };

    return (
        <div className="viewport-div">
        <div className="main-container">
            <div className="inside-container">
            <h1 className="titulo-principal">Realize sua doação</h1>
            <div className="destaque titulo-secundario">Insira os dados do cartão de crédito e o valor da doação</div>

            <form className="register-project-form" onSubmit={handleSubmit}>
                <input className="text-input texto" placeholder="Nome no cartão" type="text" />
                <input className="text-input texto" placeholder="Número do cartão" type="number" />
                <div className="credit-card-date-box">
                <input className="text-input texto" placeholder="MV" type="number" />
                <input className="text-input texto" placeholder="DV" type="number" />
                </div>
                <input className="text-input texto" placeholder="Valor da doação" type="number" name='valor'/>
                <input className="purple-button texto" type="submit" value="Confirmar doação" />
            </form>
            </div>
        </div>
        </div>
    );
}

export default Donate;
