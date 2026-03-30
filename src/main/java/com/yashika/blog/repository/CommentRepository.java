package com.yashika.blog.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yashika.blog.model.Comment;
public interface CommentRepository extends JpaRepository<Comment, Long>{
}
