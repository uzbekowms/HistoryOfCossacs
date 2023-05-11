<template>
  <div class="form__wrapper">
    <form class="form__container">
      <h1 v-if="props.title" class="form__title">{{ props.title }}</h1>
      <slot></slot>
    </form>
  </div>
</template>

<script setup>
import { defineProps } from "vue";
let props = defineProps({
  title: String,
});
</script>

<style>
.form__wrapper {
  display: grid;
  place-items: center;
  width: 100%;
  height: 100%;
}

.form__container {
  display: flex;
  flex-direction: column;
  background-color: #130e0e;
  padding: 2rem 3rem;
  gap: 1.5rem;
}

.form__title {
  font-family: "Inter";
  font-size: 1.8rem;
  font-weight: 600;
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

.link {
  font-family: "Inter";
}

a {
  font-family: inherit;
  font-weight: 600;
  color: white;
  transition: color ease 0.2s;
}

a:hover {
  color: var(--accent-color);
}
</style>
