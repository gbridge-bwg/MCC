import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from './Login.vue'
import Register from './Register.vue'
import Benefit from './Benefit.vue'
import VueSession from 'vue-session'



// 뷰 어플리케이션에 라우터 플러그인을 추가한다.
Vue.use(VueRouter)
Vue.use(VueSession)

const Home = { template: '<div>Home</div>'}
const NotFound = { template: '<div>Not Found</div>'}

const router = new VueRouter({
    mode: 'history',
    routes: [
      { path: '/', component: Login },
      { path: '/admin/register', component: Register },
      { path: '*', component: NotFound },
      { path: '/benefit', component: Benefit }
    ]
  })
  
  export default router