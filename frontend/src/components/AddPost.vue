<template>
  <div class="form-container container">
    <form class="form">
      <h2 class="add-post__title">Додати пост</h2>
      <audio
        controls
        v-show="filePreview"
        :src="filePreview"
        v-if="newPost.post.postType.name === 'Аудіоматеріали'"
        class="add-post__audio"
      ></audio>
      <video
        controls
        :src="filePreview"
        v-else-if="newPost.post.postType.name === 'Відеоматеріали'"
        v-show="filePreview"
      ></video>
      <img
        v-else
        :src="
          'http://localhost:8000/api/v1/files/' + newPost?.post.previewImagePath
        "
        v-show="newPost?.post.previewImagePath"
        alt="Post img"
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
          v-model="newPost.post.title"
        />
        <TheInput
          title="Тип поста"
          id="post_type"
          v-model="newPost.post.postType.name"
          type="select"
          :options="postTypes"
        />
        <TheInput
          title="Дата початку"
          id="post_date-start"
          type="date"
          v-model="newPost.post.dateStart"
          v-show="!isFilePost"
        />
        <TheInput
          title="Дата кінця"
          id="post_date-end"
          type="date"
          v-model="newPost.post.dateEnd"
          v-show="!isFilePost"
        />
      </fieldset>

      <h3 class="add-post__title" v-show="!isFilePost">Текст поста</h3>
      <textarea
        v-model="newPost.post.description"
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
    <ModalWindow v-show="modalIsVisible">
      <div class="popup">
        <h3 class="popup__text">{{ modalText }}</h3>
        <button
          @click="modalIsVisible = false"
          class="add-post__btn primary-btn"
        >
          Закрити
        </button>
      </div>
    </ModalWindow>
  </div>
</template>

<script setup>
import { ref, watch, onMounted, defineProps, reactive } from "vue";
import ModalWindow from "./ModalWindow.vue";
import TheInput from "@/components/TheInput.vue";
import { savePost, getPostTypes, saveFile } from "@/utills/api.js";

const props = defineProps({
  post: Object,
});

let newPost = reactive(props);

let errors = ref([]);
let postTypes = ref([]);
let isFilePost = ref(true);
let fileType = ref("");
let modalIsVisible = ref(false);
let modalText = ref("");
let filePreview = ref();

let fileTypes = {
  Відеоматеріали: "video/*",
  Аудіоматеріали: "audio/*",
};

onMounted(() => {
  getPostTypes().then((response) => (postTypes.value = response));
});

watch(newPost, () => {
  console.log(newPost.post.postType);
  isFilePost =
    newPost.post.postType.name === "Аудіоматеріали" ||
    newPost.post.postType.name === "Відеоматеріали" ||
    newPost.post.postType.name === "Галерея";
  fileType = fileTypes[newPost.post.postType.name] || "image/*";
  errors.value = [];

  if (!newPost.post.title?.trim())
    errors.value.push("Заголовок не може бути порожнім");

  if (!(newPost.post.previewImagePath || newPost.post.postFile))
    errors.value.push("Файл не може бути порожнім");

  if (!isFilePost.value) return;

  if (newPost?.value.dateStart > newPost.post.dateEnd)
    errors.value.push("Дата початку не може бути після дати кінця");

  if (
    new Date(newPost.post.dateEnd) > new Date() ||
    new Date(newPost.post.dateStart) > new Date()
  )
    errors.value.push("Не можна ставити майбутню дату");

  if (!newPost.value.description?.trim())
    errors.value.push("Стаття не може бути порожньою");
});

const handleImageChange = async (event) => {
  newPost.post.postFile = event.target.files[0];
  newPost.post.pathToFile = await saveFile(newPost.post.postFile);
  if (newPost.post.postFile) {
    const reader = new FileReader();
    reader.onload = () => {
      filePreview.value = reader.result;
    };
    reader.readAsDataURL(newPost.post.postFile);
  }
};

const save = () => {
  if (errors.value.length) {
    return;
  }
  newPost.post.postType = newPost.post.postType.name;
  if (
    savePost(newPost.post).catch((err) => {
      modalText.value = err;
    })
  ) {
    modalIsVisible.value = true;
    modalText.value = "Пост був успішно збережений!";
  }
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
.add-post__audio {
  width: 100%;
  margin: 0 auto;
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

.popup {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  padding: 2rem;
  background-color: #1a1515;
}

.popup__text {
  font-size: 1.5rem;
}
</style>
