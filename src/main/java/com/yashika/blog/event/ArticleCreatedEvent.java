package com.yashika.blog.event;

import com.yashika.blog.model.Article;

public class ArticleCreatedEvent {
    private final Article article;

    public ArticleCreatedEvent(Article article){
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }
}
