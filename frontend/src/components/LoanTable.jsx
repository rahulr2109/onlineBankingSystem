import React from 'react';

const LoanTable = ({ loans, updateLoanStatus, readOnly }) => {
  return (
    <div className="bg-white p-4 shadow-md rounded-lg">
      <div className="overflow-x-auto">
        <table className="w-full table-auto">
          <thead>
            <tr>
              <th className="px-4 py-2">Loan Type</th>
              <th className="px-4 py-2">Loan Amount</th>
              <th className="px-4 py-2">Reason</th>
              {!readOnly && <th className="px-4 py-2">Actions</th>}
            </tr>
          </thead>
          <tbody>
            {loans.map(loan => (
              <tr key={loan.id} className="border-b border-gray-200">
                <td className="px-4 py-2">{loan.loanType}</td>
                <td className="px-4 py-2">{loan.amount}</td>
                <td className="px-4 py-2">{loan.reason}</td>
                {!readOnly && (
                  <td className="px-4 py-2">
                    <button
                      onClick={() => updateLoanStatus(loan.id, {...loan,  status:'approved' })}
                      className="bg-green-500 text-white px-4 py-1 rounded-md mr-2 hover:bg-green-700"
                    >
                      Approve
                    </button>
                    <button
                      onClick={() => updateLoanStatus(loan.id, { ...loan, status:'rejected'})}
                      className="bg-red-500 text-white px-4 py-1 rounded-md hover:bg-red-700"
                    >
                      Reject
                    </button>
                  </td>
                )}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default LoanTable;
