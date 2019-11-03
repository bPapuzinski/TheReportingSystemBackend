package com.reportingSystem.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomResponse {

    private int httpCode;
    private String message;
}
