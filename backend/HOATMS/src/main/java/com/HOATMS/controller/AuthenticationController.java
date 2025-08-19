package com.HOATMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HOATMS.dto.LoginResponse;
import com.HOATMS.dto.LoginUserDto;
import com.HOATMS.dto.RegisterUserDto;
import com.HOATMS.model.User;
import com.HOATMS.service.AuthenticationService;
import com.HOATMS.service.JwtService;

@CrossOrigin("*")

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody RegisterUserDto user) {
        User registerUser = authenticationService.signup(user);
        return ResponseEntity.ok(registerUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto userLogin) {
        User authenticatedUser = authenticationService.authenticate(userLogin);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = authenticationService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/byUsername")
    public ResponseEntity<User> getUserByUsername(@RequestParam String username) {
        User getUser = authenticationService.findUserByUsername(username);
        return ResponseEntity.ok(getUser);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getStudentCount() {
        int count = authenticationService.getAllUser().size();
        return ResponseEntity.ok(count);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> changePassword(@PathVariable("id") Long userId, @RequestBody User user) {
        User updatedPassword = authenticationService.changePassword(userId, user);
        return ResponseEntity.ok(updatedPassword);
    }

}
