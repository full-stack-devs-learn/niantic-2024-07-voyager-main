import { useState } from 'react';
import categoriesService from "../../../services/categories-service.js";

export default function CategoryAdd(onCategoryAdded){
    const [categoryName, setCategoryName] = useState('');
    const [description, setDescription] = useState('');
    const [successMessage, setSuccessMessage] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [valid, setValid] = useState('');

    // Function to handle form submission
    async function handleSubmit(event) {
        event.preventDefault(); // Prevent default form submission behavior

        if(!categoryName){
            setValid('was-validated');
        }
        else {

            // Create an object to send as the payload
            const newCategory = {
                categoryName: categoryName,
                description: description,
            };

            try {
                // Make an API POST request to insert the new category
                const category = await categoriesService.add(newCategory);
                setValid('');

                setSuccessMessage(`Category "${category.categoryName}" added successfully!`);
                setCategoryName(''); // Reset form fields
                setDescription('');

                onCategoryAdded();

            } catch (error) {
                setErrorMessage(error.message); // Display error message
            }
        }
    }

    return (
        <div>
            <h2>Add a New Category</h2>

            {/* Form to capture category name and description */}
            <form onSubmit={handleSubmit} noValidate className={valid}>
                <div>
                    <label>Category Name:</label>
                    <input
                        type="text"
                        value={categoryName}
                        onChange={(e) => setCategoryName(e.target.value)}
                        required
                    />
                    <div className="invalid-feedback">Category Name is required.</div>
                </div>
                <div>
                    <label>Description:</label>
                    <textarea
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                    />
                </div>
                <button type="submit" className='btn btn-success'>Add Category</button>
            </form>

            {/* Success or error messages */}
            {successMessage && <p style={{ color: 'green' }}>{successMessage}</p>}
            {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
        </div>
    );
};

