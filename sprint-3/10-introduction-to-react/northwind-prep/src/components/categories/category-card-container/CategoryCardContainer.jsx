import { useState, useEffect } from 'react';
import CategoryCard from '../category-card/CategoryCard'
import './CategoryCardContainer.css'
import categoriesService from "../../../services/categories-service.js";

export default function CategoryCardContainer()
{
    const [selectedCategory, setSelectedCategory] = useState("None Selected");
    const [dataChanged, setDataChanged] = useState(false);
    const [categories, setCategories] = useState([]);

    useEffect( () => {
        getCategories();
    },[selectedCategory, dataChanged]);

    async function getCategories()
    {
        const data = await categoriesService.getCategories();
        setCategories(data);
    }


    const categorySelected = (name) =>
    {
        setSelectedCategory(name);
        console.log(name)
    }

    const categoryDeleted = (categoryId) => {
        const filteredCategories = categories.filter(category => categoryId !== category.categoryId);
        setCategories(filteredCategories);
    }

    return(
        <>
        <h5 className="container">Selected Category: {selectedCategory}</h5>
        <main className="container mt-4 categories-container" id="categories-container">
        {
            categories.map((category) => (
                <CategoryCard key={category.categoryId}
                              {...category}
                              onCategorySelected={categorySelected}
                              onCategoryDeleted={categoryDeleted}
                    ></CategoryCard>
            ))
        }
        </main>
        </>
    )
}