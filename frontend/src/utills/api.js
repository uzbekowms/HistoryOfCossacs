const API_URL = "http://localhost:8000/api/v1";

const getPostTypes = async () => {
  let data = await fetch(`${API_URL}/post_types`).then((response) =>
    response.json()
  );
  console.log(data);
  return data;
};

const savePost = async (post) => {
  fetch(`${API_URL}/posts`, {
    method: "post",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(post),
  }).then((response) => {
    console.log(response);
  });
};

export { getPostTypes, savePost };
