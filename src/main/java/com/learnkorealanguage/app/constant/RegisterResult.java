package com.learnkorealanguage.app.constant;

public enum RegisterResult {
    REGISTER_SUCCESS,
    INVALID_USERNAME,
    INVALID_PASSWORD,
    INVALID_CONFIRM_PASSWORD,
    PASSWORD_ADD_CONFIRM_PASSWORD_NOT_MATCH,
    SYSTEM_ERROR,
    USERNAME_EXISTS;
}
