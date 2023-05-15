import { useState } from "react";
import { Button, FormControl, FormLabel, Input, Text, Select } from "@chakra-ui/react";
import {
    NumberInput,
    NumberInputField,
    NumberInputStepper,
    NumberIncrementStepper,
    NumberDecrementStepper,
  } from '@chakra-ui/react';

function CreateProject() {
  const [image, setImage] = useState(null);
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [goal, setGoal] = useState(0);
  const [category, setCategory] = useState("");

    async function create (ev) {
        ev.preventDefault();

        const formData = new FormData();
        formData.append("image", image);
        formData.append("name", name);
        formData.append("description", description);
        formData.append("goal", goal.toString);
        formData.append("category", category);

        try {
            await fetch('http://localhost:4000/create', {
                method: 'POST',
                body: formData
            })
            alert('Projeto criado com sucesso!')
        } catch (err) {
            alert('Falha ao criar!')
            console.log(err);
        }
    }

  function handleImageChange(e) {
    const file = e.target.files[0];
    const reader = new FileReader();

    reader.onloadend = () => {
      setImage(reader.result);
    };

    if (file && file.type.startsWith("image/")) {
      reader.readAsDataURL(file);
    }
  }

  function handleGoalChange(v) {
    setGoal(v);
  }

  return (
    <FormControl className="form" onSubmit={create}>
        <Text style={{ fontSize:"25px" }}><strong>Criar um Novo Projeto!</strong></Text>

        <FormLabel className="form-label-create">Nome do Projeto:</FormLabel>
        <Input value={name} width="300px" onChange={(ev) => setName(ev.target.value)}/>

        <FormLabel className="form-label-create">Categoria:</FormLabel>
        <Select value={category} placeholder='Selecione uma opção' width="300px" onChange={(ev) => setCategory(ev.target.value)}>
            <option value='option1'>Arquitetura e Urbanismo</option>
            <option value='option2'>Artes</option>
            <option value='option3'>Ciência e Tecnologia</option>
            <option value='option4'>Design e Moda</option>
            <option value='option5'>Educação</option>
            <option value='option6'>Esportes</option>
            <option value='option7'>Gastronomia</option>
            <option value='option8'>Jogos</option>
            <option value='option9'>Literatura</option>
            <option value='option10'>Música</option>
            <option value='option11'>Podcast</option>
        </Select>

        <FormLabel className="form-label-create">Descrição:</FormLabel>
        <Input value={description} width="300px" onChange={(ev) => setDescription(ev.target.value)}/>

        <FormLabel className="form-label-create">Meta de Arrecadação (R$):</FormLabel>
        <NumberInput value={goal} width="300px" step={1000} min={1000} max={10000000} onChange={handleGoalChange}>
            <NumberInputField value={goal} /> 
                <NumberInputStepper>
                    <NumberIncrementStepper />
                    <NumberDecrementStepper />
                </NumberInputStepper>
        </NumberInput>

        <FormLabel className="form-label-create">Escolha uma Imagem do Projeto:</FormLabel>
        <Input accept="image/*" height="fit-content" width="500px" type="file" onChange={handleImageChange} />
        {image && (
        <img src={image} alt="Preview" style={{ marginTop: "20px", height: "50%", width: "50%" }} />
        )}

        <br></br>
        <Button type="submit" className="create-button" colorScheme='purple'>Criar projeto</Button>
    </FormControl>
  );
}

export default CreateProject;
