<template>
  <div class="post-card__container">
    <img src="@/assets/testimages/test1.png" alt="Img" class="post-card__img" />
    <div class="post-card__text">
      <h3 class="post-card__title">Title</h3>
      <p class="post-card__description">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus
        dolores esse nesciunt! Modi accusamus, quod maxime, molestias aspernatur
        facere pariatur ab possimus excepturi assumenda veritatis nostrum at
        amet! Vero, obcaecati! Lorem ipsum dolor sit amet consectetur
        adipisicing elit. Porro voluptatibus natus inventore iure?
        Necessitatibus dolores magnam culpa dolorem odio. Totam optio odit
        molestiae deleniti ea pariatur labore et, animi porro. Lorem ipsum dolor
        sit amet consectetur adipisicing elit. Voluptates excepturi consequuntur
        ducimus ratione! Eaque accusantium beatae repellendus praesentium
        adipisci, debitis nostrum odit vitae vero aspernatur. At ab ducimus
        reiciendis cumque! Lorem ipsum dolor sit, amet consectetur adipisicing
        elit. Explicabo ab vitae ut deleniti impedit reprehenderit laboriosam
        esse! Impedit tenetur eveniet exercitationem autem ea, placeat, commodi
        iusto voluptates, velit aliquid deleniti! Lorem ipsum dolor sit amet
        consectetur adipisicing elit. Eum accusantium quia, dignissimos iste
        sapiente tenetur ea nemo delectus inventore fuga animi veritatis
        dolores, deleniti incidunt odio! Dignissimos dolorem suscipit
        consequuntur.
      </p>
    </div>
    <div class="post-card__buttons">
      <button>
        <svg
          width="64px"
          height="64px"
          viewBox="0 0 24 24"
          xmlns="http://www.w3.org/2000/svg"
          fill="#000000"
        >
          <g id="SVGRepo_bgCarrier" stroke-width="0"></g>
          <g
            id="SVGRepo_tracerCarrier"
            stroke-linecap="round"
            stroke-linejoin="round"
          ></g>
          <g id="SVGRepo_iconCarrier">
            <title></title>
            <g id="Complete">
              <g id="edit">
                <g>
                  <path
                    d="M20,16v4a2,2,0,0,1-2,2H4a2,2,0,0,1-2-2V6A2,2,0,0,1,4,4H8"
                    fill="none"
                    stroke="#888888"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                  ></path>
                  <polygon
                    fill="none"
                    points="12.5 15.8 22 6.2 17.8 2 8.3 11.5 8 16 12.5 15.8"
                    stroke="#ffffff"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                  ></polygon>
                </g>
              </g>
            </g>
          </g>
        </svg>
      </button>
      <button>
        <svg
          width="64px"
          height="64px"
          viewBox="0 0 24 24"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <g id="SVGRepo_bgCarrier" stroke-width="0"></g>
          <g
            id="SVGRepo_tracerCarrier"
            stroke-linecap="round"
            stroke-linejoin="round"
          ></g>
          <g id="SVGRepo_iconCarrier">
            <path
              d="M4 7H20"
              stroke="#ffffff"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            ></path>
            <path
              d="M6 7V18C6 19.6569 7.34315 21 9 21H15C16.6569 21 18 19.6569 18 18V7"
              stroke="#ffffff"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            ></path>
            <path
              d="M9 5C9 3.89543 9.89543 3 11 3H13C14.1046 3 15 3.89543 15 5V7H9V5Z"
              stroke="#ffffff"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            ></path>
          </g>
        </svg>
      </button>
    </div>
  </div>
</template>

<script></script>

<style scoped>
.post-card__container {
  position: relative;
  width: 100%;
  height: 15rem;
  background-color: #130e0e;
  display: flex;
  justify-content: start;
  overflow: hidden;
  cursor: pointer;
}

.post-card__img {
  object-fit: cover;
  width: 20%;
  aspect-ratio: 1 / 1;
}

.post-card__text {
  text-align: start;
  padding: 1rem;
  text-overflow: clip;
}
.post-card__title {
  font-size: 2.5rem;
}
.post-card__description {
  margin-top: 0.5rem;
  line-height: 1.5rem;
}
.post-card__buttons {
  position: absolute;
  display: flex;
  gap: 0.5rem;
  right: 1rem;
  top: 1rem;
  height: 10%;
}

.post-card__buttons button {
  background-color: transparent;
  border: none;
  cursor: pointer;
}
.post-card__buttons svg {
  height: 100%;
}

.post-card__buttons svg * {
  transition: all ease 0.1s;
  stroke: #888888;
}
.post-card__buttons button:hover svg * {
  stroke: white;
}
</style>
