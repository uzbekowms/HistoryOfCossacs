<template>
  <div class="container">
    <div class="post__container">
      <video
        controls
        class="post__vid"
        :src="
          'http://localhost:8000/api/v1/files/' + props.post.previewImagePath
        "
        v-if="post.postType.name === 'Відеоматеріали'"
      ></video
      ><audio
        class="post__audio"
        v-else-if="post.postType.name === 'Аудіоматеріали'"
        controls
        :src="
          'http://localhost:8000/api/v1/files/' + props.post.previewImagePath
        "
        alt=""
        srcset=""
      ></audio>
      <img
        v-else
        :src="
          'http://localhost:8000/api/v1/files/' + props.post?.previewImagePath
        "
        alt="Post Image"
        class="post__img"
      />
      <button class="post__close-btn" @click="emit('closeModal')"></button>
      <div class="post__body">
        <h2 class="post__title">
          {{ props.post?.title }}
          <span
            class="post__dates"
            v-show="props.post?.dateStart || props.post?.dateEnd"
          >
            ({{ formatDate(props.post?.dateStart) }} —
            {{ formatDate(props.post?.dateEnd) }})</span
          >
        </h2>
        <p class="post__type">{{ props.post.postType.name }}</p>
        <p class="post__description">
          {{ props.post?.description }}
        </p>
        <div class="post__comments">
          <input v-model="comment" class="" type="text" />
          <button @click="sendComment(props.post.id)">Надіслати</button>
        </div>
      </div>

      <div @click="writeReportModal" class="post__report">
        <img class="" src="../assets/ico/report.png" alt="" />
        <p>Знайшли помилку?</p>
      </div>

      <div>
        <p v-for="comment in props.post.comments" :key="comment.id">
          {{ comment }}
        </p>
      </div>
    </div>

    <ModalWindow v-show="modalIsVisible">
      <WriteReport @close-modal="closeModal"></WriteReport>
    </ModalWindow>
  </div>
</template>

<script setup>
import ModalWindow from "@/components/ModalWindow.vue";
import WriteReport from "@/components/WriteReport.vue";

import commentsApi from "@/utills/comments.js";
import { isLogged } from "@/utills/account";

import { defineProps, defineEmits, ref, reactive, onMounted } from "vue";

import { formatDate } from "@/utills/formatter";

const { writeComment } = commentsApi();

let modalIsVisible = ref(false);

function writeReportModal() {
  modalIsVisible.value = true;
}
function closeModal() {
  modalIsVisible.value = false;
}
const props = defineProps({
  post: Object,
});

const user = ref([]);

onMounted(async () => {
  user.value = await isLogged();
  user.value = JSON.parse(user.value);
});

const sendComment = async (postId) => {
  const form = reactive({
    postId: postId,
    ownerId: user.value.id,
    comment: comment.value,
  });
  console.log(form);
  writeComment(form);
};

const emit = defineEmits(["closeModal"]);

const comment = ref("");
</script>

<style scoped>
.container {
  width: 100%;
  height: 90vh;
  overflow: auto;
}
.post__comments input {
  font-size: 20px;
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 10px 0px 0px 10px;
}
.post__comments input:focus {
  outline: none;
}
.post__comments {
  display: flex;
  height: 4rem;
  flex-direction: row;
  transition: all 0.3s;
}
.post__comments button {
  display: flex;
  align-items: center;
  padding: 10px;
  cursor: pointer;
  font-size: 1rem;
  border-radius: 0px 10px 10px 0px;
  flex-direction: row;
  background-color: #14a014;
  color: white;
  transition: all 0.3s;
  border: none;
}
.post__comments button:hover {
  transition: all 0.3s;
  background-color: #0f7e0f;
}
.post__report {
  cursor: pointer;
  position: absolute;
  display: flex;
  flex-direction: row;
  align-items: center;
  backdrop-filter: blur(20px);
  margin: 10px;
  padding: 5px;
  border-radius: 10px;
  left: 0;
  transition: 0.3s;
  top: 0;
}
.post__report:hover {
  transition: 0.3s;
  backdrop-filter: blur(30px);
}

.post__report img {
  width: 3rem;
}
.post__container {
  position: relative;
  width: 100%;
  background-color: #1a1515;
  overflow: auto;
}
.post__vid {
  width: 100%;
  margin: 0 auto;
}
.post__img,
.post__vid {
  width: 100%;
  height: 40vh;
  object-fit: cover;
}
.post__body {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  text-align: left;
  padding: 1.5rem;
}

.post__title {
  font-size: 2.5rem;
  font-weight: 600;
}

.post__dates {
  font-size: 0.8em;
  font-weight: 400;
}

.post__description {
  line-height: 1.4rem;
}

.post__type {
  line-height: 1.4rem;
  background-color: #332f2f;
  width: fit-content;
  padding: 10px;
  border-radius: 10px;
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
