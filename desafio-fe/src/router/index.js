import Vue from 'vue'
import VueRouter from 'vue-router'
import ProductView from '../views/ProductView.vue'
import ProductTypeView from '../views/ProductTypeView'
import OperationView from '../views/OperationView'
import OperationTypeView from '../views/OperationTypeView'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Productos',
    component: ProductView
  },
  {
    path: '/producttype',
    name: 'Tipo de productos',
    component: ProductTypeView
  },
  {
    path: '/operation',
    name: 'Tipo de productos',
    component: OperationView
  },
  {
    path: '/operationtype',
    name: 'Tipo de productos',
    component: OperationTypeView
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
