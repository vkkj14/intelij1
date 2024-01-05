package com.intelij.intelij1.repository;



import com.intelij.intelij1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
