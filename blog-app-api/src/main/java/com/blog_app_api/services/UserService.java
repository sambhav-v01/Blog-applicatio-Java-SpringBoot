package com.blog_app_api.services;

import com.blog_app_api.entity.User;
import com.blog_app_api.payload.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;



public interface UserService {

    UserDTO getUserById (int id);

    List<UserDTO> getAllUser();

    UserDTO updateUserData(UserDTO user, Integer userId);

    UserDTO createUserData(UserDTO user);

    void  deleteUserById (Integer userId);




}
