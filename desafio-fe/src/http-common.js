import Axios from 'axios'

let accessToken = localStorage.getItem('jwt')

export const HTTP = Axios.create({
  baseURL: 'http://localhost:5000/',
  headers: {
    'Authorization': `token ${accessToken}`
  }
})
