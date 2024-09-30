// import { useState } from "react"
import Header from "./components/header/Header"
import CategoriesPage from "./components/categories/cagtegories-page/CategoriesPage"
import ProductsPage from "./components/products/products-page/ProductsPage"
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import HomePage from "./components/home-page/HomePage"
import CategoryCardContainer from "./components/categories/category-card-container/CategoryCardContainer"
import CategoryAdd from "./components/categories/category-add/CategoryAdd"
import CategoryDetail from "./components/categories/category-detail/CategoryDetail"
import { Suspense } from "react"

function App() {
  // const [pageName, setPageName] = useState("categories")

  // const pageChangeHanlder = (newPage: SetStateAction<string>) =>
  // {
  //   setPageName(newPage);
  //   console.log("changing page to: " + pageName); 
  // }



  return (
    <>
      <Router>
        <Header></Header>
        <div className="container">
          <Suspense fallback={<div>Loading...</div>} >
            <Routes>
              <Route path="/" element={<HomePage />} />
              <Route path="/categories" element={<CategoriesPage />}>
                <Route path="" element={<CategoryCardContainer />} />
                <Route path="add" element={<CategoryAdd />} />
                <Route path=":categoryId" element={<CategoryDetail />} />
              </Route>
              <Route path="/products" element={<ProductsPage />} />
            </Routes>
          </Suspense>
        </div>
      </Router>

    </>
  )
}

export default App
