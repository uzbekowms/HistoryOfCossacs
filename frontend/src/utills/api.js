const API_URL = "http://localhost:8000/api/v1";

const getPostTypes = async () => {
  let data = await fetch(`${API_URL}/post_types`).then((response) =>
    response.json()
  );
  console.log(data);
  return data;
};

const savePost = async (post) => {
  let formdata = new FormData();
  formdata.append(
    "post",
    new Blob([JSON.stringify(post)], { type: "application/json" })
  );
  formdata.append("file", new Blob([post.postFile, post.postFile.name]));
  console.log(...formdata);
  fetch(`${API_URL}/posts`, {
    method: "POST",
    body: formdata,
  }).then((response) => {
    console.log(response);
  });
};

export { getPostTypes, savePost };
