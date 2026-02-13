package com.web.blog.controller;

import com.web.blog.domain.Article;
import com.web.blog.dto.ArticleListViewResponse;
import com.web.blog.dto.ArticleViewResponse;
import com.web.blog.service.BlogService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/articles")
@Controller
public class BlogViewController {

  private final BlogService blogService;

  @GetMapping()
  public String getArticles(Model model){
    List<ArticleListViewResponse> articles = blogService.findAll().stream()
        .map(ArticleListViewResponse::new)
        .toList();
    model.addAttribute("articles", articles);

    return "articleList";   //articleList.html이라는 뷰 조회
  }

  @GetMapping("/{id}")
  public String getArticle(@PathVariable Long id, Model model){
    Article article = blogService.findById(id);
    model.addAttribute("article", new ArticleViewResponse(article));

    return "article";
  }

}
