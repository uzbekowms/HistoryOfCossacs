<template>
  <h1 class="profile__title">Козаче, {{ user?.nickname }}, гарного дня!</h1>
  <router-link class="profile__favorites_link" :to="{ name: 'Favorites' }"
    >Перейти до вподобаного</router-link
  >
  <div class="profile__container">
    <div class="profile__row_container">
      <label for="nickname">Зміна нікнейму</label>
      <input name="nickname" type="text" v-model="user.nickname" />
    </div>
    <div class="profile__row_container">
      <label for="nickname">Пошта</label>
      <input name="email" type="text" v-model="user.email" />
    </div>
    <div class="profile__row_container">
      <label for="nickname">Новий пароль</label>
      <input name="password" type="text" v-model="user.password" />
    </div>
    <button @click="updateUser(user)" class="profile__save_edits">
      Зберегти зміни
    </button>
  </div>
</template>

<script setup>
import profileApi from "@/utills/profile";
import { onMounted } from "vue";
const { updateUser, getUserByID, user } = profileApi();
onMounted(() => {
  getUserByID();
});
</script>

<style scoped>
.profile__favorites_link {
  font-size: 1rem;
  margin-top: 2rem;
  margin-bottom: 2rem;
}
.profile__title {
  font-size: 3rem;
  padding-top: 2rem;
  padding-bottom: 2rem;
}
.profile__container {
  padding-top: 2rem;
  font-size: 1.5rem;
  text-align: start;
  width: 33%;
  gap: 5px;
  margin: auto;
  display: flex;
  flex-direction: column;
}
.profile__container input {
  padding: 10px;
  border-radius: 10px;
}

.profile__container input:focus {
  outline: none;
}

.profile__row_container {
  display: flex;
  flex-direction: column;
  margin-bottom: 1rem;
}

.profile__save_edits {
  cursor: pointer;
  padding: 20px;
  color: white;
  font-weight: bold;
  font-size: 1rem;
  border-radius: 10px;
  background-color: var(--accent-color);
  border: none;
  transition: all 0.3s;
}
.profile__save_edits:hover {
  transition: all 0.3s;
  background-color: #497c12;
}
</style>
