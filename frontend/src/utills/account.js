import { reactive } from "vue";

let currentUser = reactive();

const isLogged = () => {
  return localStorage.getItem("userId");
};

const writeUser = (user) => {
  currentUser = user;
  localStorage.setItem("userId", user.id);
};

const clearUser = () => {
  currentUser = null;
  localStorage.clear();
};

export { isLogged, writeUser, clearUser, currentUser };
