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
    <p class="error_message">{{ errorMessage }}</p>
    <button @click="tryToWriteFeedback" class="report__send">Надіслати</button>
  </div>
</template>

<script setup>
import { defineEmits, ref, onMounted, reactive } from "vue";
import feedbackApi from "@/utills/feedbacks";

import profileApi from "@/utills/profile";
const { user, getUserByID } = profileApi();

const { writeFeedback } = feedbackApi();

const emit = defineEmits(["closeModal"]);
const errorMessage = ref("");

const tryToWriteFeedback = async () => {
  if (form.message.length < 10) {
    errorMessage.value = "Мінімальна кількість символів 10!";
  } else {
    errorMessage.value = "";
    writeFeedback(form);
  }
};

const form = reactive({
  userId: null,
  message: "",
});

onMounted(async () => {
  form.userId = await user.id;
  await getUserByID();
  form.userId = await localStorage.getItem("userId");
});
</script>

<style scoped>
.error_message {
  color: rgb(236, 98, 98);
}
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
