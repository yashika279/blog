package com.yashika.blog.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yashika.blog.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findByArticleId(Long articleId);

    Long countByArticleId(Long articleId);
}
