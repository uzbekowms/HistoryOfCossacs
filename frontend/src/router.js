import { createWebHistory, createRouter } from "vue-router";
import MainPage from "@/views/MainPage.vue";
import SignupPage from "@/views/SignupPage.vue";
import LoginPage from "@/views/LoginPage.vue";
import AdminPanel from "@/views/AdminPanel.vue";
import ErrorPage from "@/views/ErrorPage.vue";
import ProfilePage from "@/views/ProfilePage.vue";
import FavoritesPostsPage from "@/views/FavoritesPostsPage.vue";
import UsersFeedbacks from "@/views/UsersFeedbacks.vue";

const routes = [
  {
    path: "/",
    component: MainPage,
    name: "HomePage",
  },
  {
    path: "/admin/users_feedbacks",
    component: UsersFeedbacks,
    name: "UsersFeedbacks",
  },
  {
    path: "/profile",
    component: ProfilePage,
    name: "Profile",
  },
  {
    path: "/favorites",
    component: FavoritesPostsPage,
    name: "Favorites",
  },
  {
    path: "/:type?/:type_key?",
    name: "PostsByType",
    component: MainPage,
    props: true,
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
    name: "Login",
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
    name: "Admin",
    component: AdminPanel,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
