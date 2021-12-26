package com.example.blog.api.user;

import com.example.blog.entity.ArticleCategory;
import com.example.blog.entity.Category;
import com.example.blog.service.ArticleCategoryService;
import com.example.blog.service.CategoryService;
import com.example.blog.util.Result;
import com.example.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "v1", tags = "1-2 分类接口")
@RequestMapping("api/v1")
public class CategoryApi {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @CrossOrigin
    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    @ApiOperation("获取所有分类")
    public Result selectAllArticles(){
        List<Category> categories = categoryService.getAllCategories();
        return ResultGenerator.genSuccessResult(categories);
    }

    @CrossOrigin
    @RequestMapping(value = "/getArticleCategories", method = RequestMethod.GET)
    @ApiOperation("获取某文章所属分类")
    public Result selectPartOfTheArticles(int aId){
        List<ArticleCategory> articleCategories = articleCategoryService.selectByAId(aId);
        List<Category> categories = new ArrayList<>();
        for (int i=0;i<articleCategories.size();i++){
            Category category = categoryService.getCategoryById(articleCategories.get(i).getCId());
            categories.add(category);
        }
        return ResultGenerator.genSuccessResult(categories);
    }

}
