package com.marketplace.repository;

import com.marketplace.entity.AbstractUserEntity;
import com.marketplace.exception.UserAccessException;
import com.marketplace.utils.BeanUtils;

import javax.annotation.PreDestroy;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.logging.Logger;

/**
 * @author salomao.marcos@gmail.com
 * @since 26/05/17
 */
public class UserEntityListener {

    private static final Logger log = Logger.getLogger(UserEntityListener.class.getName());

    @PrePersist
    public void createUserPermission(final AbstractUserEntity userEntity) {
        UserEntityFilter filter = BeanUtils.getBean(UserEntityFilter.class);
        filter.insertUserPermission(userEntity);
    }

    @PreUpdate
    public void onUpdate(final AbstractUserEntity userEntity) throws UserAccessException {
        UserEntityFilter filter = BeanUtils.getBean(UserEntityFilter.class);
        if (!filter.canWrite(userEntity.getUserPermissions())) {
            throw new UserAccessException(userEntity.getId());
        }
    }

    @PreDestroy
    public void onDelete(final AbstractUserEntity userEntity) throws UserAccessException {
        UserEntityFilter filter = BeanUtils.getBean(UserEntityFilter.class);
        if (!filter.canDelete(userEntity.getUserPermissions())) {
            throw new UserAccessException(userEntity.getId());
        }
    }

    @PostLoad
    public void onLoad(final AbstractUserEntity userEntity) throws UserAccessException {
        UserEntityFilter filter = BeanUtils.getBean(UserEntityFilter.class);
        if (!filter.canRead(userEntity.getUserPermissions())) {
            throw new UserAccessException(userEntity.getId());
        }
    }

}
