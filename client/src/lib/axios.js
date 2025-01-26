import axios from 'axios';

//actualizar la base url en el deploy
export const axiosInstance = axios.create({
    baseURL: 'http://localhost:5000/api',
    withCredentials: true,

})