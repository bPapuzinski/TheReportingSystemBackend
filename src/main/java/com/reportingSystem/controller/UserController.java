package com.reportingSystem.controller;

import com.reportingSystem.dto.SimpleUserDto;
import com.reportingSystem.dto.UserDto;
import com.reportingSystem.exception.CustomNotFound;
import com.reportingSystem.exception.CustomResponse;
import com.reportingSystem.exception.NotUniqueUser;
import com.reportingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity createUser(@Valid @RequestBody UserDto userDto) {
        try {
            userService.createUser(userDto);
            return ResponseEntity.status(201).body(new CustomResponse(201, "Account Created"));
        } catch (NotUniqueUser e) {
            return ResponseEntity.status(409).body(new CustomResponse(409, e.getMessage()));
        }
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/registerWorker")
    public ResponseEntity createWorker(@Valid @RequestBody UserDto userDto) {
        try {
            userService.createWorker(userDto);
            return ResponseEntity.status(201).body(new CustomResponse(201, "Account Created"));
        } catch (NotUniqueUser e) {
            return ResponseEntity.status(409).body(new CustomResponse(409, e.getMessage()));
        }
    }

    @GetMapping("user/{username}")
    public ResponseEntity getUserDetails(@PathVariable String username) {
        try {
            UserDto userDto = userService.getUserDetails(username);
            return ResponseEntity.status(200).body(userDto);
        } catch (CustomNotFound e) {
            return ResponseEntity.status(404).body(new CustomResponse(404, e.getMessage()));
        }
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("user")
    public List<SimpleUserDto> getUsersList() {
        return userService.getUsersList();
    }

}
