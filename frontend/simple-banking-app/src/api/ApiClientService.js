import axios from 'axios'

import { BACKEND_ENDPOINT } from '../common/Constants';

const apiClient = axios.create({
    baseURL: BACKEND_ENDPOINT
})

export default apiClient;