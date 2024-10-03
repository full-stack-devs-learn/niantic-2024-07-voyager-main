import {useState} from 'react'
import CategoryCardContainer from '../category-card-container/CategoryCardContainer'
import './CategoriesPage.css'
import CategoryAdd from "../category-add/CategoryAdd.jsx";
import {PlusCircle} from 'react-bootstrap-icons'

export default function CategoriesPage()
{
    const [action, setAction] = useState('list')

    function categoryAdded()
    {
        setAction('list')
    }

    return (
        <>
            <header className="container mt-4">
                <h1>Categories</h1>
            </header>
            <button className="btn btn-danger" onClick={() => setAction('add')}><PlusCircle/></button>

            {action === 'list' && <CategoryCardContainer></CategoryCardContainer>}
            {action === 'add' && <CategoryAdd onCategoryAdded={categoryAdded}></CategoryAdd>}
        </>
    )
}