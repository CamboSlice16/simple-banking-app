import './LoginPage.css'

import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useAuth } from '../security/AuthContext'

const LoginPage = () => {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const authContext = useAuth()
    const navigate = useNavigate()

    
    const handleUsernameChange = (event) => setUsername(event.target.value)
    const handlePasswordChange = (event) => setPassword(event.target.value)

    const handleSubmit = () => {
        console.log("Username: ", username)
        console.log("Password: ", password)
        if (authContext.login(username, password)) {
            navigate('/')
            return
        }

    }

    return (
        <div className="form">
            <form className="login">
                <div onSubmit={handleSubmit}>
                    <label>Username</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange} />
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange} />
                </div>
                <div>
                    <button type="submit" name="login">Log in</button>
                </div>
            </form>
        </div>
    )
}

export default LoginPage;