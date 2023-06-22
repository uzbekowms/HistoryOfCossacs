import axios from "axios";

const API_URL = "http://localhost:8000/api/v1";

const getPostTypes = async () => {
  return await axios(`${API_URL}/post_types`).then((response) => response.data);
};

const getPosts = async () => {
  return await axios(`${API_URL}/posts`).then((response) => response.data);
};

const getPostsByType = async (type) => {
  return await axios(`${API_URL}/posts/category/${type}`).then(
    (response) => response.data
  );
};

const savePost = async (post) => {
  return await axios(`${API_URL}/posts`, {
    method: "POST",
    data: post,
  }).then((response) => {
    response.data;
  });
};

const deletePost = async (id) => {
  return await axios(`${API_URL}/posts/${id}`, {
    method: "DELETE",
  }).then((response) => {
    response.data;
  });
};

const saveFile = async (file) => {
  let formdata = new FormData();
  formdata.append("file", file);
  return await axios(`${API_URL}/files`, {
    data: formdata,
    method: "POST",
  }).then((response) => response.data);
};

const login = async (user) => {
  return await axios
    .post(`${API_URL}/auth/login`, user)
    .then((response) => response.data);
};

const signup = async (user) => {
  return await axios
    .post(`${API_URL}/auth/signup`, user)
    .then((response) => response.data);
};

const getAllMessages = async () => {
  return await axios
    .get(`${API_URL}/messages`)
    .then((response) => response.data);
};

export {
  getPostTypes,
  savePost,
  getPosts,
  deletePost,
  saveFile,
  getPostsByType,
  login,
  signup,
  getAllMessages,
};
