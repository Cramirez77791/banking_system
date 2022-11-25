package com.co.tita.payments.core.controllers;

import com.co.tita.payments.core.dtos.UserDto;
import com.co.tita.payments.core.entity.users.User;
import com.co.tita.payments.core.reports.ResponseReport;
import com.co.tita.payments.core.reports.UserReport;
import com.co.tita.payments.core.service.users.UserService;
import com.co.tita.payments.core.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<ResponseReport> addUser(@RequestBody UserDto userDto) {
        ResponseReport reportResponseReport = new ResponseReport<UserReport>();
        UserReport userReport = new UserReport();
        if (null == userDto) {
            reportResponseReport.setMessage("The DTO can't be empty");
            return new ResponseEntity<>(reportResponseReport, null, HttpStatus.BAD_REQUEST);
        }

        if (null == userDto.getUserName()) {
            reportResponseReport.setMessage("The userName is required");
            return new ResponseEntity<>(reportResponseReport, null, HttpStatus.BAD_REQUEST);
        }

        if (null == userDto.getPassWord()) {
            reportResponseReport.setMessage("The password is required");
            return new ResponseEntity<>(reportResponseReport, null, HttpStatus.BAD_REQUEST);
        }

        userDto.setActive(true);

        User user = userService.saveUser(userDto);

        userReport.setUserName(user.getUserName());
        userReport.setId(user.getId());
        userReport.setActive(user.isActive());
        userReport.setFullName(user.getFullName());
        reportResponseReport.setMessage("success");
        reportResponseReport.setEntity(userReport);

        return new ResponseEntity<>(reportResponseReport, null, HttpStatus.CREATED);
    }

@GetMapping("/get")
public ResponseEntity<UserReport> getUserData(@RequestParam("username") String username){
    UserReport userReport =userService.getByUserName(username);
    return new ResponseEntity<>(userReport,null,HttpStatus.OK);
}

}
