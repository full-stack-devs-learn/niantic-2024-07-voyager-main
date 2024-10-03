package com.niantic.controllers.apis;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import com.niantic.services.MySqlCategoryDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController
{
    private CategoryDao categoryDao = new MySqlCategoryDao();

    @GetMapping("/api/categories")
    public ResponseEntity<List<Category>> getAllCategories()
    {
        try
        {
            return new ResponseEntity<>(categoryDao.getCategories(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id)
    {
        try
        {
            var category = categoryDao.getCategory(id);
            if(category == null)
            {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(category);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/api/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category)
    {
        return categoryDao.addCategory(category);
    }

    @PutMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        categoryDao.updateCategory(id, category);
    }

    @DeleteMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id)
    {
        categoryDao.deleteCategory(id);
    }

}
