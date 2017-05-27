package com.marketplace.exception;

/**
 * @author salomao.marcos@gmail.com
 * @since 26/05/17
 */
public class UserAccessException extends EntityException {

    public UserAccessException(String id) {
        super(id);
    }

    @Override
    public String getMessage() {
        return "messages.security.accessdeny";
    }
}
