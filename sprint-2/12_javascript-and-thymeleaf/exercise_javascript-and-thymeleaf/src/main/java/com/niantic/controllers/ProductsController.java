package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ProductsController
{
    private CategoryDao categoryDao = new CategoryDao();
    private ProductDao productDao = new ProductDao();

    // list all categories
    @GetMapping( "/products")
    public String products(Model model,@RequestParam(defaultValue = "1", name ="catId") Integer categoryId)
    {
        var categories = categoryDao.getCategories();
        var category = categoryDao.getCategoryById(categoryId);

        model.addAttribute("categories", categories);
        model.addAttribute("currentCategory", category);
        return "products/index";
    }

    @GetMapping( "/products/category/{categoryId}")
    public String productsByCategory(Model model, @PathVariable int categoryId)
    {
        var products = productDao.getProductsByCategory(categoryId);

        model.addAttribute("products", products);
        return "fragments/products-list";
    }

    // details page
    @GetMapping("/products/{id}")
    public String getProduct(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);

        if(product == null)
        {
            return "404";
        }

        var category = categoryDao.getCategoryById(product.getCategoryId());

        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "products/details";
    }

    // add category
    @GetMapping("/products/new")
    public String addCategory(Model model)
    {
        var categories = categoryDao.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new Product());
        return "products/add";
    }

    @PostMapping("/products/new")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, Model model, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            var categories = categoryDao.getCategories();
            model.addAttribute("categories", categories);
            model.addAttribute("product", product);

            return "products/add";
        }

        productDao.addProduct(product);
        return "redirect:/products?catId=" + product.getCategoryId();
    }

    // edit category
    @GetMapping("/products/{id}/edit")
    public String editProduct(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);

        if(product == null)
        {
            return "404";
        }

        var categories = categoryDao.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/products/{id}/edit")
    public String editCategory(@ModelAttribute("product") Product product, @PathVariable int id)
    {
        productDao.updateProduct(product);

        return "redirect:/products?catId=" + product.getCategoryId();
    }


    // edit category
    @GetMapping("/products/{id}/delete")
    public String deleteCategory(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);

        if(product == null)
        {
            return "404";
        }

        var category = categoryDao.getCategoryById(product.getCategoryId());
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "products/delete";
    }

    @PostMapping("/products/{id}/delete")
    public String deleteCategoryConfirm(@PathVariable int id)
    {
        var product = productDao.getProduct(id);
        if(product == null)
        {
            return "404";
        }

        productDao.deleteProduct(id);

        return "redirect:/products?catId=" + product.getCategoryId();
    }
}
