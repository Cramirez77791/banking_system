package com.co.tita.payments.core.service.users.impl;

import com.co.tita.payments.core.dtos.UserDto;
import com.co.tita.payments.core.entity.users.User;
import com.co.tita.payments.core.repository.users.UserRepository;
import com.co.tita.payments.core.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return  userOptional.get();
        }
        return null;
    }

    @Override
    public User getUserByUserNameAndPassword(String userName, String password) {
        Optional<User> userOptional = userRepository.findUserByUserNameAndPassWord(userName,password);
        if(userOptional.isPresent()){
            return  userOptional.get();
        }
        return null;
    }

    @Override
    public User saveUser(UserDto userDto) {
        User newUser = new User();
        newUser.setUserName(userDto.getUserName());
        newUser.setActive(true);
        newUser.setPassWord(userDto.getPassWord());
        userRepository.saveAndFlush(newUser);
        return newUser;
    }


}
