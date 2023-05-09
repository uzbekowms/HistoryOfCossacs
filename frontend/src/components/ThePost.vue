<template>
  <div class="card_wrapper">
    <div class="post_card">
      <img
        src="../assets/testimages/test1.png"
        alt="Post Image"
        class="post_card__img"
      />
      <div class="post_card__text-wrapper">
        <h2 class="post_card__title">Козаки придністров'я</h2>
        <p class="post_card__description">
          На загал, козаки були місцевим населенням, організованим для захисту
          південних кордонів від нападів військ Османської імперії та її васалів
          князями, які на той час володіли землями по Дніпро. С. Плохій на
          початковому етапі формування відзначав значний відсоток білорусів[3].
          Ряд істориків визначали за пращурів козацтва бродників, берладників,
          та болохівців[11]. Першими козацькими гетьманами літописці та пізніші
          історики називають черкаського та канівського старосту — Остафія
          Дашкевича і хмільницького старосту — Прецлава Лянцкоронського. Також
          згадується Юрій Пац[12].
        </p>
      </div>
    </div>
    <div class="date_separator">
      <div class="vertical_line"></div>
      <span class="date">1970</span>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.post_card {
  position: relative;
  /*border: var(--accent-color) solid 1px;*/
  width: 320px;
  height: 320px;
  cursor: pointer;
  z-index: 2;
  transition: all 0.4s ease;

  scroll-snap-align: center;
  scroll-snap-stop: always; /* code added */
}

.post_card__text-wrapper {
  position: absolute;
  display: flex;
  flex-direction: column;
  gap: 0.4em;
  bottom: 0.8rem;
  left: 0.8rem;
  right: 0.8rem;
  text-align: left;
  transform: translateY(1.5em);
  opacity: 0;
  transition: all 0.4s ease;
  max-height: 40%;
  overflow: hidden;
}

.post_card__title {
  font-size: 1.6rem;
  font-weight: 600;
}

.post_card__description {
  text-overflow: ellipsis;
}

.date_separator {
  display: flex;
  flex-direction: column;
  position: relative;
  align-items: center;
}

.date_separator .vertical_line {
  position: absolute;
  width: 1px;
  height: 20vh;
  background-color: #fff;
  opacity: 0.1;
  z-index: 1;
}

.date_separator .date {
  position: absolute;
  top: 21vh;
  font-size: 1.6rem;
  font-weight: 400;
  color: #999999;
}

.card_wrapper {
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  transform: translateY(-10vh);
}

.post_card__img {
  object-fit: cover;
  height: 100%;
  aspect-ratio: 1 / 1;
  filter: grayscale(1) brightness(0.4);
}

.post_card:hover {
  transform: scale(1.2);
}

.post_card:hover .post_card__text-wrapper {
  transform: translateY(0);
  opacity: 1;
}
</style>
