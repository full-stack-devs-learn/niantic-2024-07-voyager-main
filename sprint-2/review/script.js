document.addEventListener("DOMContentLoaded", () => {
    const username = document.getElementById("username");
    const content = document.getElementById("content");

    username.addEventListener("change", () => {
        username.value = username.value.trim();
        content.innerText = "---" + username.value + "---"
    });
})