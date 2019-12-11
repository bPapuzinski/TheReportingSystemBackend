package com.reportingSystem.service;

import com.reportingSystem.dto.SimpleUserDto;
import com.reportingSystem.dto.UserDto;
import com.reportingSystem.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel getUser(String username);

    void createUser(UserDto userDto);

    void createWorker(UserDto userDto);

    void createAdmin(UserDto userDto);

    UserDto getUserDetails(String username);

    List<SimpleUserDto> getUsersList();
}
