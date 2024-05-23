import './BankingApp.css'

import * as Constants from '../../common/Constants'
import HeaderComponent from '../../common/Header/HeaderComponent'
import FooterComponent from '../../common/Footer/FooterComponent'

import DepositPage from '../Deposit/DepositPage'
import HomePage from '../Home/HomePage'
import LoginPage from '../Login/LoginPage'

import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import WithdrawalPage from '../Withdrawal/WithdrawalPage'

const BankingApp = () => {
    return (
        <div className="BankingApp">
            <BrowserRouter>
                <HeaderComponent />
                <Routes>
                    <Route path={Constants.HOME_PAGE_URL} element={ <HomePage /> } />
                    <Route path={Constants.LOGIN_PAGE_URL} element={ <LoginPage /> } />
                    <Route path={Constants.DEPOSIT_PAGE_URL} element={ <DepositPage /> } />
                    <Route path={Constants.WITHDRAWAL_PAGE_URL} element={ <WithdrawalPage /> } />
                </Routes>
                <FooterComponent />
            </BrowserRouter>
        </div>
    )
}

export default BankingApp;