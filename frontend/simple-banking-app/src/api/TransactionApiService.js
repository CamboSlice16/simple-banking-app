import apiClient from './ApiClientService'

// Transactions
export const addDeposit = (amount, accountId) => apiClient.post('transaction/deposit')
export const addWithdrawal = (amount, accountId) => apiClient.post('transaction/withdrawal')
export const addTransfer = (amount, accountFrom, accountTo) => apiClient.post('transaction/transfer')

// Accounts
export const getAccountsForUser = (username) => apiClient.get('/accounts/${username}')