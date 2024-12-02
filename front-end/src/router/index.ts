import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';
import Home from '@/views/Home.vue'
import MyAccount from '@/views/MyAccount.vue';

const routes: Array<RouteRecordRaw> = [
  { path: '/', component: Home, name: 'home' },
  { path: '/account', component: MyAccount, name: 'account' }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach(async (to, from, next) => { 
  next();
})

export default router
