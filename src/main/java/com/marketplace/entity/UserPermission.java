package com.marketplace.entity;

import javax.persistence.*;

/**
 * @author salomao.marcos@gmail.com
 * @since 26/05/17
 */
@Entity
@Table(name = "USER_PERMISSION")
public class UserPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(targetEntity = AbstractUserEntity.class)
    private AbstractUserEntity entity;

    @Column(name = "user_id")
    private String user;
    private Boolean reading = false;
    private Boolean writing = false;
    private Boolean deleting = false;

    public UserPermission() {
        super();
    }

    public UserPermission(String user, AbstractUserEntity entity, boolean reading, boolean writing, boolean delete) {
        this.setUser(user);
        this.setEntity(entity);
        this.setReading(reading);
        this.setWriting(writing);
        this.setDeleting(delete);
    }

    public AbstractUserEntity getEntity() {
        return entity;
    }

    public void setEntity(AbstractUserEntity entity) {
        this.entity = entity;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getReading() {
        return reading;
    }

    public void setReading(Boolean reading) {
        this.reading = reading;
    }

    public Boolean getWriting() {
        return writing;
    }

    public void setWriting(Boolean writing) {
        this.writing = writing;
    }

    public Boolean getDeleting() {
        return deleting;
    }

    public void setDeleting(Boolean deleting) {
        this.deleting = deleting;
    }

}
