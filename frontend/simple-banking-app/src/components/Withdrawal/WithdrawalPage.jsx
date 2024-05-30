import './WithdrawalPage.css'

import { HOME_PAGE_URL } from '../../common/Constants'

import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const WithdrawalPage = () => {
    const [amount, setAmount] = useState('0.00')
    const [submitted, setSubmitted] = useState(false)
    const navigate = useNavigate()

    console.log("Submitted: ", submitted)

    const handleAmountChange = (event) => setAmount(event.target.value)
    const handleGoBack = () => navigate(HOME_PAGE_URL)

    const handleSubmit = () => {
        console.log("Withdrawal successful!")
        setSubmitted(submitted => !submitted)
    }

    // Dummy data
    const userId = 1
    var accounts = [
        {id: 1, name: "Camdyn Checking", type: "checking", balance: 1500.58, owner_id: 1},
        {id: 2, name: "Camdyn Savings", type: "savings", balance: 34668.00, owner_id: 1},
        {id: 3, name: "EMERGENCY FUND", type: "savings", balance: 3450.45, owner_id: 1}
    ]

    // TODO: Get real account list
    // TODO: POST request for withdrawal

    return (
        <div>
            <h1>Withdrawal Form</h1>
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
                    <input type="number" id="amount" value={amount} onChange={handleAmountChange} />
                </div>
                <div>
                    <button type="button" name="submit-withdrawal" onClick={handleSubmit}>Submit Withdrawal</button>
                </div>
            </form>
            <div display="block">
                {submitted === true ? <h2>Withdrawal processed!</h2> : ""}
                <button type="button" name="go-back" onClick={handleGoBack}>Go Back</button>
            </div>
        </div>
    )
}

export default WithdrawalPage;