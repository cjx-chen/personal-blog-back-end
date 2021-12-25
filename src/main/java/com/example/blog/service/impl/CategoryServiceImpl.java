package com.example.blog.service.impl;

import com.example.blog.dao.ArticleCategoryMapper;
import com.example.blog.dao.CategoryMapper;
import com.example.blog.entity.ArticleCategory;
import com.example.blog.entity.Category;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    @Override
    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryMapper.getCategoryById(categoryId);
    }

    @Override
    public int addCategory(String categoryName) {
        List<Category> categories = categoryMapper.getAllCategories();
        for (int i=0;i<categories.size();i++){
            String name = categories.get(i).getCategoryName();
            if (name.equals(categoryName)){
                return -1;
            }
        }
        return categoryMapper.addCategory(categoryName);
    }

    @Override
    public int updateCategory(Category category) {
        List<Category> categories = categoryMapper.getAllCategories();
        for (int i=0;i<categories.size();i++){
            String name = categories.get(i).getCategoryName();
            if (name.equals(category.getCategoryName())){
                return -1;
            }
        }
        return categoryMapper.updateCategory(category);
    }

    @Override
    public int deleteCategory(int categoryId) {
        List<ArticleCategory> list = articleCategoryMapper.selectByCId(categoryId);
        int total = list.size();
        if (total != 0){
            return -1;
        }else {
            return categoryMapper.deleteCategory(categoryId);
        }
    }
}
