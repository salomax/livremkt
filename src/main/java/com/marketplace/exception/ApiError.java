package com.marketplace.exception;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
public class ApiError {

    private String message;

    public ApiError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
