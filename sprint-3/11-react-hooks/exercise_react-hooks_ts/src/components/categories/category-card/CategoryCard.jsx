import categoryService from '../../../services/category-service'
import './CategoryCard.css'
import { XCircle, XCircleFill } from 'react-bootstrap-icons'
import { Link } from 'react-router-dom'

export default function CategoryCard({id, category, onCategorySelected, onCategoryDeleted})
{
    const imageUrl = `images/categories/${id}.webp`
    
    const categoryClicked = () => {
        // console.log(id)
        // console.log(category); 
        onCategorySelected(category)       
    }

    async function deleteCategory(event)
    {
        event.stopPropagation();

        await categoryService.delete(id);

        onCategoryDeleted(id);
    }


    return(
        <Link className="card category-card" to={`/categories/${id}`}>
            <div id="category-header" className="card-header">{category}</div>
            <div id="category-body" className="card-body">
                <img id="category-image" src={imageUrl} />
            </div>
            <div className="card-footer">
                <XCircleFill onClick={deleteCategory} color="red" />
            </div>
        </Link>
    )
}