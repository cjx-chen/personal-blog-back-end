package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

  private int articleId;
  private String articleTitle;
  private String articleContent;
  private int isDeleted;

}
