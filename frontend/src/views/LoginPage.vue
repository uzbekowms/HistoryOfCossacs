<template>
  <FormSkeleton title="Авторизація">
    <TheInput title="Електрона адреса" id="login" v-model="user.email" />
    <TheInput title="Пароль" id="password" v-model="user.password" />
    <span class="error" v-for="error in errors" :key="error">{{ error }}</span>
    <button class="btn" @click.prevent="loginDecorator">Увійти</button>
    <span class="link"
      >Не маєте акаунт?
      <router-link to="/signup">Зареєструватись</router-link></span
    >
  </FormSkeleton>
</template>

<script setup>
import { reactive, ref, watch } from "vue";
import { useRouter } from "vue-router";
import FormSkeleton from "./FormSkeleton.vue";
import TheInput from "@/components/TheInput.vue";
import { login } from "@/utills/api";
import { writeUser } from "@/utills/account.js";

const router = useRouter();

let user = reactive({
  email: "",
  password: "",
});

let errors = ref([]);

const loginDecorator = async () => {
  if (errors.value.length) return;

  await login(user).then((response) => {
    writeUser(response);
    router.push("/");
  });
};

watch(user, () => {
  errors.value = [];

  if (!user.email.trim())
    errors.value.push("Електрона адреса не може бути порожньою");

  if (
    !user.email
      .toLowerCase()
      .match(
        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
      )
  )
    errors.value.push("Електрона адреса не коректна");

  if (!user.password.trim()) errors.value.push("Пароль не може бути порожнім");
});
</script>

<style scoped>
.error {
  font-size: 0.8rem;
  color: red;
  font-family: "Inter";
}
</style>
