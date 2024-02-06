package com.bharath.Blogs.Controller;

import com.bharath.Blogs.Dtos.UserRequestDto;
import com.bharath.Blogs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(RequestBody UserRequestDto userRequestDto)
    {
        userService
    }
}
