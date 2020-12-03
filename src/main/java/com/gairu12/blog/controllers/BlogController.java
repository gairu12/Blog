package com.gairu12.blog.controllers;

import com.gairu12.blog.models.Post;
import com.gairu12.blog.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
@AllArgsConstructor
public class BlogController {

    private final PostService postService;

    @GetMapping
    public String blogMain(Model model){
        model.addAttribute("posts", postService.findAllPosts());
        return "blog-main";
    }

    @GetMapping("/add")
    public String blogAdd(){
        return "blog-add";
    }

    @PostMapping("/add")
    public String blogPostAdd( //TODO: формирование объекта на фронте. @RequestMapping Post post
            @RequestParam String title,
            @RequestParam String fullText
    ){
        postService.savePost(title, fullText);
        return "redirect:/blog";
    }

    @GetMapping("/{id}")
    public String blogDetails(
            @PathVariable(value = "id") long postId,
            Model model
    ){
        Post found = postService.getPost(postId);
        if (found == null) {
            return "redirect:/blog";
        }
        model.addAttribute("post", found);
        return "blog-details";
    }

    @GetMapping("/{id}/edit")
    public String blogDetailsEdit(
            @PathVariable(value = "id") long postId,
            Model model
    ){
        Post found = postService.getPost(postId);
        if (found == null) {
            return "redirect:/blog";
        }
        model.addAttribute("post", found);
        return "blog-edit";
    }

    @PostMapping("/{id}/edit")
    public String blogPostUpdate(//TODO: формирование объекта на фронте. @RequestMapping Post updatedPost
            @PathVariable(value = "id") long postId,
            @RequestParam String title,
            @RequestParam String fullText
    ){
        postService.updatePost(postId, title, fullText);
        return "redirect:/blog";
    }

    @PostMapping("/{id}/remove")
    public String blogPostDelete(
            @PathVariable(value = "id") long postId
    ){
        postService.deletePost(postId);
        return "redirect:/blog";
    }


    }


