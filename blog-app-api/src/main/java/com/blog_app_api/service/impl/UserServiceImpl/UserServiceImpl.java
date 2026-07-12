package com.blog_app_api.service.impl.UserServiceImpl;

import com.blog_app_api.Repository.UserRepository;
import com.blog_app_api.entity.User;
import com.blog_app_api.exceptions.ResourceNotFoundException;
import com.blog_app_api.payload.UserDTO;
import com.blog_app_api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository UserRepo;
    private final ModelMapper modalMapper;

    public UserServiceImpl(UserRepository UserRepo,
                           ModelMapper modalMapper) {
        this.UserRepo = UserRepo;
        this.modalMapper = modalMapper;
    }

    @Override
    public UserDTO getUserById(int userId) {
        User user= UserRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        return userToDto(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> userList= UserRepo.findAll();
       List<UserDTO>userDtoList=userList.stream().map(user -> userToDto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public UserDTO updateUserData(UserDTO userDto, Integer userId) {
        User user= UserRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser=UserRepo.save(user);

        UserDTO userDto1 = userToDto(updatedUser);
        return userDto1;
    }

    @Override
    public UserDTO createUserData(UserDTO user) {
        User User = this.dtoToUser(user);
        User savedUser= this.UserRepo.save(User);

        return this.userToDto(savedUser);
    }

    @Override
    public void deleteUserById(Integer userId) {
        User user=UserRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        UserRepo.delete(user);

    }

    public User dtoToUser (UserDTO userDto){
//        User user =new User();
//        user.setId(userDto.getId());
//        user.setUserName(userDto.getUserName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPassword());
        User user = this.modalMapper.map(userDto, User.class);
        return user;
    }

    public UserDTO userToDto (User user){
//        UserDTO userDto =new UserDTO();
//        userDto.setId(user.getId());
//        userDto.setUserName(user.getUserName());
//        userDto.setEmail(user.getEmail());
//        userDto.setAbout(user.getAbout());
//        userDto.setPassword(user.getPassword());
        UserDTO userDto= modalMapper.map(user, UserDTO.class);
        return userDto;
    }


}
