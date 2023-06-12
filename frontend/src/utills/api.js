const API_URL = "http://localhost:8000/api/v1";

const getPostTypes = async () => {
  let data = await fetch(`${API_URL}/post_types`).then((response) =>
    response.json()
  );
  console.log(data);
  return data;
};

const getPosts = async () => {
  let data = await fetch(`${API_URL}/posts`).then((response) =>
    response.json()
  );
  console.log(data);
  return data;
};

const savePost = async (post) => {
  let formData = new FormData();
  formData.append("post", JSON.stringify(post));
  formData.append("file", post.postFile);
  fetch(`${API_URL}/posts`, {
    method: "POST",
    body: formData,
  })
    .then((response) => {
      console.log(response);
      return response.ok;
    })
    .catch((err) => {
      console.log(err);
      return false;
    });
};

const deletePost = async (id) => {
  let answer;
  await fetch(`${API_URL}/posts/${id}`, {
    method: "DELETE",
  }).then((response) => {
    answer = response.json();
  });
  return answer;
};

export { getPostTypes, savePost, getPosts, deletePost };
