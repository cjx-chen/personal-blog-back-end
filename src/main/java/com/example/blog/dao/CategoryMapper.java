package com.example.blog.dao;

import com.example.blog.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    List<Category> getAllCategories();

    Category getCategoryById(int categoryId);

    int addCategory(String categoryName);

    int updateCategory(Category category);

    int deleteCategory(int categoryId);
}
