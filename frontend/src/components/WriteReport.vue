<template>
  <div class="report__container">
    <button class="post__close-btn" @click="emit('closeModal')"></button>
    <h1>Напишіть відгук якщо знайшли помилку</h1>
    <p>
      Детально опишіть знайдену помилку або звертання до адміністратора<br />
      (інформація про обраний пост надсилається автоматично)
    </p>
    <textarea
      v-model="form.message"
      type="text"
      placeholder="Текст звертання"
    ></textarea>
    <button class="report__send">Надіслати</button>
  </div>
</template>

<script setup>
import { defineEmits, reactive } from "vue";
const emit = defineEmits(["closeModal"]);

const form = reactive({
  user_id: 3,
  message: "",
  dateOfFeedback: new Date(),
});
</script>

<style scoped>
textarea {
  padding: 5px;
  height: 200px;
  width: 100%;
}
.report__send {
  cursor: pointer;
  padding: 20px;
  color: white;
  font-weight: bold;
  font-size: 1rem;
  border-radius: 10px;
  background-color: #549114;
  border: none;
  transition: all 0.3s;
}
.report__send:hover {
  transition: all 0.3s;
  background-color: #2d4e0a;
}
.report__container {
  backdrop-filter: blur(10px);
  border-radius: 20px;
  background-color: #38353575;
  padding: 80px;
  display: flex;
  flex-direction: column;
  gap: 20px;
  width: fit-content;
  height: fit-content;
  position: relative;
  overflow: auto;
}
.post__close-btn {
  position: absolute;
  top: 0rem;
  right: 0rem;
  border: none;
}

.post__close-btn::after {
  position: absolute;
  font-size: 4rem;
  right: 0;
  top: 0;
  content: "\00d7";
  color: var(--accent-color);
  padding: 0 1rem;
  transition: all ease 0.2s;
  cursor: pointer;
}

.post__close-btn:hover::after {
  background-color: rgba(0, 0, 0, 0.2);
  color: #fff;
}
</style>
