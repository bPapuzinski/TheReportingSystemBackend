package com.reportingSystem.service;

import com.reportingSystem.dto.UserDto;
import com.reportingSystem.model.UserModel;

public interface UserService {
    UserModel getUser(String username);

    void createUser(UserDto userDto);

    UserDto getUserDetails(String username);
}
