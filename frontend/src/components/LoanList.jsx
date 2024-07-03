import React from 'react';

const LoanList = ({ loans, setLoan, deleteLoan }) => {
  return (
    <div className="bg-white p-4 shadow-md rounded-lg">
      <div className="overflow-x-auto">
        <table className="w-full table-auto">
          <thead>
            <tr>
              <th className="px-4 py-2">Loan Type</th>
              <th className="px-4 py-2">Loan Amount</th>
              <th className="px-4 py-2">Reason for applying for loan</th>
              <th className="px-4 py-2">Actions</th>
            </tr>
          </thead>
          <tbody>
            {loans.map((loan) => (
              <tr key={loan.id} className="border-b border-gray-200">
                <td className="px-4 py-2">{loan.loanType}</td>
                <td className="px-4 py-2">{loan.amount}</td>
                <td className="px-4 py-2">{loan.reason}</td>
                <td className="px-4 py-2">
                  {/* <button
                    onClick={() => setLoan(loan)}
                    className="bg-blue-500 text-white px-4 py-1 rounded-md mr-2 hover:bg-blue-700"
                  >
                    Edit
                  </button> */}
                  <button
                    onClick={() => deleteLoan(loan.id)}
                    className="bg-red-500 text-white px-4 py-1 rounded-md hover:bg-red-700"
                  >
                    Delete
                  </button>
                  <span
                    className="bg-blue-500 text-white px-4 py-1 rounded-md mr-2 hover:bg-blue-700"
                  >
                    {loan.status}
                  </span>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default LoanList;
