package com.example.blog.config.handler;

import com.example.blog.config.exception.NotAllowedRegException;
import com.example.blog.util.Result;
import com.example.blog.util.ResultGenerator;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//定义一个全局处理异常类
@RestControllerAdvice
public class GlobalExceptionHandler {
    //处理异常的方法  并确定接收的是哪种类型的异常
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        // 捕获到某个指定的异常
        if (e instanceof NotAllowedRegException) {
            //处理结束后 还是要返回统一相应结果类
            return ResultGenerator.genFailResult("异常:当前用户不允许注册");
        } else {
            //处理其它类型的异常 可以进入到不同的分支
            return ResultGenerator.genFailResult();
        }

    }

}
