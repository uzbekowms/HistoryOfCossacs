<template>
  <form class="container form">
    <h2 class="add-post__title">Додати пост</h2>
    <fieldset class="add-post__inputs">
      <TheInput title="Фото поста" id="post_img" />
      <TheInput title="Заголовок поста" id="post_title" />
      <TheInput title="Дата початку" id="post_date-start" type="date" />
      <TheInput title="Дата кінця" id="post_date-end" type="date" />
    </fieldset>
    <h3 class="add-post__title">Текст поста</h3>
    <textarea
      name=""
      id=""
      cols="30"
      rows="10"
      class="add-post__description"
    ></textarea>
    <div class="add-post__container">
      <button class="add-post__btn secondary-btn">Відмінити</button>
      <button class="add-post__btn primary-btn">Додати</button>
    </div>
  </form>
</template>

<script setup>
import TheInput from "@/components/TheInput.vue";
</script>

<style scoped>
.form {
  background-color: #1a1515;
  width: 100%;
  padding: 2rem;
  display: flex;
  flex-direction: column;
  gap: 1rem;
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
</style>
