<template>
  <div class="input__container">
    <select
      v-if="type === 'select'"
      name=""
      :id="id"
      class="input__input-field"
      v-model="selectedValue"
      @change="$emit('update:modelValue', selectedValue)"
    >
      <option value="" disabled selected></option>
      <option
        v-for="optionItem in options"
        :key="optionItem"
        :value="optionItem"
      >
        {{ optionItem }}
      </option>
    </select>
    <input
      v-else
      :required="type !== 'date'"
      autocomplete="off"
      :type="props.type"
      :id="props.id"
      class="input__input-field"
      :value="modelValue"
      @input="(event) => $emit('update:modelValue', event.target.value)"
      :accept="props.accept"
      capture
      lang="uk"
      :max="new Date()"
    />
    <label v-if="props.title" :for="props.id" class="input__title">{{
      props.title
    }}</label>
  </div>
</template>

<script setup>
import { defineProps, ref } from "vue";

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
    type: [String, Number, null],
  },
  type: {
    type: String,
    default: "text",
  },
  options: {
    type: Array,
  },
  accept: {
    type: String,
    default: "",
  },
});

const selectedValue = ref(props.modelValue);
</script>

<style>
.input__container {
  position: relative;
  font-family: "Inter";
  width: 20rem;
  text-align: center;
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

.datepicker .dp__input_icon {
  left: auto;
  right: 1rem;
}
.datepicker input {
  color: white;
  background-color: transparent;
  border: none;
  border-bottom: 1px #888888 solid;
  border-radius: 0;
}

::-webkit-calendar-picker-indicator {
  filter: invert(1);
}
input[type="date"]:not(:valid)::-webkit-datetime-edit-text,
input[type="date"]:not(:valid)::-webkit-datetime-edit-year-field,
input[type="date"]:not(:valid)::-webkit-datetime-edit-month-field,
input[type="date"]:not(:valid)::-webkit-datetime-edit-day-field {
  color: transparent;
}

input[type="file"] {
  display: none;
}

input[type="file"] ~ .input__title {
  position: initial;
  border: white solid 2px;
  color: white;
  font-weight: 600;
  text-align: center;
  vertical-align: middle;
  padding: 0.5rem 1rem;
  cursor: pointer;
  transition: all ease 0.2s;
}

input[type="file"] ~ .input__title::after {
  content: url("@/assets/ico/upload.svg");
  margin-left: 0.2rem;
  transform: translateY(10px);
  width: 1rem;
  height: 1rem;
}

input[type="file"]:hover ~ .input__title {
  border: none;
  background-color: var(--accent-color);
}
</style>
