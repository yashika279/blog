package com.yashika.blog.service;

import com.yashika.blog.model.Article;
import com.yashika.blog.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import com.yashika.blog.event.ArticleCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepo;
    private final ApplicationEventPublisher publisher;

    public ArticleService(ArticleRepository articleRepo, ApplicationEventPublisher publisher){
        this.articleRepo = articleRepo;
        this.publisher = publisher;
    }

    public List<Article> getAll() { return articleRepo.findAll(); }

    public Article create(Article article){
        Article saved = articleRepo.save(article);
        publisher.publishEvent(new ArticleCreatedEvent(saved));
        return saved;
    }

    public Article getById(Long id){ return articleRepo.findById(id).orElse(null); }

    public void delete(Long id){
        articleRepo.deleteById(id);
    }

}
