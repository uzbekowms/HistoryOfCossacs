<template>
  <FormSkeleton title="Авторизація">
    <TheInput title="Логін" id="login" v-model="login" />
    <TheInput title="Пароль" id="password" v-model="password" />
    <button class="btn">Увійти</button>
  </FormSkeleton>
</template>

<script setup>
import { ref } from "vue";
import FormSkeleton from "./FormSkeleton.vue";
import TheInput from "@/components/TheInput.vue";

let login = ref("");
let password = ref("");
</script>

<style></style>
