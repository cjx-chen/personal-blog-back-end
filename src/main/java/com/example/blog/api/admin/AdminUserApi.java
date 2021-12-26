package com.example.blog.api.admin;

import com.example.blog.entity.Article;
import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import com.example.blog.util.Result;
import com.example.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "v1", tags = "2-3 管理端用户信息接口")
@RequestMapping("manage-api/v1")
public class AdminUserApi {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/getUserInfo/{userId}", method = RequestMethod.GET)
    @ApiOperation("获取用户信息")
    public Result getUserInfoById(@PathVariable("userId") @RequestBody Integer userId) {
        User user = userService.getUserInfoById(userId);
        return ResultGenerator.genSuccessResult(user);
    }

    @CrossOrigin
    @RequestMapping(value = "/changeUserInfo", method = RequestMethod.POST)
    @ApiOperation("修改用户信息")
    public Result updateArticle(@RequestHeader("application/json") @RequestBody User user){
        try {
            userService.updateUserInfo(user);
            System.out.println(userService.updateUserInfo(user));
            return ResultGenerator.genSuccessResult(user);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("用户信息修改失败");
        }
    }
}
