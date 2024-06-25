import React, { useState } from 'react';
import axios from 'axios';

const AddLoanOfficer = () => {
  const [username, setUsername] = useState('');
  const [loanOfficerName, setLoanOfficerName] = useState('');
  const [phone, setPhone] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');

  const handleAddLoanOfficer = async () => {
    try {
      const response = await axios.post('/api/admin/addLoanOfficer', {
        username: loanOfficerName,
        phone,
        password,
      }, {
        params: {
          username
        }
      });
      setMessage('Loan officer added successfully!');
    } catch (error) {
      setMessage('Failed to add loan officer.');
    }
  };

  return (
    <div className="bg-white p-8 rounded-lg shadow-lg w-full max-w-md">
      <h2 className="text-2xl font-bold mb-6">Add Loan Officer</h2>
      <input
        type="text"
        className="w-full p-2 mb-4 border rounded"
        placeholder="Admin Username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <input
        type="text"
        className="w-full p-2 mb-4 border rounded"
        placeholder="Loan Officer Name"
        value={loanOfficerName}
        onChange={(e) => setLoanOfficerName(e.target.value)}
      />
      <input
        type="text"
        className="w-full p-2 mb-4 border rounded"
        placeholder="Phone"
        value={phone}
        onChange={(e) => setPhone(e.target.value)}
      />
      <input
        type="password"
        className="w-full p-2 mb-4 border rounded"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <button
        className="w-full bg-blue-500 text-white p-2 rounded"
        onClick={handleAddLoanOfficer}
      >
        Add Loan Officer
      </button>
      {message && <p className="mt-4">{message}</p>}
    </div>
  );
};

export default AddLoanOfficer;
