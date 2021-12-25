package com.example.blog.service;

import com.example.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * Author：陈冰
 * Date：2021/12/18 20:45
 */
@Component
public interface ArticleService {
    List<Article> getAllArticles();

    List<Article> getAllDeletedArticles();

    Article getArticleById(int articleId);

    Article getTheLastArticle();

    int addArticle(Article article);

    int updateArticle(Article article);

    int deleteArticle(int articleId);

    int recoverArticle(int articleId);


}
