package com.gairu12.blog.service;

import com.gairu12.blog.models.Post;
import com.gairu12.blog.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;

    public Post getPost(long postId) {
        return postRepo.findById(postId).get();
    }

    public void updatePost(long postId, String title, String fullText) {
        Post post = postRepo
                .findById(postId)
                .orElseThrow();
        post.setTitle(title);
        post.setFullText(fullText);
        postRepo.save(post);
    }

    public void deletePost(long postId) {
        Post post = postRepo
                .findById(postId)
                .orElseThrow();

        postRepo.delete(post);
    }

    public void savePost(String title, String fullText) {
        Post post = new Post(title, fullText);
        postRepo.save(post);
    }

    public Iterable<Post> findAllPosts() {
        return postRepo.findAll();
    }
}
