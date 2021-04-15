import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

const routes = [{
		path: '/login',
		component: () => import('./views/Login.vue'),
		children: [{
				path: '',
				meta: {
					index: 0
				}
			},
			{
				path: 'register',
				meta: {
					index: 1
				},
				component: () => import('./views/Register.vue')
			},
			{
				path: 'forgot',
				meta: {
					index: 1
				},
				component: () => import('./views/Forgot.vue')
			}
		]
	}, {
		path: '/main',
		component: () => import('./views/Main.vue'),
		children: [{
				path: '',
				meta: {
					index: 0,
					keepAlive: true,
					scrollTop: 0
				}
			},
			{
				path: 'homework',
				meta: {
					index: 1,
					title: '作业板'
				},
				component: () => import('./views/Homework.vue')
			},
			{
				path: 'subject',
				meta: {
					index: 2,
					title: '课程表'
				},
				component: () => import('./views/Subject.vue')
			}
		]

	},
	{
		path: '*',
		component: () => import('./views/Error.vue')
	}
]

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
