package com.blog_app_api.controller;

import com.blog_app_api.payload.UserDTO;
import com.blog_app_api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    UserController (UserService userService){
        this.userService=userService;
    }
    @PostMapping("/")
    public ResponseEntity<UserDTO> createuser(@Valid @RequestBody UserDTO userDto){
      UserDTO createduser=  userService.createUserData(userDto);
      return new ResponseEntity<>(createduser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody  UserDTO userDto, @PathVariable Integer id){
       UserDTO updatedUserDto = userService.updateUserData(userDto,id);
    return ResponseEntity.ok(updatedUserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
      userService.deleteUserById(id);
     return new ResponseEntity<>(Map.of("message","User deleted Successfuly"), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> allUserDto=userService.getAllUser();
        return ResponseEntity.ok(allUserDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> userGetById(@PathVariable Integer id){
      UserDTO userGetByid=  userService.getUserById(id);
      return  ResponseEntity.ok(userGetByid);
    }









}

