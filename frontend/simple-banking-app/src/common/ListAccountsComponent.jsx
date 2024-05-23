

const ListAccountComponent = ({accounts}) => {


    return (
        <div>
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