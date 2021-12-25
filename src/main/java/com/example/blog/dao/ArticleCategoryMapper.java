package com.example.blog.dao;

import com.example.blog.api.admin.DTO.ContactDTO;
import com.example.blog.entity.ArticleCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * Author：陈冰
 * Date：2021/12/24 16:43
 */
@Mapper
@Repository
public interface ArticleCategoryMapper {
    List<ArticleCategory> selectByAId(int aId);

    List<ArticleCategory> selectByCId(int cId);

    int addNewContact(ArticleCategory articleCategory);

    int deletedContact(ArticleCategory articleCategory);

    int recoverContact(ArticleCategory articleCategory);


}
