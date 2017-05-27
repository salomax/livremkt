package com.marketplace.exception;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
public class EntityNotFoundException extends EntityException {

    public EntityNotFoundException(Object id) {
        super(id);
    }

    @Override
    public String getMessage() {
        return "messages.entity.notfound";
    }

}
