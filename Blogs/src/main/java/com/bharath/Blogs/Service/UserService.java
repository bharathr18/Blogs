package com.bharath.Blogs.Service;

import com.bharath.Blogs.Dtos.UserPasswordChangeDto;
import com.bharath.Blogs.Dtos.UserRequestDto;
import com.bharath.Blogs.Exception.ResourceNotFoundException;
import com.bharath.Blogs.Model.User;
import com.bharath.Blogs.Repository.UserRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("*")
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUser(UserRequestDto userRequestDto)
    {
        User user = User.builder().firstName(userRequestDto.getFirstName()).lastName(userRequestDto.getLastName()).userName(userRequestDto.getUserName()).passWord(userRequestDto.getPassWord()).build();

        try {
            userRepository.save(user);
        }
        catch (Exception e)
        {
            return "User could not be added";
        }
        return "User added successfully";
    }

    public String deleteUser(int userId)
    {
        try {
            userRepository.deleteById(userId);
        }
        catch (Exception e)
        {
            return "User could not be deleted";
        }
        return "User deleted successfully";
    }

    public String updateUser(int userId, UserPasswordChangeDto userPasswordChangeDto)
    {
            User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User does not exist with id: " + userId));

            user.setPassWord(userPasswordChangeDto.getPassCord());

            userRepository.save(user);

            return "User updated successfully";
    }
}
