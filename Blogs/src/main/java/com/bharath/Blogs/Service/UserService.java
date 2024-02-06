package com.bharath.Blogs.Service;

import com.bharath.Blogs.Dtos.UserRequestDto;
import com.bharath.Blogs.Model.User;
import com.bharath.Blogs.Repository.UserRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@Builder
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(UserRequestDto userRequestDto)
    {
        User user = User.bui
    }
}
