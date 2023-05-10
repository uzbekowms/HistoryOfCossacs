import { createWebHistory, createRouter } from "vue-router";
import MainPage from '@/views/MainPage.vue'
import SignupPage from '@/views/SignupPage.vue'
import LoginPage from '@/views/LoginPage.vue'

const routes = [
  {
    path: '/',
    component: MainPage
  },
  {
    path: '/signup',
    component: SignupPage,
    meta: {
      hideHeader: true
    }
  },
  {
    path: '/login',
    component: LoginPage,
    meta: {
      hideHeader: true
    }
  }
];



const router = createRouter({
  history: createWebHistory(),
  routes,
});



export default router
