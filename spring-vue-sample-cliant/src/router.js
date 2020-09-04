import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    },
    {
      path: '/currency',
      name: 'currency',
      component: () => import(/* webpackChunkName: "currency" */ './views/Currency.vue')
    },
    {
      path: '/signup',
      name: 'signup',
      component: () => import(/* webpackChunkName: "currency" */ './views/Signup.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import(/* webpackChunkName: "currency" */ './views/Login.vue')
    },
    {
      path: '/message',
      name: 'message',
      component: () => import(/* webpackChunkName: "currency" */ './views/Message.vue')
    },
    {
      path: '/setting',
      name: 'setting',
      component: () => import(/* webpackChunkName: "currency" */ './views/Setting.vue')
    },
    {
      path: '/management',
      name: 'management',
      component: () => import(/* webpackChunkName: "currency" */ './views/Management.vue')
    },
  ]
})