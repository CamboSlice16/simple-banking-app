import './HeaderComponent.css'

import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useAuth } from '../security/AuthContext'

const HeaderComponent = () => {
    // const [isAuthenticated, setAuthentication] = useState(false)
    const navigate = useNavigate()
    const authContext = useAuth()

    const handleLogout = () => {
        console.log("Logged out!")
    }

    const handleLogin = () => {
        console.log("Navigating to Log in page...")
        navigate('/login')
    }

    return (
        <header>
            <div className="header">
                <div className="title" align="center">
                    <h1>Simple Banking App</h1>
                </div>
                <div className="logout" align="right">
                    {authContext.isAuthenticated === false ? "" :
                    <button name="logout" type="button" onClick={handleLogout}>Log out</button>}
                </div>
            </div>
        </header>
    )
}

export default HeaderComponent;