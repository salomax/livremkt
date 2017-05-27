package com.marketplace.repository;

import com.marketplace.entity.UserPermission;
import org.springframework.data.repository.CrudRepository;

/**
 * @author salomao.marcos@gmail.com
 * @since 27/05/17
 */
public interface UserPermissionRepository extends CrudRepository<UserPermission, Integer> {
}
