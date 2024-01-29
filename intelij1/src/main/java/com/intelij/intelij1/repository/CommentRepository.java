package com.intelij.intelij1.repository;

import com.intelij.intelij1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
