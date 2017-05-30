package com.marketplace.entity;

import javax.persistence.MappedSuperclass;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@MappedSuperclass
public abstract class Person extends AbstractUserEntity {

    private String name;
    private String email;
    private String telephone;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
