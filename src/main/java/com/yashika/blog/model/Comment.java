package com.yashika.blog.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "article_id")
    @JsonBackReference

    private Article article;

    public Comment() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Article getArticle() { return article; }
    public void setArticle(Article article) { this.article = article; }
}
