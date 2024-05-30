import axios from 'axios'

import { BACKEND_ENDPOINT } from '../common/Constants';

const apiClient = axios.create({
    baseURL: BACKEND_ENDPOINT
    // headers: { 'Access-Control-Allow-Origin': '*' }
})

export default apiClient;