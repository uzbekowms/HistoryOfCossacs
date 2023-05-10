import { createWebHistory, createRouter } from "vue-router";
import MainPage from '@/views/MainPage.vue'
import SignupPage from '@/views/SignupPage.vue'

const routes = [
  {
    path: '/',
    component: MainPage
  },
  {
    path: '/login',
    component: SignupPage,
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
