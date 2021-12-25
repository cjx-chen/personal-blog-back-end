package com.example.blog.dao;

import com.example.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
