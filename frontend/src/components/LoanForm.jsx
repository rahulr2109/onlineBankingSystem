import React, { useState, useEffect } from 'react';
import axios from 'axios';

const LoanForm = ({ loan, setLoan, fetchLoans }) => {
  const [loanType, setLoanType] = useState(loan ? loan.loanType : '');
  const [amount, setAmount] = useState(loan ? loan.amount : '');
  const [reason, setReason] = useState(loan ? loan.reason : '');

  useEffect(() => {
    if (loan) {
      setLoanType(loan.loanType);
      setAmount(loan.amount);
      setReason(loan.reason);
    }
  }, [loan]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (loan) {
      await axios.put(`http://localhost:8080/api/loans`, { ...loan, loanType, amount, reason });
    } else {
      await axios.post('http://localhost:8080/api/loans', { loanType, amount, reason });
    }
    setLoan(null);
    fetchLoans();
    setLoanType('');
    setAmount('');
    setReason('');
  };

  return (
    <form onSubmit={handleSubmit} className="max-w-lg mx-auto bg-white p-8 shadow-md rounded-lg mt-8">
      <h2 className="text-2xl font-bold mb-6">{loan ? 'Update Loan Request' : 'Add Loan Request'}</h2>
      <div className="mb-4">
        <label htmlFor="loanType" className="block text-gray-700 font-semibold mb-2">Loan Type</label>
        <input
          type="text"
          id="loanType"
          value={loanType}
          onChange={(e) => setLoanType(e.target.value)}
          placeholder="Loan Type"
          required
          className="w-full px-3 py-2 border border-gray-300 rounded-md"
        />
      </div>
      <div className="mb-4">
        <label htmlFor="loanAmount" className="block text-gray-700 font-semibold mb-2">Loan Amount</label>
        <input
          type="text"
          id="loanAmount"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
          placeholder="Loan Amount"
          required
          className="w-full px-3 py-2 border border-gray-300 rounded-md"
        />
      </div>
      <div className="mb-4">
        <label htmlFor="reason" className="block text-gray-700 font-semibold mb-2">Reason for applying for loan</label>
        <input
          type="text"
          id="reason"
          value={reason}
          onChange={(e) => setReason(e.target.value)}
          placeholder="Reason"
          required
          className="w-full px-3 py-2 border border-gray-300 rounded-md"
        />
      </div>
      <button
        type="submit"
        className="w-full bg-blue-500 text-white py-2 rounded-md hover:bg-blue-700 transition-colors duration-300"
      >
        {loan ? 'Update Loan Request' : 'Sent Loan Request'}
      </button>
    </form>
  );
};

export default LoanForm;
