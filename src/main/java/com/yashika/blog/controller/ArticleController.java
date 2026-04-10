package com.yashika.blog.controller;

import com.yashika.blog.model.Article;
import com.yashika.blog.service.ArticleService;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService service;

    public ArticleController(ArticleService service){
        this.service = service;
    }

    @GetMapping
    public List<Article> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Article create(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam("image") MultipartFile file
    ) throws IOException {

        return service.createWithImage(title, content, file);
    }
}
