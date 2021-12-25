package com.example.blog.config.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotAllowedRegException extends Exception{
    private int code;

    private String message;

    public NotAllowedRegException(String message) {
        super(message);
    }
}
