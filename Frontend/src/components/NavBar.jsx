import React from 'react';
import { Link } from 'react-router-dom';
import { FaUserCircle } from 'react-icons/fa';
import { MdHome } from 'react-icons/md';
import './NavBar.css';
import logo from '../assets/logo.svg';

function NavBar() {
  return (
    <div className="navigationStyle">
      <div className="sectionNavBar">
        <img src={logo} alt="logo" />
      </div>

      <div className="sectionNavBar">
        <nav className="middleSection">
          <Link to="/">
            <MdHome id="homeIcon" />
          </Link>
        </nav>
      </div>

      <div className="sectionNavBar">
        <Link to="/login" className="logInLink">
          <ul>
            <li>
              <FaUserCircle id="customerIcon" />
            </li>
            <li>
              <p>NameCustomer</p>
            </li>
          </ul>
        </Link>
      </div>
    </div>
  );
}

export default NavBar;
