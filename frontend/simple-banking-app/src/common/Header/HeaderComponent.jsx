import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const HeaderComponent = () => {
    // const [isAuthenticated, setAuthentication] = useState(false)
    const navigate = useNavigate()

    const handleLogout = () => {
        console.log("Logged out!")
    }

    const handleLogin = () => {
        console.log("Navigating to Log in page...")
        navigate('/login')
    }

    return (
        <header>
            <div height="300px">
                <div align="center">
                    <h1>Simple Banking App</h1>
                </div>
                <div align="right">
                    <button name="login" type="button" onClick={handleLogin}>Log in</button>
                    <button name="logout" type="button" onClick={handleLogout}>Log out</button>
                </div>
            </div>
        </header>
    )
}

export default HeaderComponent;