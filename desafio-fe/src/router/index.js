import Vue from 'vue'
import VueRouter from 'vue-router'
import ProductView from '../views/ProductView.vue'
import ProductTypeView from '../views/ProductTypeView'
import ProductDetailView from '../views/ProductDetailView'
import OperationView from '../views/OperationView'
import OperationTypeView from '../views/OperationTypeView'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'product',
    component: ProductView
  },
  {
    path: '/producttype',
    name: 'producttype',
    component: ProductTypeView
  },
  {
    path: '/operation',
    name: 'operation',
    component: OperationView
  },
  {
    path: '/operationtype',
    name: 'operationtype',
    component: OperationTypeView
  },
  {
    path: '/product/:id',
    name: 'productDetailView',
    component: ProductDetailView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
