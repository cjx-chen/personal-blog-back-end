package com.example.blog.service;

import com.example.blog.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(int categoryId);

    int addCategory(String categoryName);

    int updateCategory(Category category);

    int deleteCategory(int categoryId);
}
