package com.yashika.blog.controller;

import com.yashika.blog.service.CommentService;
import com.yashika.blog.model.Comment;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

   @PostMapping("/article/{articleId}")
    public Comment add(@PathVariable Long articleId, @RequestBody Comment comment ){
        return commentService.addComment(articleId, comment);
   }

   @GetMapping("/article/{articleId}")
    public List<Comment> getComment(@PathVariable Long articleId){
        return commentService.getByArticleId(articleId);
   }

   @GetMapping("/article/{articleId}/count")
    public long countComment(@PathVariable Long articleId){
        return commentService.countCommentsByArticleId(articleId);
   }
}
