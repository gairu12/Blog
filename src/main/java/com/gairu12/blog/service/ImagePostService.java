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

    public ImagePost getGallery(long id){
        return imagePostRepo.findById(id).get();
    }

    public void updateGallery(long galleryId, File file){
        ImagePost imagePost = imagePostRepo
                .findById(galleryId)
                .orElseThrow();
        imagePost.setFile(file);
        imagePostRepo.save(imagePost);

    }
    public void saveGallery(File file) {
        ImagePost imagePost = new ImagePost(file);
        imagePostRepo.save(imagePost);
    }

    public Iterable<ImagePost> findAllGallery() {
        return imagePostRepo.findAll();
    }

}
