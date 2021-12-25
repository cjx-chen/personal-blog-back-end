package com.example.blog.api.admin;

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
 * Date：2021/12/23 16:01
 */
@RestController
@Api(value = "v1", tags = "2-1 管理端文章接口")
@RequestMapping("manage-api/v1")
public class AdminArticleApi {
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
    @RequestMapping(value = "/getDeletedArticles", method = RequestMethod.GET)
    @ApiOperation("获取所有被删文章")
    public Result selectAllDeletedArticles(){
        List<Article> articles = articleService.getAllDeletedArticles();
        return ResultGenerator.genSuccessResult(articles);
    }


    @CrossOrigin
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    @ApiOperation("新增一篇文章")
    public Result addArticle(@RequestHeader("application/json") @RequestBody Article article){
        try {
            articleService.addArticle(article);
            Article newArticle = articleService.getTheLastArticle();
            return ResultGenerator.genSuccessResult("文章添加成功！",newArticle);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("文章添加失败");
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/changeArticle", method = RequestMethod.PUT)
    @ApiOperation("修改一篇文章")
    public Result updateArticle(@RequestHeader("application/json") @RequestBody Article article){
        try {
            articleService.updateArticle(article);
            System.out.println(articleService.updateArticle(article)+"卡卡");
            return ResultGenerator.genSuccessResult(article);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("文章修改失败");
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteArticle", method = RequestMethod.PUT)
    @ApiOperation("删除文章")
    public Result deleteArticle(int articleId){
        try {
            articleService.deleteArticle(articleId);
            return ResultGenerator.genSuccessResult("删除文章成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("删除文章失败");
        }
    }



    @CrossOrigin
    @RequestMapping(value = "/recoverArticle", method = RequestMethod.PUT)
    @ApiOperation("恢复文章")
    public Result recoverArticle(int articleId){
        try {
            articleService.recoverArticle(articleId);
            return ResultGenerator.genSuccessResult("恢复文章成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("恢复文章失败");
        }
    }

}
