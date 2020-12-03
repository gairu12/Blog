package com.gairu12.blog.service;


import com.gairu12.blog.models.ImagePost;
import com.gairu12.blog.repo.ImagePostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class ImagePostService {

    private final ImagePostRepo imagePostRepo;

    public ImagePost getImage(long id){
        return imagePostRepo.findById(id).get();
    }

    public void updateImage(long imageId, File file){
        ImagePost imagePost = imagePostRepo
                .findById(imageId)
                .orElseThrow();
        imagePost.setFile(file);
        imagePostRepo.save(imagePost);

    }
    public void saveImage(File file) {
        ImagePost imagePost = new ImagePost(file);
        imagePostRepo.save(imagePost);
    }

    public void deleteImage(long imageId,File file){
        ImagePost imagePost = imagePostRepo
                .findById(imageId)
                .orElseThrow();

        imagePostRepo.delete(imagePost);
    }

//    public void deletePost(long postId) {
//        Post post = postRepo
//                .findById(postId)
//                .orElseThrow();
//
//        postRepo.delete(post);
//    }
    public Iterable<ImagePost> findAllImage() {
        return imagePostRepo.findAll();
    }

}
