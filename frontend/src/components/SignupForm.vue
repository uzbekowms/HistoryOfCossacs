<template>
  <form class="form__container">
    <h1 class="form__title">Реєстрація</h1>
    <TheInput id="nickname" v-model="nickname" title="Логін" />
    <TheInput id="email" v-model="email" title="Електронна адреса" />
    <TheInput id="password" v-model="password" title="Пароль" />
    <TheInput
      id="passwordConfirmation"
      v-model="passwordConfirmation"
      title="Повторіть пароль"
    />
    <button class="btn">Зареєструватись</button>
  </form>
</template>

<script setup>
import { ref } from "vue";
import TheInput from "@/components/TheInput.vue";

let nickname = ref("");
let email = ref("");
let password = ref("");
let passwordConfirmation = ref("");
</script>

<style scoped>
.form__title {
  font-family: "Inter";
  font-size: 1.8rem;
  font-weight: 600;
}

.form__container {
  display: flex;
  flex-direction: column;
  background-color: #130e0e;
  padding: 2rem 3rem;
  gap: 1.5rem;
}

.btn {
  font-size: 1rem;
  font-weight: 600;
  cursor: pointer;
  padding: 0.6em 0.4em;
  background-color: transparent;
  border: 2px white solid;
  color: white;
  transition: all ease 0.2s;
}

.btn:hover {
  background-color: var(--accent-color);
  border-color: var(--accent-color);
}
</style>
