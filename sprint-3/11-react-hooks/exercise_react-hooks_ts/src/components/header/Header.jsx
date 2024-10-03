import { Link } from 'react-router-dom'
import './Header.css'

export default function Header()
{
    return(
        <div id="navigation">
            <img src="/images/logo.png" alt="Northwind Logo" />
            <h1>Northwind Traders</h1>

            <Link className="link" to="/">Home</Link>
            <Link className="link" to="/categories">Categories</Link>
            <Link className="link" to="/products">Products</Link>
        </div>
    )
}
