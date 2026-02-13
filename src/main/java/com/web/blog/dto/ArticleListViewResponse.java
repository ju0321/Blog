package com.web.blog.dto;

import com.web.blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ArticleListViewResponse {
  private final Long id;
  private final String title;
  private final String content;

  public ArticleListViewResponse(Article article) {
    this.id = article.getId();
    this.title = article.getTitle();
    this.content = article.getContent();
  }
}
