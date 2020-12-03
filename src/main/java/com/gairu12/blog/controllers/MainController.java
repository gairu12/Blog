package com.gairu12.blog.controllers;

import com.gairu12.blog.models.ImagePost;
import com.gairu12.blog.service.ImagePostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;

@Controller
public class MainController {
    @Value("${upload.path}")
    private String uploadPath;
    public static ImagePostService imagePostService;


    @GetMapping("/")
    public String Main(){
        return "home";
    }
    @GetMapping("/about")
    public String blogAbout(){
        return "about";
    }




    @GetMapping("/image")
    public String image(){
        return "image";
    }

    @PostMapping("/image/add")
    public String imageAdd(@RequestParam File file)
            throws IOException {
        ImagePost imagePost = new ImagePost(file);
        if (file == null){
            File uploadDir = new File(uploadPath);

            if (uploadDir.exists()){
                uploadDir.mkdir();
            }
            imagePostService.saveImage(file);
        }
        return "image";
    }

//    public String add(
//			@AuthenticationPrincipal User user,
//			@RequestParam String text,
//			@RequestParam String tag,
//			@RequestParam MultipartFile file,
//			Map<String, Object> model
//	) throws IOException {
//		Message message = new Message(text, tag, user);
//		if (!file.isEmpty()){
//			File uploadDir = new File(uploadPath);
//
//			if (!uploadDir.exists()){
//				uploadDir.mkdir();
//			}
//			String uuidFile = UUID.randomUUID().toString();
//			String resultFilename = uuidFile + "." + file.getOriginalFilename();
//
//			file.transferTo(new File(uploadPath + "/" + resultFilename));
//			message.setFileName(resultFilename);
//		}
//
//		messageRepo.save(message);
//		Iterable<Message> messages = messageRepo.findAll();
//
//		model.put("messages", messages);
//
//		return "main";

    @PostMapping("/image/edit")
    public String imageUpdate(
            @RequestParam File file
    ){
        return "image";
    }

    @PostMapping("/image/delete")
    public String imageDelete(
            @PathVariable(value = "id") long imageId,
            @RequestParam File file
    ){
        imagePostService.deleteImage(imageId, file);
        return "image";
    }

//    @PostMapping("/{id}/edit")
//    public String blogPostUpdate(//TODO: формирование объекта на фронте. @RequestMapping Post updatedPost
//                                 @PathVariable(value = "id") long postId,
//                                 @RequestParam String title,
//                                 @RequestParam String fullText
//    ){
//        postService.updatePost(postId, title, fullText);
//        return "redirect:/blog";
//    }
}
