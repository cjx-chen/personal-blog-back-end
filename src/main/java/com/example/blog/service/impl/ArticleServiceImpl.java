package com.example.blog.service.impl;

import com.example.blog.dao.ArticleMapper;
import com.example.blog.entity.Article;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<Article> getAllArticles() {
        return articleMapper.getAllArticles();
    }

    @Override
    public List<Article> getAllDeletedArticles() {
        return articleMapper.getAllDeletedArticles();
    }

    @Override
    public Article getArticleById(int articleId) {
        return articleMapper.getArticleById(articleId);
    }

    @Override
    public Article getTheLastArticle() {
        List<Article> articles = articleMapper.getTheLastArticle();
        Article article = new Article();
        article = articles.get(0);
        return article;
    }

    @Override
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public int deleteArticle(int articleId) {
        return articleMapper.deleteArticle(articleId);
    }

    @Override
    public int recoverArticle(int articleId) {
        return articleMapper.recoverArticle(articleId);
    }
}
