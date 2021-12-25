package com.example.blog.service;

import com.example.blog.api.admin.DTO.ContactDTO;
import com.example.blog.entity.ArticleCategory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * Author：陈冰
 * Date：2021/12/25 9:34
 */
@Component
public interface ArticleCategoryService {
    List<ArticleCategory> selectByAId(int aId);

    List<ArticleCategory> selectByCId(int cId);

    int addNewContact(ArticleCategory articleCategory);

    int deletedContact(ArticleCategory articleCategory);

    int recoverContact(ArticleCategory articleCategory);
}
