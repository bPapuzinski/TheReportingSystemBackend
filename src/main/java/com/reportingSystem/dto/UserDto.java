package com.reportingSystem.dto;

import com.reportingSystem.model.RoleModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private int userId;
    private String username;
    private String email;
    private String password;
    private String mobileNumber;
    private boolean status;
    private List<RoleModel> roles;
}
