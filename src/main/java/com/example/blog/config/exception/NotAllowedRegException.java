package com.example.blog.config.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description：
 * Param：
 * return：
 * Author：陈冰
 * Date：2021/12/18 19:55
 */
@Data
@NoArgsConstructor
public class NotAllowedRegException extends Exception{
    private int code;

    private String message;

    public NotAllowedRegException(String message) {
        super(message);
    }
}
