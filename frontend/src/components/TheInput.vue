<template>
  <div class="input__container">
    <input
      required
      autocomplete="off"
      :type="props.type"
      :id="props.id"
      class="input__input-field"
      :value="modelValue"
      @input="(event) => $emit('update:modelValue', event.target.value)"
    />
    <label v-if="props.title" :for="props.id" class="input__title">{{
      props.title
    }}</label>
  </div>
</template>

<script setup>
import { defineProps } from "vue";

const props = defineProps({
  id: {
    required: true,
    type: String,
  },
  title: {
    required: true,
    type: String,
  },
  modelValue: {
    required: true,
    type: [String, Number],
  },
  type: {
    type: String,
    default: "text",
  },
});
</script>

<style scoped>
.input__container {
  position: relative;
  font-family: "Inter";
  width: 20rem;
}

.input__title {
  position: absolute;
  top: 0.6em;
  left: 0.6em;
  font-size: 1em;
  color: #888888;
  cursor: text;
  transition: all ease 0.2s;
}

.input__input-field {
  width: 100%;
  background-color: transparent;
  font-size: 1rem;
  border: none;
  outline: none;
  color: white;
  border-bottom: 1px #888888 solid;
  padding: 0.6em;
  background-color: #1a1515;
  transition: all ease 0.2s;
}

.input__input-field:valid ~ .input__title,
.input__input-field:focus ~ .input__title {
  top: -0.6rem;
  font-size: 0.8rem;
}

.input__input-field:focus {
  border-bottom: 2px solid var(--accent-color);
}

.input__input-field:focus ~ .input__title {
  color: var(--accent-color);
}
</style>
