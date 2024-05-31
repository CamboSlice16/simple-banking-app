import { useNavigate } from 'react-router-dom';
import './ListAccountsComponent.css'
import { ACCOUNT_PAGE_URL } from '../../common/Constants';

// Lists Accounts for the logged in user
// Located on Home Page

const ListAccountComponent = ({accounts}) => {
    // const navigate = useNavigate()

    // const handleRowClick = (id) => {
    //     console.log(id)
    //     // navigate(`${ACCOUNT_PAGE_URL}/${id}`)
    // }

    return (
        <div className="accounts">
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Balance</th>
                    </tr>
                </thead>
                <tbody>
                {
                    accounts.map(
                        account => (
                            <tr key={account.id}>
                                <td>{account.name}</td>
                                <td>{account.type}</td>
                                <td>{account.balance}</td>
                            </tr>
                        )
                    )
                }
                </tbody>
            </table>
        </div>
    )
}

export default ListAccountComponent;