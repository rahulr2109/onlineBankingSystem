import React, { useState, useEffect } from 'react';
import axios from 'axios';
import LoanTable from '../components/LoanTable';
import LoanStatus from '../components/LoanStatus';

const AdminDashboard = () => {
  const [loans, setLoans] = useState([]);
  const [pendingLoans, setPendingLoans] = useState([]);
  const [approvedLoans, setApprovedLoans] = useState([]);
  const [rejectedLoans, setRejectedLoans] = useState([]);

  useEffect(() => {
    fetchLoans();
  }, []);

  const fetchLoans = async () => {
    const response = await axios.get('http://localhost:8080/api/loans');
    setLoans(response.data);
    setPendingLoans(response.data.filter(loan => loan.status === 'pending'));
    setApprovedLoans(response.data.filter(loan => loan.status === 'approved'));
    setRejectedLoans(response.data.filter(loan => loan.status === 'rejected'));
  };

  const updateLoanStatus = async (id, status) => {
    await axios.put(`http://localhost:8080/api/loans/${id}`, { status });
    fetchLoans();
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <header className="bg-blue-600 text-white py-4 shadow-md">
        <h1 className="text-center text-3xl font-bold">Admin Dashboard For Loan Requests</h1>
      </header>
      <main className="container mx-auto p-4">
        <LoanStatus pending={pendingLoans.length} approved={approvedLoans.length} rejected={rejectedLoans.length} />
        <h2 className="text-2xl font-bold mb-4">Pending Loans</h2>
        <LoanTable loans={pendingLoans} updateLoanStatus={updateLoanStatus} />
        <h2 className="text-2xl font-bold mb-4 mt-8">Approved Loans</h2>
        <LoanTable loans={approvedLoans} readOnly />
        <h2 className="text-2xl font-bold mb-4 mt-8">Rejected Loans</h2>
        <LoanTable loans={rejectedLoans} readOnly />
      </main>
    </div>
  );
};

export default AdminDashboard;
