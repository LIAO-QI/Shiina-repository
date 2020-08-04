import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const routes = [
    {
        path: '/',
        component: () => import('./layouts/MainLayout.vue'),
        children: [
            {
                path: '',
                // redirect: '/signin',
                component: () => import('./views/main/Index.vue')
            },
            {
                path:'find',
                component: () => import('./views/main/Find.vue')
            },
            {
                path:'message',
                component: () => import('./views/main/Message.vue')
            }
        ]
    },
    {
        path: '/login',
        component: () => import ('./layouts/SigninLayout.vue'),
        children: [
            {
                path: '',
                component: () => import('./views/login/Signin.vue')
            },
            {
                path: 'signup',
                component: () => import('./views/login/Signup.vue')
            }
        ]
    },
    {
        path: '*',
        component: () => import('./views/NotFound.vue')
    }
]

const router = new Router({
    routes,
    mode: 'history'
})

export default router