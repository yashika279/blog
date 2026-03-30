package com.yashika.blog.model;
import com.yashika.blog.model.Comment;
import jakarta.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String content;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;

    public Article() {}

    public Long getId() {return id; }
    public void setId (Long id){ this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getContent() { return content; }
    public void setContent(String content) {this.content = content;}
}
