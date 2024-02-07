package com.bharath.Blogs.Controller;

import com.bharath.Blogs.Dtos.UserPasswordChangeDto;
import com.bharath.Blogs.Dtos.UserRequestDto;
import com.bharath.Blogs.Model.User;
import com.bharath.Blogs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserRequestDto userRequestDto)
    {
       return userService.createUser(userRequestDto);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser (@PathVariable int userId)
    {
        return userService.deleteUser(userId);
    }

    @PutMapping("/update/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserPasswordChangeDto userPasswordChangeDto)
    {
        return userService.updateUser(userId, userPasswordChangeDto);
    }
}
