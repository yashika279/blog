package com.yashika.blog.service;

import com.yashika.blog.repository.ArticleRepository;
import com.yashika.blog.service.ArticleService;
import com.yashika.blog.model.Article;
import com.yashika.blog.model.Comment;
import com.yashika.blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepo;
    private final ArticleRepository articleRepo;

    public CommentService(CommentRepository commentRepo, ArticleRepository articleRepo){
        this.commentRepo = commentRepo;
        this.articleRepo = articleRepo;
    }

    public Comment addComment(Long articleId, Comment comment){
        Article article= articleRepo.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found") );

        comment.setArticle(article);
        return commentRepo.save(comment);
    }

    public List<Comment> getByArticleId(Long articleId){
        return commentRepo.findByArticleId(articleId);
    }
}
