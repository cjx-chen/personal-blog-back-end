package com.example.blog.service.impl;

import com.example.blog.api.admin.DTO.ContactDTO;
import com.example.blog.dao.ArticleCategoryMapper;
import com.example.blog.dao.ArticleMapper;
import com.example.blog.dao.CategoryMapper;
import com.example.blog.entity.Article;
import com.example.blog.entity.ArticleCategory;
import com.example.blog.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * Author：陈冰
 * Date：2021/12/25 9:34
 */
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {
    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<ArticleCategory> selectByAId(int aId) {
        List<ArticleCategory> list = articleCategoryMapper.selectByAId(aId);
        System.out.println(list.size());
        System.out.println(list.toString());
        return articleCategoryMapper.selectByAId(aId);
    }

    @Override
    public List<ArticleCategory> selectByCId(int cId) {
        return articleCategoryMapper.selectByCId(cId);
    }

    @Override
    public int addNewContact(ArticleCategory articleCategory) {
        return articleCategoryMapper.addNewContact(articleCategory);
    }

    @Override
    public int deletedContact(ArticleCategory articleCategory) {
        return articleCategoryMapper.deletedContact(articleCategory);
    }

    @Override
    public int recoverContact(ArticleCategory articleCategory) {
        return articleCategoryMapper.recoverContact(articleCategory);
    }
}
