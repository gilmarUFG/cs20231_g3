//Nesse arquivo está nossa homepage
import './App.css';
import Layout from './Components/Layout';
import {Route, Routes} from 'react-router-dom';
import IndexPage from './Pages/IndexPage';
import LoginPage from './Pages/LoginPage';
import RegisterPage from './Pages/RegisterPage';
import CreateProject from './Pages/CreateProject';
import { UserContextProvider } from './UserContext';

function App() {
  return (
    <UserContextProvider>

      <Routes>
        <Route path="/" element={<Layout />}>

          <Route index element={ <IndexPage /> }/>

          <Route path="/login" element={ <LoginPage /> }/>

          <Route path="/register" element={ <RegisterPage /> }/>

          <Route path="/create" element={ <CreateProject /> }/>

        </Route>
      </Routes>
    </UserContextProvider>
  );
}

export default App;
