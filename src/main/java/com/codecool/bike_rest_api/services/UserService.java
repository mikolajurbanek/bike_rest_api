package com.codecool.bike_rest_api.services;

import com.codecool.bike_rest_api.models.User;
import com.codecool.bike_rest_api.models.Role;
import com.codecool.bike_rest_api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    protected final UserRepository userRepository;

    public User createUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.getEmailDetails().setPassword(encoder.encode(user.getEmailDetails().getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRole(roles);
        userRepository.save(user);
        return user;
    }
}
