package com.marketplace.controller;

import com.marketplace.exception.ApiError;
import com.marketplace.exception.EntityNotFoundException;
import com.marketplace.exception.UserAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiError exception(final EntityNotFoundException exception) {
        return new ApiError(exception) {
            public Object getId() {
                return exception.getId();
            }
        };
    }

    @ExceptionHandler(UserAccessException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ApiError exception(final UserAccessException exception) {
        return new ApiError(exception) {
            public Object getId() {
                return exception.getId();
            }
        };
    }

}

