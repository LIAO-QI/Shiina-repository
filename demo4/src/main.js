import Vue from 'vue'
import App from './App.vue'
import Axios from 'axios'
import router from './router.js'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(ElementUI)

Vue.config.productionTip = false
Vue.prototype.Axios = Axios

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
