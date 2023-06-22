<template>
  <FormSkeleton title="Реєстрація">
    <TheInput id="nickname" v-model="user.nickname" title="Логін" />
    <TheInput id="email" v-model="user.email" title="Електронна адреса" />
    <TheInput id="password" v-model="user.password" title="Пароль" />
    <TheInput
      id="passwordConfirmation"
      v-model="user.passwordConfirmation"
      title="Повторіть пароль"
    />
    <span class="errors" v-for="error in errors" :key="error">{{ error }}</span>
    <button class="btn" @click.prevent="signUp">Зареєструватись</button>
    <span class="link"
      >Вже маєте акаунт? <router-link to="/login">Увійти</router-link></span
    >
  </FormSkeleton>
</template>

<script setup>
import { reactive, ref, watch } from "vue";
import { useRouter } from "vue-router";
import FormSkeleton from "@/views/FormSkeleton.vue";
import TheInput from "@/components/TheInput.vue";
import { signup } from "@/utills/api";
import { writeUser } from "@/utills/account.js";

const router = useRouter();

let user = reactive({
  nickname: "",
  email: "",
  password: "",
  passwordConfirmation: "",
});
let errors = ref([]);

const signUp = async () => {
  if (errors.value.length) return;

  await signup(user)
    .then((response) => {
      writeUser(response);
      router.push("/");
    })
    .catch((err) => {
      errors.value.push(...err.response?.data);
    });
};

watch(user, () => {
  errors.value = [];
  if (!user.nickname.trim()) errors.value.push("Нік не може бути порожнім");

  if (!user.email.trim())
    errors.value.push("Електрона адреса не може бути порожньою");

  if (!user.password.trim()) errors.value.push("Пароль не може бути порожнім");

  if (user.password.trim() !== user.passwordConfirmation.trim())
    errors.value.push("Паролі не співпадають");

  if (
    !user.email
      .toLowerCase()
      .match(
        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
      )
  )
    errors.value.push("Електрона адреса не коректна");
});
</script>

<style scoped>
.errors {
  color: red;
  font-size: 0.9rem;
  font-family: "Inter";
}
</style>
