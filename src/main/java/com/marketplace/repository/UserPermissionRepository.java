package com.marketplace.repository;

import com.marketplace.entity.AbstractUserEntity;
import com.marketplace.entity.UserPermission;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author salomao.marcos@gmail.com
 * @since 27/05/17
 */
public interface UserPermissionRepository extends CrudRepository<UserPermission, Integer> {

    List<UserPermission> findByEntity(AbstractUserEntity userEntity);

}
