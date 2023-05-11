<template>
  <FormSkeleton title="Реєстрація">
    <TheInput id="nickname" v-model="nickname" title="Логін" />
    <TheInput id="email" v-model="email" title="Електронна адреса" />
    <TheInput id="password" v-model="password" title="Пароль" />
    <TheInput
      id="passwordConfirmation"
      v-model="passwordConfirmation"
      title="Повторіть пароль"
    />
    <button class="btn">Зареєструватись</button>
    <span class="link"
      >Вже маєте акаунт? <router-link to="/login">Увійти</router-link></span
    >
  </FormSkeleton>
</template>

<script setup>
import { ref } from "vue";
import FormSkeleton from "@/views/FormSkeleton.vue";
import TheInput from "@/components/TheInput.vue";

let nickname = ref("");
let email = ref("");
let password = ref("");
let passwordConfirmation = ref("");
</script>

<style scoped></style>
