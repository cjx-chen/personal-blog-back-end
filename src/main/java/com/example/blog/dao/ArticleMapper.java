package com.example.blog.dao;

import com.example.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * Author：陈冰
 * Date：2021/12/18 20:16
 */
@Mapper
@Repository
public interface ArticleMapper {
    List<Article> getAllArticles();

    List<Article> getAllDeletedArticles();

    List<Article> getTheLastArticle();

    Article getArticleById(int articleId);

    int addArticle(Article article);

    int updateArticle(Article article);

    int deleteArticle(int articleId);

    int recoverArticle(int articleId);


}
