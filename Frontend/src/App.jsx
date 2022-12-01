import React from 'react';
import ReactDOM from 'react-dom';
import { useState } from 'react';
import { Route, Routes } from 'react-router-dom';
//import './App.css'
import NavBar from './components/NavBar';
import HomePage from './pages/HomePage';
import Error from './pages/Error';

function App() {
  //const [count, setCount] = useState(0);

  return (
    <>
    <NavBar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="*" element={<Error />} />
      </Routes>
      
    </>
  );
}

export default App;
