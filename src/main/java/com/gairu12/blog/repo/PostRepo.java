package com.gairu12.blog.repo;

import com.gairu12.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long> {
}
