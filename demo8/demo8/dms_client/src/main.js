import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import '@/assets/css/base.css'
// 引入 element-ui
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// 安装 element-ui
Vue.use(ElementUI)

Vue.config.productionTip = false

router.beforeEach((to, from, next) => {
  let getFlag = localStorage.getItem("Flag");
  if(getFlag === "isLogin"){
    store.state.isLogin = true
    next()
  }else{
    if(to.meta.isLogin){
      ElementUI.Message({
        message: '请先登录!',
        type: 'warning',
        center: true
      })
      next({
        path: '/login',
      })
    }else{
      next()
    }
  }
});

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
