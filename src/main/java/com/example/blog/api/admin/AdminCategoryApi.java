package com.example.blog.api.admin;

import com.example.blog.entity.Category;
import com.example.blog.service.CategoryService;
import com.example.blog.util.Result;
import com.example.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "v1", tags = "2-2 管理端分类接口")
@RequestMapping("manage-api/v1")
public class AdminCategoryApi {
    @Autowired
    private CategoryService categoryService;

    @CrossOrigin
    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    @ApiOperation("获取所有分类")
    public Result selectAllArticles(){
        List<Category> categories = categoryService.getAllCategories();
        return ResultGenerator.genSuccessResult(categories);
    }

    @CrossOrigin
    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    @ApiOperation("新增一个分类")
    public Result addCategory(String categoryName){
        try {
            if (categoryService.addCategory(categoryName) == -1){
                return ResultGenerator.genFailResult("该分类已存在，请重新命名！");
            }else {
                categoryService.addCategory(categoryName);
                return ResultGenerator.genSuccessResult("分类添加成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("分类添加失败");
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/changeCategory", method = RequestMethod.PUT)
    @ApiOperation("修改分类")
    public Result updateCategory(@RequestHeader("application/json") @RequestBody Category category){
        try {
            if (categoryService.updateCategory(category) == -1){
                return ResultGenerator.genFailResult("该分类已存在，请重新命名！");
            }else {
                categoryService.updateCategory(category);
                return ResultGenerator.genSuccessResult("分类修改成功", category);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("分类修改失败");
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteCategory", method = RequestMethod.PUT)
    @ApiOperation("删除分类")
    public Result deleteCategory(int categoryId){
        try {
            if (categoryService.deleteCategory(categoryId) == -1){
                return ResultGenerator.genFailResult("该分类下有文章，不可直接删除分类！");
            }else {
                categoryService.deleteCategory(categoryId);
                return ResultGenerator.genSuccessResult("删除分类成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("删除分类失败");
        }
    }
}
