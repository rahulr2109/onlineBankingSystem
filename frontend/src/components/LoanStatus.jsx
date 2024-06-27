import React from 'react';

const LoanStatus = ({ pending, approved, rejected }) => {
  return (
    <div className="flex justify-around mb-8">
      <div className="bg-white p-4 shadow-md rounded-lg text-center">
        <h3 className="text-xl font-bold">Pending Loans</h3>
        <p className="text-2xl">{pending}</p>
      </div>
      <div className="bg-white p-4 shadow-md rounded-lg text-center">
        <h3 className="text-xl font-bold">Approved Loans</h3>
        <p className="text-2xl">{approved}</p>
      </div>
      <div className="bg-white p-4 shadow-md rounded-lg text-center">
        <h3 className="text-xl font-bold">Rejected Loans</h3>
        <p className="text-2xl">{rejected}</p>
      </div>
    </div>
  );
};

export default LoanStatus;
