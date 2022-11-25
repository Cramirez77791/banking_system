package com.co.tita.payments.core.repository.users;

import com.co.tita.payments.core.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findById(Long id);

    Optional<User> findUserByUserNameAndPassWord(String username, String password);

    User findUserByUserName(String username);


}
