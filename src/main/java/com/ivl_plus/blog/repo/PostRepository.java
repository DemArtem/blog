package com.ivl_plus.blog.repo;

import com.ivl_plus.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}

