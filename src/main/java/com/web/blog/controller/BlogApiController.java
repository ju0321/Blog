package com.web.blog.controller;

import com.web.blog.dto.ArticleResponse;
import com.web.blog.dto.UpdateArticleRequest;
import com.web.blog.service.BlogService;
import com.web.blog.domain.Article;
import com.web.blog.dto.AddArticleRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/articles")
public class BlogApiController {

  private final BlogService blogService;

  @PostMapping()
  public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest articleRequest) {

    return ResponseEntity.status(201)
        .body( blogService.saveArticle(articleRequest));
  }

  @GetMapping()
  public ResponseEntity<List<ArticleResponse>> findAllArticles() {
    List<ArticleResponse> articles = blogService.findAll()
        .stream()
        .map(ArticleResponse::new)
        .toList();
    return ResponseEntity.ok().body(articles);
  }

  @GetMapping("/{article-id}")
  public ResponseEntity<ArticleResponse> findArticleById(@PathVariable(value="article-id") Long id) {
    Article article = blogService.findById(id);

    return ResponseEntity.ok().body(new ArticleResponse(article));
  }

  @DeleteMapping("/{article-id}")
  public ResponseEntity<Void> deleteArticleById(@PathVariable(value="article-id") Long id) {
    blogService.deleteById(id);
    return ResponseEntity.status(404).build();
  }

  @PutMapping("/{article-id}q")
  public ResponseEntity<Article> updateArticleById(@PathVariable(value="article-id") Long id, @RequestBody UpdateArticleRequest articleRequest) {
    Article updateArticle = blogService.update(id, articleRequest);
    return ResponseEntity.ok().body(updateArticle);
  }

}
