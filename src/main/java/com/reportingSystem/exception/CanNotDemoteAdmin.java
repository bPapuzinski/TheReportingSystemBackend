package com.reportingSystem.exception;

public class CanNotDemoteAdmin extends RuntimeException {
    public CanNotDemoteAdmin(String message) {
        super(message);
    }
}
