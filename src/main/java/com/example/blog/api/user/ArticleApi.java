package com.example.blog.api.user;

import com.example.blog.entity.Article;
import com.example.blog.entity.ArticleCategory;
import com.example.blog.service.ArticleCategoryService;
import com.example.blog.service.ArticleService;
import com.example.blog.util.Result;
import com.example.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * Author：陈冰
 * Date：2021/12/18 20:51
 */
@RestController
@Api(value = "v1", tags = "1-1 文章接口")
@RequestMapping("api/v1")
public class ArticleApi {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @CrossOrigin
    @RequestMapping(value = "/getArticles", method = RequestMethod.GET)
    @ApiOperation("获取所有文章")
    public Result selectAllArticles(){
        List<Article> articles = articleService.getAllArticles();
        return ResultGenerator.genSuccessResult(articles);
    }

    @CrossOrigin
    @RequestMapping(value = "/getPartArticles", method = RequestMethod.GET)
    @ApiOperation("获取某分类下的所有文章")
    public Result selectPartOfTheArticles(int cId){
        List<ArticleCategory> articleCategories = articleCategoryService.selectByCId(cId);
        List<Article> articles = new ArrayList<>();
        for (int i=0;i<articleCategories.size();i++){
            Article article = articleService.getArticleById(articleCategories.get(i).getAId());
            articles.add(article);
        }
        return ResultGenerator.genSuccessResult(articles);
    }

    @CrossOrigin
    @RequestMapping(value = "/getArticle/{articleId}", method = RequestMethod.GET)
    @ApiOperation("获取文章详情")
    public Result selectWorksById(@PathVariable("articleId") @RequestBody Integer worksId) {
        Article article = articleService.getArticleById(worksId);
        return ResultGenerator.genSuccessResult(article);
    }
}
