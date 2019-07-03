package com.svj.zis.service;

import com.svj.zis.model.User;
import com.svj.zis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getLoggedUser() throws Exception {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) auth
                    .getPrincipal();
            return userRepository.findByUsername(user.getUsername());
        } catch (Exception e) {
            throw new Exception("Nije pronadjen ulogovani korisnik!");
        }

    }
}
