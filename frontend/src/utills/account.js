import { reactive } from "vue";

let currentUser = reactive();

const isLogged = () => {
  return localStorage.getItem("user");
};

const writeUser = (user) => {
  currentUser = user;
  localStorage.setItem("user", JSON.stringify(user));
};

const clearUser = () => {
  currentUser = null;
  localStorage.clear();
};

export { isLogged, writeUser, clearUser, currentUser };
