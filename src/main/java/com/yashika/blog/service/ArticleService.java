package com.yashika.blog.service;

import com.yashika.blog.model.Article;
import com.yashika.blog.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepo;

    public ArticleService(ArticleRepository articleRepo){
        this.articleRepo = articleRepo;
    }

    public List<Article> getAll() { return articleRepo.findAll(); }

    public Article create(Article article){
        return articleRepo.save(article);
    }

    public Article getById(Long id){ return articleRepo.findById(id).orElse(null); }

    public void delete(Long id){
        articleRepo.deleteById(id);
    }

}
