import './DepositPage.css'

import { HOME_PAGE_URL } from '../../common/Constants'

import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const DepositPage = () => {
    const [amount, setAmount] = useState('0.00')
    const [submitted, setSubmitted] = useState(false)
    const navigate = useNavigate()

    console.log("Submitted: ", submitted)

    const handleAmountChange = (event) => setAmount(event.target.value)
    const handleGoBack = () => navigate(HOME_PAGE_URL)

    const handleSubmit = () => {
        console.log("Deposit successful!")
        setSubmitted(submitted => !submitted)
    }

    // Dummy data
    const userId = 1
    var accounts = [
        {id: 1, name: "Camdyn Checking", type: "checking", balance: 1500.58, owner_id: 1},
        {id: 2, name: "Camdyn Savings", type: "savings", balance: 34668.00, owner_id: 1},
        {id: 3, name: "EMERGENCY FUND", type: "savings", balance: 3450.45, owner_id: 1}
    ]

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
                                <option value={account.id}>{account.name}</option>
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
                    <button type="button" name="submit-deposit" onClick={handleSubmit}>Submit Deposit</button>
                </div>
            </form>
            <div display="block">
                {submitted == true ? <h2>Deposit processed!</h2> : ""}
                <button type="button" name="go-back" onClick={handleGoBack}>Go Back</button>
            </div>
        </div>
    )
}

export default DepositPage;