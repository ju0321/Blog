package com.web.blog.dto;

import com.web.blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponse {
  private String title;
  private String content;

  public ArticleResponse(Article article) {
    this.title = article.getTitle();
    this.content = article.getContent();
  }
}
