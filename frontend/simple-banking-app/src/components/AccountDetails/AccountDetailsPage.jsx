import './AccountDetailsPage.css'

import { useNavigate, useParams } from 'react-router-dom';
import { HOME_PAGE_URL } from '../../common/Constants';
import { useEffect, useState } from 'react';
import { getTransactionsForAccount } from '../../api/TransactionApiService';

const AccountDetailsPage = () => {
    const { accountId } = useParams()
    const [transactions, setTransactions] = useState([])
    const navigate = useNavigate()

    useEffect(() => {
        getTransactionsForAccount(accountId)
        .then((response) => setTransactions(response.data))
        .catch((error) => console.log(error))
    }, [accountId])

    const redIfNegative = (type) => {
        console.log(type)
        if (type === "withdrawal") {
            return "red"
        } else {
            return "green"
        }
    }

    const handleGoBack = () => navigate(HOME_PAGE_URL)

    return (
        <div>
            <h1>Account {accountId}</h1>
            <div className="tables">
                <table>
                    <thead>
                        <tr>
                            <th>Type</th>
                            <th>Amount</th>
                            <th>Description</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            transactions.map(
                                transaction => (
                                    <tr key={transaction.id} color={redIfNegative(transaction.type)}>
                                        <td>{transaction.type}</td>
                                        <td>{transaction.amount}</td>
                                        <td>{transaction.description}</td>
                                    </tr>
                                )
                            )
                        }
                    </tbody>
                </table>
            </div>
            <div className="go-back" align="center">
                <button type="button" name="go-back" onClick={handleGoBack}>Go Back</button>
            </div>
        </div>
        
    )
}

export default AccountDetailsPage;