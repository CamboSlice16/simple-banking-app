import axios from 'axios'
import apiClient from './ApiClientService'

// Transactions
export const postDeposit = (amount, accountId) => apiClient.post(`transaction/deposit`)
export const postWithdrawal = (amount, accountId) => apiClient.post(`transaction/withdrawal`)
export const postTransfer = (amount, accountFrom, accountTo) => apiClient.post(`transaction/transfer`)

// Accounts
export const getAccountsForUser = (username) => apiClient.get(`/accounts/${username}`)
export const getTransactionsForAccount = (accountId) => apiClient.get(`accounts/${accountId}`)