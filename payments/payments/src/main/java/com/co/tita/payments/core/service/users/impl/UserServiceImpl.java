package com.co.tita.payments.core.service.users.impl;

import com.co.tita.payments.core.dtos.UserDto;
import com.co.tita.payments.core.entity.users.User;
import com.co.tita.payments.core.reports.UserReport;
import com.co.tita.payments.core.repository.users.UserRepository;
import com.co.tita.payments.core.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
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
        newUser.setFullName(userDto.getFullName());
        newUser.setPassWord(bCryptPasswordEncoder.encode(userDto.getPassWord()));
        userRepository.saveAndFlush(newUser);
        return newUser;
    }

    @Override
    public UserReport getByUserName(String userName) {
        UserReport userReport = new UserReport();
        User user =userRepository.findUserByUserName(userName);
        userReport.setId(user.getId());
        userReport.setUserName(user.getUserName());
        userReport.setFullName(user.getFullName());
        return userReport;
    }


}
