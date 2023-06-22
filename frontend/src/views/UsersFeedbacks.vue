<template>
  <div class="back_link">
    <router-link class="" :to="{ name: 'Admin' }"
      >Повернутись в адміністративну панель</router-link
    >
  </div>
  <div class="feedback__container">
    <div class="feedback">
      <p>Користувач</p>
      <p>Повідомлення</p>
      <p>Дата звертання</p>
    </div>
    <div v-for="feedback in feedbacks" class="feedback" :key="feedback.id">
      <div>
        {{ feedback.user.nickname }}
        {{ feedback.user.email }}
        {{ feedback.user.role }}
      </div>
      <div>{{ feedback.message }}</div>
      <div>{{ feedback.dateOfFeedback }}</div>
    </div>
  </div>
</template>

<script setup>
import feedbackApi from "@/utills/feedbacks";
import { onMounted } from "vue";
const { getFeedbacks, feedbacks } = feedbackApi();
onMounted(async () => {
  await getFeedbacks();
});
</script>

<style scoped>
.back_link {
  padding: 20px;
  margin: 20px;
}
.feedback {
  gap: 20px;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
}
</style>
