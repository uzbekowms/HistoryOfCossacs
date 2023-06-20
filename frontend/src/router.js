import { createWebHistory, createRouter } from "vue-router";
import MainPage from "@/views/MainPage.vue";
import SignupPage from "@/views/SignupPage.vue";
import LoginPage from "@/views/LoginPage.vue";
import AdminPanel from "@/views/AdminPanel.vue";
import ErrorPage from "@/views/ErrorPage.vue";

const routes = [
  {
    path: "/",
    component: MainPage,
  },
  {
    path: "/signup",
    component: SignupPage,
    meta: {
      hideHeader: true,
    },
  },
  {
    path: "/login",
    component: LoginPage,
    meta: {
      hideHeader: true,
    },
  },
  {
    path: "/error",
    component: ErrorPage,
  },
  {
    path: "/admin",
    component: AdminPanel,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
