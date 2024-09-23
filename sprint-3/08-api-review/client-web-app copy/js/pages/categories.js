let categoryService;
let addForm;

document.addEventListener("DOMContentLoaded", function() {
    categoryService = new CategoryService();

    document.getElementById("add-button").addEventListener("click", showForm);

    loadCategories();
})

async function loadCategories()
{
    const categories = await categoryService.getAllCategories();

    const categoryContainer = document.getElementById('categories-container');
    categoryContainer.innerHTML = '';

    categories.forEach(category => {
        const clone = document.getElementById('category-template').content.cloneNode(true);
        clone.getElementById('category-header').innerText = category.categoryName;
        clone.getElementById('category-image').src = `images/${category.categoryId}.webp`;

        const deleteButton = clone.querySelector('.card-footer #delete-button');
        deleteButton.addEventListener('click', () => {
            categoryService.deleteCategory(category.categoryId).then(() => {
                loadCategories();
            })
        });

        categoryContainer.appendChild(clone);
    })
}

async function showForm()
{
    const response = await axios.get(`templates/category-form.html`);
    const html = response.data;

    const popup = document.getElementById('popup');
    popup.innerHTML = html;

    document.getElementById("cancel-button").addEventListener("click", cancelAdd);
    document.getElementById("save-button").addEventListener("click", addCategory);

    addForm = document.getElementById("add-form");
}

function cancelAdd(event)
{
    event.preventDefault();
    document.getElementById('popup').innerHTML = '';
}

async function addCategory(event)
{
    event.preventDefault();
    event.stopPropagation()

    addForm.classList.add("was-validated");

    if(addForm.checkValidity()){
        const name = document.getElementById("category-name").value;
        const description = document.getElementById("category-description").value;

        const category = {
            categoryName: name,
            description: description,
        }

        const response = await categoryService.addCategory(category);
        loadCategories();

        document.getElementById('popup').innerHTML = '';
    }
}