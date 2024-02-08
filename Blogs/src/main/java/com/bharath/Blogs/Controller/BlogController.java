package com.bharath.Blogs.Controller;

import com.bharath.Blogs.Dtos.BlogRequestDto;
import com.bharath.Blogs.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping("/add")
    public String createBlog(@RequestParam Integer userId, @RequestBody BlogRequestDto blogRequestDto)
    {
        return blogService.addBlog(userId, blogRequestDto);
    }
}
