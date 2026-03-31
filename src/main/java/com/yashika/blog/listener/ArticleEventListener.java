package com.yashika.blog.listener;

import com.yashika.blog.event.ArticleCreatedEvent;
import com.yashika.blog.model.Article;
import com.yashika.blog.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ArticleEventListener {

    private final EmailService emailService;

    public ArticleEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener
    public void handleArticleCreated(ArticleCreatedEvent event) {
        Article article = event.getArticle();

        // Send email to admin
        emailService.sendEmail(
                "yashikavijay2799@gmail.com",
                "New Article Created",
                "Article titled '" + article.getTitle() + "' has been created."
        );
    }
}