import './BankingApp.css'

import * as Constants from '../../common/Constants'
import HeaderComponent from '../../common/Header/HeaderComponent'

import AuthProvider, { useAuth } from '../security/AuthContext'
import DepositPage from '../Deposit/DepositPage'
import HomePage from '../Home/HomePage'
import LoginPage from '../Login/LoginPage'
import LogoutPage from '../Logout/LogoutPage'

import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import WithdrawalPage from '../Withdrawal/WithdrawalPage'
import TransferPage from '../Transfer/TransferPage'

const BankingApp = () => {
    return (
        <div className="BankingApp">
            <BrowserRouter>
                <HeaderComponent />
                <Routes>
                    <Route path={Constants.LOGIN_PAGE_URL} element={ <LoginPage /> } />
                    <Route path={Constants.LOGOUT_PAGE_URL} element={ 
                        <AuthProvider> <LogoutPage /> </AuthProvider>
                    } />
                    <Route path={Constants.HOME_PAGE_URL} element={
                        <AuthProvider> <HomePage /> </AuthProvider>
                    } />
                    <Route path={Constants.DEPOSIT_PAGE_URL} element={
                        <AuthProvider> <DepositPage /> </AuthProvider>
                    } />
                    <Route path={Constants.WITHDRAWAL_PAGE_URL} element={
                        <AuthProvider> <WithdrawalPage /> </AuthProvider>
                    } />
                    <Route path={Constants.TRANSFER_PAGE_URL} element={
                        <AuthProvider> <TransferPage /> </AuthProvider>
                    } />
                </Routes>
            </BrowserRouter>
        </div>
    )
}

export default BankingApp;