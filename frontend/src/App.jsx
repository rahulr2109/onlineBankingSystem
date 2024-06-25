import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import Register from './components/Register';
import Login from './components/Login';
import AddLoanOfficer from './components/AddLoanOfficer';
import Home from './components/Home';

function App() {
  return (
    <Router>
      <div className="min-h-screen bg-gray-100 flex flex-col items-center">
        <nav className="bg-white shadow-lg w-full">
          <div className="container mx-auto px-6 py-3">
            <div className="flex justify-between items-center">
              <div className="text-gray-800 text-xl font-bold">Loan Management System</div>
              <div>
                <Link to="/" className="text-gray-600 hover:text-gray-800 mx-2">Home</Link>
                <Link to="/register" className="text-gray-600 hover:text-gray-800 mx-2">Register</Link>
                <Link to="/login" className="text-gray-600 hover:text-gray-800 mx-2">Login</Link>
                {/* <Link to="/add-loan-officer" className="text-gray-600 hover:text-gray-800 mx-2">Add Loan Officer</Link> */}
              </div>
            </div>
          </div>
        </nav>
        <div className="container mx-auto p-6">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/register" element={<Register />} />
            <Route path="/login" element={<Login />} />
            {/* <Route path="/add-loan-officer" element={<AddLoanOfficer />} /> */}
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
