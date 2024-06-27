import React, { useState, useEffect } from 'react';
import axios from 'axios';

const LoanForm = ({ loan, setLoan, fetchLoans }) => {
  const [name, setName] = useState(loan ? loan.name : '');
  const [email, setEmail] = useState(loan ? loan.email : '');
  const [course, setCourse] = useState(loan ? loan.course : '');

  useEffect(() => {
    if (loan) {
      setName(loan.name);
      setEmail(loan.email);
      setCourse(loan.course);
    }
  }, [loan]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (loan) {
      await axios.put(`http://localhost:8080/api/loans`, { ...loan, name, email, course });
    } else {
      await axios.post('http://localhost:8080/api/loans', { name, email, course });
    }
    setLoan(null);
    fetchLoans();
    setName('');
    setEmail('');
    setCourse('');
  };

  return (
    <form onSubmit={handleSubmit} className="max-w-lg mx-auto bg-white p-8 shadow-md rounded-lg mt-8">
      <h2 className="text-2xl font-bold mb-6">{loan ? 'Update Loan Request' : 'Add Loan Request'}</h2>
      <div className="mb-4">
        <label htmlFor="Loan Type" className="block text-gray-700 font-semibold mb-2">Loan Type</label>
        <input
          type="text"
          id="Loan Type"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="Loan Type"
          required
          className="w-full px-3 py-2 border border-gray-300 rounded-md"
        />
      </div>
      <div className="mb-4">
        <label htmlFor="Loan Amount" className="block text-gray-700 font-semibold mb-2">Loan Amount</label>
        <input
          type="number"
          id="Loan Amount"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
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
          value={course}
          onChange={(e) => setCourse(e.target.value)}
          placeholder="Course"
          required
          className="w-full px-3 py-2 border border-gray-300 rounded-md"
        />
      </div>
      <button
        type="submit"
        className="w-full bg-blue-500 text-white py-2 rounded-md hover:bg-blue-700 transition-colors duration-300"
      >
        {loan ? 'Update Loan' : 'Add Loan'}
      </button>
    </form>
  );
};

export default LoanForm;
