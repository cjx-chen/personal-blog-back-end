package com.example.blog.service;

import com.example.blog.entity.Article;
import org.springframework.stereotype.Component;

import java.util.List;

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
