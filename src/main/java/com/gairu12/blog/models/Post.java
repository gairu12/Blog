package com.gairu12.blog.models;


import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String anons;

    private String fullText;

    public Post(String title, String anons, String fullText) {
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
    }
}
