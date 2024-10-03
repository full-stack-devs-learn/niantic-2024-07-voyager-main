import { Link, Routes, Route, Outlet } from 'react-router-dom'
// import { useState } from 'react'
import CategoryAdd from '../category-add/CategoryAdd'
import CategoryCardContainer from '../category-card-container/CategoryCardContainer'
import './CategoriesPage.css'

export default function CategoriesPage()
{
    // const [action, setAction] = useState<string>("list");

    return (
        <>
            <header className="mt-4">
                <h1>Categories</h1>
            </header>
            <Link className="btn btn-danger" to="add">Add</Link>

            <Outlet />

            
        </>
    )
}