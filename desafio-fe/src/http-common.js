import Axios from 'axios'

export const HTTP = Axios.create({
  baseURL: 'http://localhost:5000/'
})
