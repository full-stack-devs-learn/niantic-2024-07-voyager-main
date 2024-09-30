import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import categoryService from "../../../services/category-service";
import { Category } from "../../../models/category";
import './CategoryDetail.css'

export default function CategoryDetail()
{
    const params = useParams()
    const [category, setCategory] = useState<Category>()

    useEffect(() => {

        categoryService.getCategoryById(params.categoryId).then(data => {
            setCategory(data);   
        })

    }, 
    // an emptry array says that I only want
    // this code to run one time before the first render
    [])

    return (
        <div>
            <h3>{category?.categoryName}</h3>
            <p>{category?.description}</p>
            <img className="category-detail-image" src={`/images/categories/${category?.categoryId}.webp`} alt="" />
        </div>
    )

}