package com.example.blog.service;

import com.example.blog.entity.Article;
import com.example.blog.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * Author：陈冰
 * Date：2021/12/24 16:21
 */
@Component
public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(int categoryId);

    int addCategory(String categoryName);

    int updateCategory(Category category);

    int deleteCategory(int categoryId);
}
