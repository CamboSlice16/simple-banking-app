import './DepositPage.css'

import { HOME_PAGE_URL } from '../../common/Constants'

import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { postDeposit } from '../../api/TransactionApiService'

const DepositPage = () => {
    const [amount] = useState(0.00)
    const [accountId] = useState(0)
    const [submitted, setSubmitted] = useState(false)
    const navigate = useNavigate()

    console.log("Submitted: ", submitted)

    const handleGoBack = () => navigate(HOME_PAGE_URL)

    const handleSubmit = () => {
        // postDeposit(amount, accountId)

        console.log("Deposit successful!")
        setSubmitted(submitted => !submitted)
    }

    const onSubmit = (values) => {
        postDeposit(values.amount, values.accountId)
            .then(response => console.log(values))
            .catch(error => console.log(error))
    }

    // Dummy data
    const userId = 1
    var accounts = [
        {id: 1, name: "Camdyn Checking", type: "checking", balance: 1500.58, owner_id: 1},
        {id: 2, name: "Camdyn Savings", type: "savings", balance: 34668.00, owner_id: 1},
        {id: 3, name: "EMERGENCY FUND", type: "savings", balance: 3450.45, owner_id: 1}
    ]

    // TODO: Get real account list
    // TODO: POST request for deposit

    return (
        <div>
            <h1>Deposit Form</h1>
            <form>
                <div>
                    <label htmlFor="account">Select Account:</label>
                    <select id="account">
                    {
                        accounts.map(
                            account => (
                                <option key={account.id} value={account.id}>{account.name}</option>
                            )
                        )
                    }
                    </select>
                </div>
                <div>
                    <label htmlFor="amount">Amount</label>
                    <input type="number" id="amount" />
                </div>
                <div>
                    <button type="submit" name="submit-deposit">Submit Deposit</button>
                </div>
            </form>
            <div display="block">
                {submitted === true ? <h2>Deposit processed!</h2> : ""}
                <button type="button" name="go-back" onClick={handleGoBack}>Go Back</button>
            </div>
        </div>
    )
}

export default DepositPage;