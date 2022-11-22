package com.co.tita.payments.core.controllers;

import com.co.tita.payments.core.dtos.UserDto;
import com.co.tita.payments.core.entity.users.User;
import com.co.tita.payments.core.reports.UserReport;
import com.co.tita.payments.core.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

@PostMapping("/create")
public ResponseEntity<UserReport> addUser(@RequestBody UserDto userDto){
    UserReport userReport = new UserReport();
    if(null == userDto){
        userReport.setMessage("The DTO can't be empty");
        return new ResponseEntity<>(userReport,null, HttpStatus.BAD_REQUEST);
    }

    if (null == userDto.getUserName()){
        userReport.setMessage("The userName is required");
        return new ResponseEntity<>(userReport,null,HttpStatus.BAD_REQUEST);
    }

    if (null == userDto.getPassWord()){
        userReport.setMessage("The password is required");
        return new ResponseEntity<>(userReport,null,HttpStatus.BAD_REQUEST);
    }

    userDto.setActive(true);

    User user =userService.saveUser(userDto);

    userReport.setUserName(user.getUserName());
    userReport.setId(user.getId());
    userReport.setActive(user.isActive());
    userReport.setMessage("success");

    return new ResponseEntity<>(userReport,null,HttpStatus.CREATED);
}




}
