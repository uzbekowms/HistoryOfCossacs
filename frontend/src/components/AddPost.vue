<template>
  <div class="form-container container">
    <form class="form">
      <h2 class="add-post__title">Додати пост</h2>
      <img
        src="http://localhost:8000/api/v1/files/images/aa604ece-6a68-47e9-a6db-21bcaea6fbd6.jpg"
      />
      <audio
        :src="post.postImage"
        v-if="post.postType === 'Аудіоматеріали'"
      ></audio>
      <video
        :src="postImage"
        v-else-if="post.postType === 'Відеоматеріали'"
        v-show="post.postImage"
      ></video>
      <img
        v-else
        :src="post.postImage"
        alt="Post img"
        v-show="post.postImage"
        class="add-post__image"
      />
      <fieldset class="add-post__inputs">
        <div class="post__img">
          <TheInput
            title="Файл поста"
            id="post_img"
            type="file"
            @change="handleImageChange"
            v-bind:accept="fileType"
          />
        </div>
        <TheInput
          title="Заголовок поста"
          id="post_title"
          v-model="post.title"
        />
        <TheInput
          title="Тип поста"
          id="post_type"
          v-model="post.postType"
          type="select"
          :options="postTypes"
        />
        <TheInput
          title="Дата початку"
          id="post_date-start"
          type="date"
          v-model="post.dateStart"
          v-show="!isFilePost"
        />
        <TheInput
          title="Дата кінця"
          id="post_date-end"
          type="date"
          v-model="post.dateEnd"
          v-show="!isFilePost"
        />
      </fieldset>

      <h3 class="add-post__title" v-show="!isFilePost">Текст поста</h3>
      <textarea
        v-model="post.description"
        name=""
        id=""
        cols="30"
        rows="10"
        class="add-post__description"
        v-show="!isFilePost"
      ></textarea>

      <ul class="errors">
        <li v-for="error in errors" :key="error">{{ error }}</li>
      </ul>
      <div class="add-post__container">
        <button
          class="add-post__btn secondary-btn"
          @click.prevent="$emit('closeModal')"
        >
          Відмінити
        </button>
        <button class="add-post__btn primary-btn" @click.prevent="save">
          Додати
        </button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref, watch, reactive, onMounted } from "vue";
import TheInput from "@/components/TheInput.vue";
import { savePost, getPostTypes } from "@/utills/api.js";

let post = reactive({
  postImage: ref(),
  title: ref(""),
  dateStart: ref(null),
  dateEnd: ref(null),
  description: ref(""),
  postType: ref(),
});

let errors = ref([]);
let postTypes = ref([]);
let isFilePost = ref(true);
let fileType = ref("");

let fileTypes = {
  Відеоматеріали: "video/*",
  Аудіоматеріали: "audio/*",
};

onMounted(() => {
  getPostTypes().then((response) => (postTypes.value = response));
});

watch(post, () => {
  isFilePost.value =
    post.postType === "Аудіоматеріали" ||
    post.postType === "Відеоматеріали" ||
    post.postType === "Галерея";
  console.log(isFilePost);
  fileType.value = fileTypes[post.postType] || "image/*";
  errors.value = [];

  if (post.title.trim() === "")
    errors.value.push("Заголовок не може бути порожнім");

  if (post.postImage === undefined)
    errors.value.push("Файл не може бути порожнім");

  if (isFilePost.value) return;

  if (post.dateStart > post.dateEnd)
    errors.value.push("Дата початку не може бути після дати кінця");

  if (
    new Date(post.dateEnd) > new Date() ||
    new Date(post.dateStart) > new Date()
  )
    errors.value.push("Не можна ставити майбутню дату");

  if (post.description.trim() === "")
    errors.value.push("Стаття не може бути порожньою");
});

const handleImageChange = (event) => {
  const file = event.target.files[0];
  if (file) {
    const reader = new FileReader();
    reader.onload = () => {
      post.postImage = reader.result;
    };
    reader.readAsDataURL(file);
  }
};

const save = () => {
  if (errors.value.length) {
    console.log("err");
    return;
  }
  savePost(post);
};
</script>

<style scoped>
.form {
  background-color: #1a1515;
  padding: 2rem;
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.form-container {
  height: 80vh;
  overflow: auto;
  width: 100%;
}
.add-post__title {
  font-size: 2rem;
  font-weight: 600;
}
.add-post__inputs {
  margin-top: 1rem;
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
}

.add-post__inputs .input__container {
  flex-grow: 1;
  width: max-content;
}

.add-post__description {
  width: 100%;
  height: 30rem;
  resize: none;
  outline: none;
}

.add-post__btn {
  font-size: 1rem;
  padding: 0.5rem 1rem;
  cursor: pointer;
  font-weight: 600;
  transition: all ease 0.2s;
}

.add-post__btn:hover {
  outline: none;
  background-color: var(--accent-color);
  color: white;
}

.primary-btn {
  background-color: white;
  color: #1a1515;
}

.secondary-btn {
  background-color: transparent;
  outline: white 2px solid;
  color: white;
}

.add-post__container {
  display: flex;
  justify-content: end;
  gap: 1rem;
  flex-wrap: wrap;
}

input[type="date"]:focus::before,
input[type="date"]:valid::before {
  content: "";
}

.add-post__image {
  width: 50%;
  margin: 0 auto;
}

.errors {
  color: var(--error-color);
}

.post__img {
  width: 100%;
  display: grid;
  place-items: center;
  padding: 2rem 0;
}

video {
  width: 50%;
  margin: 0 auto;
}
</style>
