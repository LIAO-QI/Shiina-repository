import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from './Home'
import Login from './Login'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  Home, Login
]

const router = new VueRouter({
  routes
})

export default router