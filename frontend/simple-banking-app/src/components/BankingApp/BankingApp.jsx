import './BankingApp.css'

import * as Constants from '../../common/Constants'
import HeaderComponent from '../Header/HeaderComponent'

import AuthProvider, { useAuth } from '../security/AuthContext'
import DepositPage from '../Deposit/DepositPage'
import HomePage from '../Home/HomePage'
import LoginPage from '../Login/LoginPage'
import LogoutPage from '../Logout/LogoutPage'

import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import WithdrawalPage from '../Withdrawal/WithdrawalPage'
import TransferPage from '../Transfer/TransferPage'

const AuthenticatedRoute = ({ children }) => {
    const authContext = useAuth()

    if (authContext.isAuthenticated) {
        return children
    }

    return <Navigate to={Constants.LOGIN_PAGE_URL} />
}

const BankingApp = () => {
    return (
        <div className="app">
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent />
                    <Routes>
                        <Route path={Constants.LOGIN_PAGE_URL} element={ <LoginPage /> } />
                        <Route path={Constants.LOGOUT_PAGE_URL} element={ 
                            <AuthenticatedRoute> <LogoutPage /> </AuthenticatedRoute>
                        } />
                        <Route path={Constants.HOME_PAGE_URL} element={
                            <AuthenticatedRoute> <HomePage /> </AuthenticatedRoute>
                        } />
                        <Route path={Constants.DEPOSIT_PAGE_URL} element={
                            <AuthenticatedRoute> <DepositPage /> </AuthenticatedRoute>
                        } />
                        <Route path={Constants.WITHDRAWAL_PAGE_URL} element={
                            <AuthenticatedRoute> <WithdrawalPage /> </AuthenticatedRoute>
                        } />
                        <Route path={Constants.TRANSFER_PAGE_URL} element={
                            <AuthenticatedRoute> <TransferPage /> </AuthenticatedRoute>
                        } />
                    </Routes>
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}

export default BankingApp;