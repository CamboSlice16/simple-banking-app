import './HomePage.css'

import {
    DEPOSIT_PAGE_URL,
    WITHDRAWAL_PAGE_URL,
    TRANSFER_PAGE_URL,
} from '../../common/Constants'

import { getAccountsForUser } from '../../api/TransactionApiService'
import ListAccountComponent from '../../common/ListAccountsComponent'

import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'

const HomePage = () => {
    const [accounts, setAccounts] = useState([])
    const navigate = useNavigate()

    const handleDeposit = () => navigate(DEPOSIT_PAGE_URL)
    const handleWithdrawal = () => navigate(WITHDRAWAL_PAGE_URL)
    const handleTransfer = () => navigate(TRANSFER_PAGE_URL)

    // Dummy data
    const username = "cam_ash"

    useEffect(() => {
        getAccountsForUser(username)
            .then((response) => setAccounts(response.data))
            .catch((error) => console.log(error))
    }, [username])

    // TODO: Get real User ID

    return (
        <div>
            <h1>Welcome!</h1>
            <div>
                <div className="tbl-group">
                { accounts.length === 0 ? "You don't have any accounts open." :
                <ListAccountComponent accounts={accounts} />}
                </div>
                <div className="btn-group">
                    <button name="deposit" type="button" onClick={handleDeposit}>Deposit</button>
                    <button name="withdrawal" type="button" onClick={handleWithdrawal}>Withdrawal</button>
                    <button name="transfer"
                            type="button"
                            onClick={handleTransfer}
                            disabled={accounts.length > 1 ? false : true}
                    >
                        Transfer
                    </button>
                </div>
            </div>
        </div>
    )
}

export default HomePage;