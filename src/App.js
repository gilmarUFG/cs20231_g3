//Nesse arquivo está nossa homepage
import './App.css';
import axios from 'axios';

import Layout from './Components/Layout';
import {Route, Routes} from 'react-router-dom';
import IndexPage from './Pages/IndexPage/IndexPage';
import { UserContextProvider } from './UserContext';

import UserRegister from './Pages/UserRegister/UserRegister';
import UserLogin from './Pages/UserLogin/UserLogin';
import RewardRegister from './Pages/RewardRegister/RewardRegister';
import ProjectRegister from './Pages/ProjectRegister/ProjectRegister';
import ProjectPage from './Pages/ProjectPage/ProjectPage';
import Contribution from './Pages/Contribution/Contribution';

function App() {
  return (
    <UserContextProvider>

      <Routes>
        <Route path="/" element={<Layout />}>

          <Route index element={ <IndexPage /> }/>

          <Route path="/login" element={ <UserLogin /> }/>
          <Route path="/register" element={ <UserRegister /> }/>

          <Route path="/ProjectRegister" element={ <ProjectRegister /> }/>
          <Route path="/ProjectPage/:projectId" element={<ProjectPage />} />
          <Route path="/RewardRegister" element={ <RewardRegister /> }/>

          <Route path="/Contribution/:projectId" element={ <Contribution /> }/>
          
        </Route>
      </Routes>
    </UserContextProvider>
  );
}

export default App;
