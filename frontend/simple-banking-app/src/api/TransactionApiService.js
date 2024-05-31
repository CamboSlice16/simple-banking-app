import apiClient from './ApiClientService'

// Transactions
export const postDeposit = (transaction) => apiClient.post(`transaction/deposit`, transaction)
export const postWithdrawal = (transaction) => apiClient.post(`transaction/withdrawal`, transaction)
export const postTransfer = (transaction) => apiClient.post(`transaction/transfer`, transaction)

// Accounts
export const getAccountsForUser = (username) => apiClient.get(`/accounts/${username}`)
export const getTransactionsForAccount = (accountId) => apiClient.get(`accounts/details/${accountId}`)