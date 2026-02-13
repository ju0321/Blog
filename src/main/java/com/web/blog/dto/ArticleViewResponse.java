package com.web.blog.dto;

import com.web.blog.domain.Article;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleViewResponse {
  private Long id;
  private String title;
  private String content;
  private LocalDateTime createAt;

  public ArticleViewResponse(Article article) {
    this.id = article.getId();
    this.title = article.getTitle();
    this.content = article.getContent();
    this.createAt = article.getCreateAt();
  }
}
