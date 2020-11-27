package com.gairu12.blog.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.File;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class ImagePost extends Post{
    private File file;


    public ImagePost(File file) {
        this.file = file;
    }
}
