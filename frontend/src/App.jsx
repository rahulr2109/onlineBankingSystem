import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import Home from './pages/Home';
import UserDashboard from './pages/UserDashboard';
import AdminDashboard from './pages/AdminDashboard';

function App() {
  return (
    <Router>
      <div className="min-h-screen bg-gray-100 flex flex-col items-center">
        <nav className="bg-white shadow-lg w-full">
          <div className="container mx-auto px-6 py-3">
            <div className="flex justify-between items-center">
              <div className="text-gray-800 text-xl font-bold">Loan Management System</div>
              <div>
                <Link to="/" className="text-gray-600 text-xl font-bold hover:text-gray-800 mx-2">Home</Link>
                <Link to="/user" className="text-gray-600 text-xl font-bold hover:text-gray-800 mx-2">User Dashboard</Link>
                <Link to="/admin" className="text-gray-600 text-xl font-bold hover:text-gray-800 mx-2">Admin Dashboard</Link>
              </div>
            </div>
          </div>
        </nav>
        <div className="container mx-auto p-6">
          <Routes>
            <Route path="/" element={<Home/>} />
            <Route path="/user" element={<UserDashboard/>} />
            <Route path="/admin" element={<AdminDashboard/>} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
