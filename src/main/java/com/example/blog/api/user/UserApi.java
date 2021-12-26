package com.example.blog.api.user;

import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import com.example.blog.util.Result;
import com.example.blog.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "v1", tags = "1-3 用户信息接口")
@RequestMapping("api/v1")
public class UserApi {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/getUserInfo/{userId}", method = RequestMethod.GET)
    @ApiOperation("获取用户信息")
    public Result getUserInfoById(@PathVariable("userId") @RequestBody Integer userId) {
        User user = userService.getUserInfoById(userId);
        return ResultGenerator.genSuccessResult(user);
    }
}
