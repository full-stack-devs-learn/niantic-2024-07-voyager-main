import { useNavigate } from "react-router-dom";
import { FormEvent, useState } from "react";
import categoryService from "../../../services/category-service"

export default function CategoryAdd<CategoryProps>()
{
    const navigate = useNavigate();
    const [categoryName, setCategoryName] = useState('');
    const [description, setDescription] = useState('');

    async function addCategoryHandler(event: FormEvent<HTMLFormElement>)
    {
        event.preventDefault()
        event.stopPropagation()

        const newCategory = {
            categoryName: categoryName,
            description: description
        }


        // call my api
        await categoryService.add(newCategory)

        goHome()
    
    }

    function goHome()
    {
        navigate('/categories', { replace: true });
    }

    return (
        <div className="container">
        <h2>Add New Category</h2>
        <form onSubmit={addCategoryHandler}>
            <div className="row">
                <label htmlFor="category-name">Category Name:</label>
                <input type="text" className="form-control" name="category-name" id="category-name"
                    onChange={(e) => setCategoryName(e.target.value)}
                />
            </div>

            <div className="row">
                <label htmlFor="description">Description:</label>
                <textarea className="form-control" name="description" id="description"
                    onChange={(e) => setDescription(e.target.value)} />
            </div>
            <button className="btn btn-danger mr-3" type="submit">Add Category</button>
            <button className="btn btn-dark" type="reset" onClick={goHome}>Cancel</button>
        </form>
        </div>
    )
}