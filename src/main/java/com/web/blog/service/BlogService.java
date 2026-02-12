package com.web.blog.service;

import com.web.blog.domain.Article;
import com.web.blog.dto.AddArticleRequest;
import com.web.blog.dto.ArticleResponse;
import com.web.blog.dto.UpdateArticleRequest;
import com.web.blog.repository.BlogRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
@Slf4j
public class BlogService {
  private final BlogRepository blogRepository;

  public Article saveArticle(AddArticleRequest articleRequest) {
    return blogRepository.save(articleRequest.toEntity());
  }

  public List<Article> findAll() {
    return blogRepository.findAll();
  }

  public Article findById(Long id) {
    return blogRepository.findById(id).orElseThrow(() ->
        new IllegalArgumentException("not found: " + id));
  }

  public void deleteById(Long id) {
    blogRepository.deleteById(id);
  }

  @Transactional
  public Article update(Long id, UpdateArticleRequest articleRequest) {
    Article article = blogRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

    article.update(articleRequest.getTitle(), articleRequest.getContent());

    return article;
  }
}
