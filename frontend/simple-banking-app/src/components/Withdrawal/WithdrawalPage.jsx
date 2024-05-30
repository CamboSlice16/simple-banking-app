import './WithdrawalPage.css'

import { HOME_PAGE_URL } from '../../common/Constants'

import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { postWithdrawal } from '../../api/TransactionApiService'

const WithdrawalPage = () => {
    // Dummy data
    var accounts = [
        {id: 1, name: "Camdyn Checking", type: "checking", balance: 1500.58, owner_id: 1},
        {id: 2, name: "Camdyn Savings", type: "savings", balance: 34668.00, owner_id: 1},
        {id: 3, name: "EMERGENCY FUND", type: "savings", balance: 3450.45, owner_id: 1}
    ]

    const [formData, setFormdata] = useState({
        amount: 0.00,
        accountId: accounts[0].id,
    })
    const [submitted, setSubmitted] = useState(false)
    const [errors, setErrors] = useState([])
    const navigate = useNavigate()

    const handleAccountChange = (event) => {
        setFormdata((prevState) => ({ ...prevState, accountId: event.target.value}))
    }

    const handleAmountChange = (event) => {
        setFormdata((prevState) => ({ ...prevState, amount: event.target.value}))
    }
    
    const handleGoBack = () => navigate(HOME_PAGE_URL)

    const handleSubmit = (event) => {
        event.preventDefault()
        console.log(formData)
        postWithdrawal(formData)
            .catch(error => setErrors(error))
        setSubmitted(submitted => !submitted)
        console.log("Errors:", errors)
    }

    // TODO: Get real account list

    return (
        <div>
            <h1>Withdrawal Form</h1>
            <form>
                <div>
                    <label htmlFor="account">Select Account:</label>
                    <select id="account" onChange={handleAccountChange}>
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
                    <input type="number" id="amount" value={formData.amount} min="0" onChange={handleAmountChange} />
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