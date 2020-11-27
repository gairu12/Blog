package com.gairu12.blog.controllers;


import com.gairu12.blog.service.ImagePostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
public class ImagePostController {

    private ImagePostService imagePostService;

    @GetMapping("/gallery")
    public String gallery(Model model){
        model.addAttribute("gallery", imagePostService.findAllGallery());

        return "gallery";
    }

    @PostMapping("/gallery/add")
    public String galleryAdd(@RequestParam File file){
        imagePostService.saveGallery(file);
        return "/gallery";
    }

}
