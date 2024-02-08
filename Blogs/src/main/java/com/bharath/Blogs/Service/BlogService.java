package com.bharath.Blogs.Service;

import com.bharath.Blogs.Dtos.BlogRequestDto;
import com.bharath.Blogs.Model.Blog;
import com.bharath.Blogs.Model.User;
import com.bharath.Blogs.Repository.BlogRepository;
import com.bharath.Blogs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

    public String addBlog(Integer userId, BlogRequestDto blogRequestDto)
    {
        //create a blog at the current time
        Blog blog = new Blog();
        User user = userRepository.findById(userId).get();

        //updating the blog details
        blog.setUser(user);
        blog.setTitle(blogRequestDto.getTitle());
        blog.setContent(blogRequestDto.getContent());
        blog.setPubDate(new Date());

        //Updating the userInformation and changing its blogs
        List<Blog> currentBlogs = user.getBlogList();
        currentBlogs.add(blog);
        user.setBlogList(currentBlogs);

        //Only calling the parent userRepository function as the child function will automatically be called by cascading
        userRepository.save(user);

        return "Blog added successfully";
    }
}
