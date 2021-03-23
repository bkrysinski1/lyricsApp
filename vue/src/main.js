import Vue from 'vue'
import Vuex from 'vuex'
import App from './App.vue'
import store from './store/index'
import router from './router'

import axios from 'axios'
import lyrics from './data/lyrics'

Vue.config.productionTip = false
Vue.use(Vuex)

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;
console.log(store);
new Vue({
  router,
  store,
  render: h => h(App),
  mounted () {
    this.$store.commit('setUnanswered', lyrics)
    this.$store.dispatch('init')
  },
}).$mount('#app')

