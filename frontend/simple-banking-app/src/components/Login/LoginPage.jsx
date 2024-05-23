import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const LoginPage = () => {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const navigate = useNavigate()

    
    const handleUsernameChange = (event) => setUsername(event.target.value)
    const handlePasswordChange = (event) => setPassword(event.target.value)

    const handleSubmit = () => {
        navigate('/')
    }

    return (
        <div>
            Login page!
            <div className="LoginForm">
                <div>
                    <label>Username</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange} />
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange} />
                </div>
                <div>
                    <button type="submit" name="login" onClick={handleSubmit}>Log in</button>
                </div>
            </div>
        </div>
    )
}

export default LoginPage;