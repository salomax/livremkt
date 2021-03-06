package com.marketplace.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@Entity
@Table(name = "PRODUCT")
public class Product extends AbstractUserEntity {

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
