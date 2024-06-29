import React, { useState, useEffect } from 'react';
import axios from 'axios';
import LoanForm from '../components/LoanForm';
import LoanList from '../components/LoanList';

const UserDashboard = () => {
  const [loans, setLoans] = useState([]);
  const [loan, setLoan] = useState(null);

  useEffect(() => {
    fetchLoans();
  }, []);

  const fetchLoans = async () => {
    const response = await axios.get('http://localhost:8080/api/loans');
    setLoans(response.data);
  };

  const deleteLoan = async (id) => {
    await axios.delete(`http://localhost:8080/api/loans/${id}`);
    fetchLoans();
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <header className="bg-blue-600 text-white py-4 shadow-md">
        <h1 className="text-center text-3xl font-bold">User DashBoard For Loan Request</h1>
      </header>
      <main className="container mx-auto p-4">
        <div className="grid grid-cols-1 md:grid-cols-2 gap-8">
          <div>
            <LoanForm loan={loan} setLoan={setLoan} fetchLoans={fetchLoans} />
          </div>
          <div>
            <h2 className="text-2xl font-bold mb-4">Loan Request</h2>
            <LoanList loans={loans} setLoan={setLoan} deleteLoan={deleteLoan} />
          </div>
        </div>
      </main>
    </div>
  );
};

export default UserDashboard;
