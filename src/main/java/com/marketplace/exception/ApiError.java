package com.marketplace.exception;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
public class ApiError {

    private String message;

    public ApiError(APIExeption apiExeption) {
        this.message = apiExeption.getMessage();
    }

    public String getMessage() {
        return message;
    }

}
