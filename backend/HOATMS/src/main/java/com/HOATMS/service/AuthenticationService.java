package com.HOATMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.HOATMS.dto.LoginUserDto;
import com.HOATMS.dto.RegisterUserDto;
import com.HOATMS.model.User;
import com.HOATMS.repository.UserRepository;


@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public User signup(RegisterUserDto user){
        User savedUser = new User();
        savedUser.setUsername(user.getUsername());
        savedUser.setRole(user.getRole());
        savedUser.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(savedUser);
    }

    public User authenticate(LoginUserDto login){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        return userRepository.findByUsername(login.getUsername()).orElseThrow();
    }

    public User findUserByUsername(String username){
        Optional<User> userId = userRepository.findByUsername(username);
        return userId.get();
    }

    public User changePassword(Long userId, User user){
        User oldPassword = userRepository.findById(userId).orElseThrow();
        oldPassword.setPassword(passwordEncoder.encode(user.getPassword()));

       User updatedPassword = userRepository.save(oldPassword);

       return updatedPassword;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

}