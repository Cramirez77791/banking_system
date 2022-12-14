package com.co.tita.payments.core.service.users.impl;

import static java.util.Collections.emptyList;

import com.co.tita.payments.core.repository.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.co.tita.payments.core.entity.users.User usurious = userRepository.findUserByUserName(username);
        if (usurious == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(usurious.getUserName(), usurious.getPassWord(), emptyList());
    }
}