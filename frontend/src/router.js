import { createWebHistory, createRouter } from "vue-router";
import MainPage from '@/views/MainPage.vue'
import LoginPage from '@/views/LoginPage.vue'

const routes = [
  {
    path: '/',
    component: MainPage
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
