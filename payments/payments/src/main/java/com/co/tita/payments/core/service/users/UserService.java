package com.co.tita.payments.core.service.users;

import com.co.tita.payments.core.dtos.UserDto;
import com.co.tita.payments.core.entity.users.User;

public interface UserService {

    User getUserById(Long id);

    User getUserByUserNameAndPassword(String userName, String password);

    User saveUser(UserDto userDto);

}
