import React, { useState } from 'react';
import './HomePage.css';
import Search from '../components/searchContainer/Search';
import plane from '../assets/plane.jpg';

function HomePage() {

  const [origin, setOrigin] = useState("");

  return (
    
    <div className="mainDiv">
      <div className="searchContainer">
        <h2>Let's get you traveling</h2>
        <Search />
      </div>
      <div className="passenger">
        <form></form>
      </div>
    </div>
  );
}


export default HomePage;
