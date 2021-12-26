package com.example.blog.api.admin;

import com.example.blog.api.admin.DTO.ContactDTO;
import com.example.blog.entity.Article;
import com.example.blog.entity.ArticleCategory;
import com.example.blog.service.ArticleCategoryService;
import com.example.blog.util.Result;
import com.example.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "v1", tags = "2-1 管理端映射接口")
@RequestMapping("manage-api/v1")
public class AdminArticleCategoryApi {
    @Autowired
    private ArticleCategoryService articleCategoryService;

    @CrossOrigin
    @RequestMapping( value = "addNewContact", method = RequestMethod.POST)
    @ApiOperation("新增一个映射")
    public Result addContact(@RequestHeader("application/json") @RequestBody ContactDTO contactDTO){
        try {
            List<ArticleCategory> articleCategories = new ArrayList<>();
            int articleId = contactDTO.getArticleId();
            List<Integer> categoryIds = contactDTO.getCategoryIds();
            for (int i=0;i<categoryIds.size();i++){
                ArticleCategory articleCategory = new ArticleCategory();
                articleCategory.setAId(articleId);
                articleCategory.setCId(categoryIds.get(i));
                articleCategories.add(articleCategory);
                articleCategoryService.addNewContact(articleCategory);
            }
            return ResultGenerator.genSuccessResult("新增成功！",articleCategories);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("新增失败！");
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteContacts", method = RequestMethod.PUT)
    @ApiOperation("删除映射")
    public Result deleteContacts(@RequestHeader("application/json") @RequestBody ContactDTO contactDTO){
        try {
            List<ArticleCategory> articleCategories = new ArrayList<>();
            int articleId = contactDTO.getArticleId();
            List<Integer> categoryIds = contactDTO.getCategoryIds();
            for (int i= 0;i<categoryIds.size();i++){
                ArticleCategory articleCategory = new ArticleCategory();
                articleCategory.setAId(articleId);
                articleCategory.setCId(categoryIds.get(i));
                System.out.println(articleCategory.toString()+"拿到了！！！");
                articleCategories.add(articleCategory);
                articleCategoryService.deletedContact(articleCategory);
            }
            return ResultGenerator.genSuccessResult("删除映射成功",articleCategories);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("删除映射失败");
        }
    }



    @CrossOrigin
    @RequestMapping(value = "/recoverContacts", method = RequestMethod.PUT)
    @ApiOperation("恢复映射")
    public Result recoverContacts(@RequestHeader("application/json") @RequestBody ContactDTO contactDTO){
        try {
            List<ArticleCategory> articleCategories = new ArrayList<>();
            int articleId = contactDTO.getArticleId();
            List<Integer> categoryIds = contactDTO.getCategoryIds();
            for (int i= 0;i<categoryIds.size();i++){
                ArticleCategory articleCategory = new ArticleCategory();
                articleCategory.setAId(articleId);
                articleCategory.setCId(categoryIds.get(i));
                articleCategories.add(articleCategory);
                articleCategoryService.recoverContact(articleCategory);
            }
            return ResultGenerator.genSuccessResult("删除映射成功",articleCategories);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("删除映射失败");
        }
    }
}
