let service;
let list = []

let allItemsIncomplete = true;


function displayListTitle() {
    const title = document.getElementById("title")
    title.textContent = service.getListName();
}


function displayShoppingList() {
    const parent = document.getElementById("shopping-list")
    parent.innerHTML = "";

    list.forEach(item => {
        addListItem(item, parent);
    })
}

function addListItem(item, parent)
{
    const div = document.createElement("div")
    div.classList.add("list-item");
    if(item.isComplete)
    {
        div.classList.add("complete")
    }

    addItemTitle(item, div);
    addQuantity(item, div)

    div.addEventListener("click", () => markItemComplete(div))
    div.addEventListener("dblclick",() => markItemIncomplete(div))

    parent.appendChild(div)
}

function markItemComplete(div)
{
    div.classList.add("complete")
}

function markItemIncomplete(div)
{
    div.classList.remove("complete")
}

function addItemTitle(item, parent)
{
    const div = document.createElement("div")
    div.textContent = item.title;

    parent.appendChild(div);
}

function addQuantity(item, parent)
{
    const div = document.createElement("div");
    div.classList.add("quantity-container");

    const span = document.createElement("span");
    span.textContent = "quantity"
    span.classList.add("super");

    const text = document.createTextNode(item.quantity)

    div.appendChild(span)
    div.appendChild(text)

    parent.appendChild(div);
}


function markAllCompleted(event) {
    const button = event.target;

    const listItems = document.querySelectorAll(".list-item");

    listItems.forEach(item => {
        if(allItemsIncomplete)
        {
            markItemComplete(item);
        }
        else
        {
            markItemIncomplete(item);
        }
    });

    allItemsIncomplete  = !allItemsIncomplete;

    button.textContent = allItemsIncomplete ? "Mark All Completed" : "Mark All Incompleted";
}


// create the page load event here

document.addEventListener("DOMContentLoaded", () => {
    service = new ShoppingService();
    list = service.getShoppingList();

    const completeButton = document.getElementById("allCompleteButton");
    completeButton.addEventListener("click", markAllCompleted);


    displayListTitle();
    displayShoppingList();

    const addForm = document.getElementById("addForm");

    addForm.addEventListener("submit", (event) => {
        event.preventDefault();

        addForm.classList.add('was-validated')

        if (addForm.checkValidity()) {

            addForm.classList.remove('was-validated')
    

            const itemName = document.getElementById("itemName").value;
            const quantity = document.getElementById("quantity").value;
            const id = list.map(item => item.id).reduce((a,b) => Math.max(a,b), 0) + 1;

            const newItem = {
                id: id,
                title: itemName,
                quantity: quantity,
                isComplete: false
            }

            list.push(newItem);
            displayShoppingList();

            clearForm();
        }
        
    });
});

function clearForm()
{

    document.getElementById("itemName").value = "";
    document.getElementById("quantity").value = "";
}

