import './TransferPage.css'

import { HOME_PAGE_URL } from '../../common/Constants'

import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { postTransfer } from '../../api/TransactionApiService'

const TransferPage = () => {
    // Dummy data
    var accounts = [
        {id: 1, name: "Camdyn Checking", type: "checking", balance: 1500.58, owner_id: 1},
        {id: 2, name: "Camdyn Savings", type: "savings", balance: 34668.00, owner_id: 1},
        {id: 3, name: "EMERGENCY FUND", type: "savings", balance: 3450.45, owner_id: 1}
    ]
    const [formData, setFormdata] = useState({
        amount: 0.00,
        accountTo: accounts[0].id,
        accountFrom: accounts[0].id,
    })
    const [submitted, setSubmitted] = useState(false)
    const [errors, setErrors] = useState([])
    const navigate = useNavigate()

    const handleAccountToChange = (event) => {
        setFormdata((prevState) => ({ ...prevState, accountTo: event.target.value}))
    }
    
    const handleAccountFromChange = (event) => {
        setFormdata((prevState) => ({ ...prevState, accountFrom: event.target.value}))
    }

    const handleAmountChange = (event) => {
        setFormdata((prevState) => ({ ...prevState, amount: event.target.value}))
    }

    const handleGoBack = () => navigate(HOME_PAGE_URL)

    const handleSubmit = (event) => {
        event.preventDefault()
        console.log(formData)
        postTransfer(formData)
            .catch(error => setErrors({ ...errors, error}))

        if(errors.length === 0) {
            setSubmitted(submitted => true)
        } else {
            console.log("Errors:", errors)
        }
    }

    // TODO: Get real account list

    return (
        <div>
            <h1>Transfer Form</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="accountTo">Transfer To:</label>
                    <select id="accountTo" onChange={handleAccountToChange}>
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
                    <label htmlFor="accountFrom">Transfer From:</label>
                    <select id="accountFrom" onChange={handleAccountFromChange}>
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
                    <input type="number" id="amount" value={formData.amount} onChange={handleAmountChange} />
                </div>
                <div>
                    <button type="submit" name="submit-transfer" disabled={submitted}>Submit Transfer</button>
                </div>
            </form>
            <div display="block">
                {submitted === true ? <h2>Transfer processed!</h2> : ""}
                <button type="button" name="go-back" onClick={handleGoBack}>Go Back</button>
            </div>
        </div>
    )
}

export default TransferPage;