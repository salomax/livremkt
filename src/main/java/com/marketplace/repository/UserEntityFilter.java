package com.marketplace.repository;

import com.marketplace.entity.AbstractUserEntity;
import com.marketplace.entity.UserPermission;
import com.marketplace.security.GooglePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.marketplace.utils.SecurityUtils.getGooglePrincipal;

/**
 * @author salomao.marcos@gmail.com
 * @since 26/05/17
 */
@Component
public class UserEntityFilter {

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    public void insertUserPermission(AbstractUserEntity userEntity) {
        UserPermission userPermission = new UserPermission(
                getGooglePrincipal().getEmail(), userEntity, true, true, true);
        userEntity.getUserPermissions().add(userPermission);
    }

    public boolean canRead(List<UserPermission> userPermissions) {

        GooglePrincipal principal = getGooglePrincipal();

        for (UserPermission userPermission : userPermissions) {
            if (principal.getEmail().equals(userPermission.getUser())
                && userPermission.getReading()) {
                return true;
            }
        }

        return false;
    }

    public boolean canWrite(List<UserPermission> userPermissions) {

        GooglePrincipal principal = getGooglePrincipal();

        for (UserPermission userPermission : userPermissions) {
            if (principal.getEmail().equals(userPermission.getUser())
                    && userPermission.getWriting()) {
                return true;
            }
        }

        return false;
    }

    public boolean canDelete(List<UserPermission> userPermissions) {

        GooglePrincipal principal = getGooglePrincipal();

        for (UserPermission userPermission : userPermissions) {
            if (principal.getEmail().equals(userPermission.getUser())
                    && userPermission.getDeleting()) {
                return true;
            }
        }

        return false;
    }

}
