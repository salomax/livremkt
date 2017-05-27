package com.marketplace.exception;

/**
 * @author salomao.marcos@gmail.com
 * @since 26/05/17
 */
public abstract class EntityException extends APIExeption {

    private Object id;

    public EntityException(Object id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

}
