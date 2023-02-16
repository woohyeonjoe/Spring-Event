package com.example.springevent.user.ui;

import com.example.springevent.user.application.UserRequest;
import com.example.springevent.user.application.UserResponse;
import com.example.springevent.user.application.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Void> create(@RequestBody UserRequest userRequest) {
        userService.create(userRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<UserResponse> get(@PathVariable("email") String email) {
        UserResponse response = userService.get(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
