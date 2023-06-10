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
  fetch(`${API_URL}/posts`, {
    method: "POST",
    body: JSON.stringify(post),
    headers: {
      "Content-Type": "application/json",
    },
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

export { getPostTypes, savePost, getPosts };
