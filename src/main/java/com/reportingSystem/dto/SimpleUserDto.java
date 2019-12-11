package com.reportingSystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleUserDto {
    private int userId;
    private String username;
    private String email;
    private String mobileNumber;
    private boolean status;
}
