import React, { useState, useEffect } from 'react';
import './reset.css';
import './main.css';
import './projectregister.css';
import axios from 'axios';

function RewardRegister() {
    const [lastProjectId, setLastProjectId] = useState(0);
    const [rewardRegisterError, setRewardRegisterError] = useState(false);

    useEffect(() => {
        async function fetchLastProjectId() {
            try {
                // Get the token from localStorage
                const authToken = localStorage.getItem('authToken');

                const response = await axios.get('http://ec2-18-188-192-228.us-east-2.compute.amazonaws.com:8080/api/v1/projects/get-by-user', {
                    headers: {
                        Authorization: `Bearer ${authToken}`
                    }
                });

                const lastProject = response.data[response.data.length - 1]; // Assuming the last project is the last element
                setLastProjectId(lastProject.id);
                console.log('Last Project ID:', lastProject.id); // Print the last project's ID to the console
            } catch (error) {
                console.error('Error fetching last project:', error);
            }
        }

        fetchLastProjectId();
    }, []);

    const handleRewardRegister = async (event) => {
        event.preventDefault();

        const description = event.target.elements.description.value;
        const minValue = event.target.elements.minValue.value;
        const expectedDeliveryDate = event.target.elements.expectedDeliveryDate.value;

        try {
            // Get the token from localStorage
            const authToken = localStorage.getItem('authToken');

            const url = `http://ec2-18-188-192-228.us-east-2.compute.amazonaws.com:8080/api/v1/rewards/${lastProjectId}`;

            const data = {
                description,
                minValue,
                expectedDeliveryDate
            };

            const response = await axios.post(url, data, {
                headers: {
                    Authorization: `Bearer ${authToken}`
                }
            });

            // Handle the response as needed
        } catch (error) {
            console.error('Error creating reward:', error);
            setRewardRegisterError(true);
        }
    };

    return (
        <div className="viewport-div">
            <div className="main-container">
                <div className="inside-container">
                    <h1 className="titulo-principal">Registre recompensas</h1>
                    <div className="destaque titulo-secundario">Quase lá! As recompensas são uma forma de atrair doações mais significativas pro seu projeto</div>

                    <form className="register-project-form" onSubmit={handleRewardRegister}>
                        <input className="text-input texto" placeholder="Descrição" type="text" name='description'/>
                        <input className="number-input texto" placeholder="Valor" type="number" name="minValue"/>
                        <label htmlFor="data-limite" className="texto">Data esperada de entrega da recompensa</label>
                        <input className="date-input texto" type="date" name="expectedDeliveryDate" id="data-limite" />
                        <input className="purple-button texto" type="submit" value="Publicar projeto" />
                    </form>
                </div>
            </div>
        </div>
    );
}

export default RewardRegister;