package com.example.blog.dao;

import com.example.blog.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * Author：陈冰
 * Date：2021/12/24 15:57
 */
@Mapper
@Repository
public interface CategoryMapper {
    List<Category> getAllCategories();

    Category getCategoryById(int categoryId);

    int addCategory(String categoryName);

    int updateCategory(Category category);

    int deleteCategory(int categoryId);
}
