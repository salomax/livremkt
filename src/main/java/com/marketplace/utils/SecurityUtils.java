package com.marketplace.utils;

import com.marketplace.security.GooglePrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author salomao.marcos@gmail.com
 * @since 27/05/17
 */
public class SecurityUtils {

    public static GooglePrincipal getGooglePrincipal() {
        return (GooglePrincipal) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
    }

}
