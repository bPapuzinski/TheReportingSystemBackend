package com.reportingSystem.dto;

import com.reportingSystem.model.RoleModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private int userId;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String mobileNumber;
    private boolean status;
    private List<RoleModel> roles;
}
