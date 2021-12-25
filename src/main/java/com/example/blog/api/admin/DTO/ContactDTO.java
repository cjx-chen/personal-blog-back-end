package com.example.blog.api.admin.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    @ApiModelProperty("当前文章id")
    private int articleId;

    @ApiModelProperty("所选分类集合")
    private List<Integer> categoryIds;
}
