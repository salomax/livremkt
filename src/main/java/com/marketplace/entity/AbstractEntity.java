package com.marketplace.entity;

import com.google.appengine.repackaged.com.google.gson.Gson;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@MappedSuperclass
public abstract class AbstractEntity<T> implements Serializable {

    public abstract T getId();

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof AbstractEntity)) {
            return false;
        }
        AbstractEntity other = (AbstractEntity) obj;
        return getId().equals(other.getId());
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}