import './BankingApp.css'

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
                    <Route path='/' element={ <HomePage /> } />
                    <Route path='/login' element={ <LoginPage /> } />
                </Routes>
                <FooterComponent />
            </BrowserRouter>
        </div>
    )
}

export default BankingApp;