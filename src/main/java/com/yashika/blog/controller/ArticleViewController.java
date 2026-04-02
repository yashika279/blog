package com.yashika.blog.controller;

import com.yashika.blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleViewController {

    private final ArticleService service;

    public ArticleViewController(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/ui/articles")
    public String getArticles(Model model) {
        model.addAttribute("articles", service.getAll());
        return "articles"; // maps to articles.html
    }
}