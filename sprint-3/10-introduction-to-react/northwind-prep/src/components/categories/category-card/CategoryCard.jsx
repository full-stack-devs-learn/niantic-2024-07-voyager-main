import './CategoryCard.css'
import {PencilFill, XSquareFill} from 'react-bootstrap-icons'
import categoriesService from "../../../services/categories-service.js";

// eslint-disable-next-line react/prop-types
export default function CategoryCard({categoryId, categoryName, onCategorySelected, onCategoryDeleted})
{
    const imageUrl = `images/categories/${categoryId}.webp`
    
    const categoryClicked = () => {
        // console.log(id)
        // console.log(category); 
        onCategorySelected(categoryName)
    }

    const editClicked = (event) =>
    {
        event.preventDefault()
        event.stopPropagation()
        console.log(`edit ${categoryName}`)
    }

    const deleteClicked = async(event) =>
    {
        event.preventDefault()
        event.stopPropagation()

        try {

            console.log(`deleting ${categoryName}`)
            await categoriesService.delete(categoryId)
            onCategoryDeleted(categoryId)
        }
        catch {
            //
        }
    }

    return(
        <div className="card category-card" onClick={categoryClicked}>
            <div id="category-header" className="card-header">{categoryName}</div>
            <div id="category-body" className="card-body">
                <img id="category-image" src={imageUrl} />
            </div>
            <div className="card-footer">
                <PencilFill className="edit" onClick={editClicked}/>
                <XSquareFill color='red' onClick={deleteClicked}/>
            </div>
        </div>
    )
}