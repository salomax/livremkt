package com.marketplace.exception;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
public class EntityNotFoundException extends Exception {

    private Integer id;

    public EntityNotFoundException(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
