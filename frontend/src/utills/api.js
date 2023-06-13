import axios from "axios";

const API_URL = "http://localhost:8000/api/v1";

const getPostTypes = async () => {
  return await axios(`${API_URL}/post_types`).then((response) =>
    JSON.stringify(response.data)
  );
};

const getPosts = async () => {
  return await axios(`${API_URL}/posts`).then((response) =>
    JSON.stringify(response.data)
  );
};

const savePost = async (post) => {
  let formdata = new FormData();
  formdata.append("post", JSON.stringify(post));
  formdata.append("file", post.postFile);
  return await axios(`${API_URL}/posts`, {
    method: "POST",
    data: formdata,
    headers: {
      Accept: "application/json",
      "Content-type": "multipart/form-data",
    },
  }).then((response) => {
    JSON.stringify(response.data);
  });
};

const deletePost = async (id) => {
  return await axios(`${API_URL}/posts/${id}`, {
    method: "DELETE",
  }).then((response) => {
    JSON.stringify(response.data);
  });
};

export { getPostTypes, savePost, getPosts, deletePost };
