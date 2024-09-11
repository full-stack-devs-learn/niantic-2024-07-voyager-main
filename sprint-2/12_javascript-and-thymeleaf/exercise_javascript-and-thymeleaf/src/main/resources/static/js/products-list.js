document.addEventListener("DOMContentLoaded", () => {
    const categoryList = document.getElementById("category");

    // first time page loads
    loadProducts(categoryList.value)

    // on every category list change
    categoryList.addEventListener("input", () => loadProducts(categoryList.value))
})

function loadProducts(categoryId)
{
    fetch(`/products/category/${categoryId}`)
        .then(response => response.text())
        .then(data => {
            document.getElementById("products-container").innerHTML = data;
        })
}