import './BankingApp.css'

import * as Constants from '../../common/Constants'

import HeaderComponent from '../../common/Header/HeaderComponent'
import FooterComponent from '../../common/Footer/FooterComponent'
import LoginPage from '../Login/LoginPage'
import HomePage from '../Home/HomePage'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'

const BankingApp = () => {
    return (
        <div className="BankingApp">
            <BrowserRouter>
                <HeaderComponent />
                <Routes>
                    <Route path={Constants.HOME_PAGE_URL} element={ <HomePage /> } />
                    <Route path={Constants.LOGIN_PAGE_URL} element={ <LoginPage /> } />
                </Routes>
                <FooterComponent />
            </BrowserRouter>
        </div>
    )
}

export default BankingApp;