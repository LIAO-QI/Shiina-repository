import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

const routes = [
	{
		path: '',
		meta: {
			index: 0,
			title: '登录'
		},
		component: () => import('./views/Login.vue')
	},

	{
		path: '/register',
		meta: {
			index: 1,
			title:'注册'
		},
		component: () => import('./views/Register.vue')
	},
	
	{
		path: '/forgot',
		meta: {
			index: 1,
			title: '找回密码'
		},
		component: () => import('./views/Forgot.vue')
	}, 
	
	{
		path: '/main',
		meta: {
			index: 0,
			keepAlive: true,
			scrollTop: 0,
			title: '主页'
		},
		component: () => import('./views/Main.vue')
	},

	{
		path: '/homework',
		meta: {
			index: 1,
			title: '作业板'
		},
		component: () => import('./views/Homework.vue')
	},
	
	{
		path: '/subject',
		meta: {
			index: 2,
			title: '课程表'
		},
		component: () => import('./views/Subject.vue')
	},

	{
		path: '*',
		component: () => import('./views/Error.vue')
	}
];

const router = new Router({
	mode:'history',
	routes
});

router.beforeEach((to, from, next) => {
	const title = to.meta && to.meta.title;
	if (title) {
		document.title = title;
	}
	next();
});

export {
	router
};